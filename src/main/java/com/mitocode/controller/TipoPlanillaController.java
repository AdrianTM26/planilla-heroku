package com.mitocode.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mitocode.dto.ResponseWrapper;
import com.mitocode.dto.TipoPlanillaDTO;
import com.mitocode.exception.ExceptionResponse;
import com.mitocode.model.Contrato;
import com.mitocode.model.Empresa;
import com.mitocode.model.Perfil;
import com.mitocode.model.TipoPlanilla;
import com.mitocode.model.TipoPlanillaDetalle;
import com.mitocode.model.TipoPlanillaPerfil;
import com.mitocode.model.Trabajador;
import com.mitocode.service.ContratoService;
import com.mitocode.service.TipoPlanPerfilService;
import com.mitocode.service.TipoPlanillaDetalleService;
import com.mitocode.service.TipoPlanillaService;
import com.mitocode.util.Constantes;

@RestController
@RequestMapping("/api/tipoPlanilla")
public class TipoPlanillaController {

	@Autowired
	TipoPlanillaService service;

	@Autowired
	TipoPlanPerfilService service_tpp;

	@Autowired
	TipoPlanillaDetalleService service_tpd;
	
	@Autowired
	ContratoService service_contrato;

	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	@PostMapping("/registrar")
	public ResponseWrapper registrar(@RequestBody TipoPlanillaDTO tipPlanDTO) throws Exception {

		try {
			ResponseWrapper response = new ResponseWrapper();
			TipoPlanilla tipPlan = new TipoPlanilla();
			tipPlan = tipPlanDTO.getTipoPlanilla();
			tipPlan.setEmpresa(tipPlanDTO.getEmpresa());

			List<Perfil> lsPerfil = tipPlanDTO.getLsPerfil();

			TipoPlanilla resp = service.registrar(tipPlan);
			if (resp != null) {
				response.setDefaultObj(resp);
				response.setMsg(Constantes.msgRegistrarTipoPlanillaOK);
				response.setEstado(Constantes.valTransaccionOk);

				for (Perfil perfil : lsPerfil) {
					TipoPlanillaPerfil tipoPlanPerfil = new TipoPlanillaPerfil();
					tipoPlanPerfil.setTipoPlanilla(resp);
					tipoPlanPerfil.setPerfil(perfil);
					tipoPlanPerfil.setEstado(perfil.getAmbito());
					service_tpp.registrar(tipoPlanPerfil);
				}
			} else {
				response.setMsg(Constantes.msgRegistrarTipoPlanillaError);
				response.setEstado(Constantes.valTransaccionError);
			}

			return response;

		} catch (Exception e) {
			System.out.println(this.getClass().getSimpleName() + " registrarTipoPlanilla. ERROR : " + e.getMessage());
			throw new ExceptionResponse(new Date(), this.getClass().getSimpleName() + "/insertar",
					e.getStackTrace()[0].getFileName() + " => " + e.getStackTrace()[0].getMethodName() + " => "
							+ e.getClass() + " => message: " + e.getMessage() + "=> linea nro: "
							+ e.getStackTrace()[0].getLineNumber(),
					tipPlanDTO);
		}
	}

	@PostMapping("/listarPorTipoPlanilla")
	public ResponseWrapper listarPorTipoPlanilla(@RequestBody TipoPlanilla tipoPlanilla) throws Exception {
		try {
			ResponseWrapper response = new ResponseWrapper();
			List<TipoPlanillaPerfil> lsTipPlanPerfil = service_tpp.listarPorTipoPlanilla(tipoPlanilla);
			response.setEstado(Constantes.valTransaccionOk);
			response.setAaData(lsTipPlanPerfil);
			return response;
		} catch (Exception e) {
			System.out.println(this.getClass().getSimpleName() + " listarPorTipoPlanilla. ERROR : " + e.getMessage());
			throw new ExceptionResponse(new Date(), this.getClass().getSimpleName() + "/listarPorTipoPlanilla",
					e.getStackTrace()[0].getFileName() + " => " + e.getStackTrace()[0].getMethodName() + " => "
							+ e.getClass() + " => message: " + e.getMessage() + "=> linea nro: "
							+ e.getStackTrace()[0].getLineNumber(),
					tipoPlanilla);
		}
	}

	@PutMapping("/modificarPlanillaPerfil")
	public ResponseWrapper modificarPlanillaPerfil(@RequestBody TipoPlanillaDTO tipoPlanillaDTO) throws Exception {
		try {
			ResponseWrapper response = new ResponseWrapper();
			List<TipoPlanillaPerfil> lsTipoPlanillaPerfil = tipoPlanillaDTO.getLsTipoPlanillaPerfil();
			for (TipoPlanillaPerfil tpp : lsTipoPlanillaPerfil) {
				service_tpp.modificar(tpp);
			}
			response.setEstado(Constantes.valTransaccionOk);
			response.setMsg(Constantes.msgModificarPerfilesTipoPlanillaOk);
			return response;
		} catch (Exception e) {
			System.out.println(this.getClass().getSimpleName() + " modificarPlanillaPerfil. ERROR : " + e.getMessage());
			throw new ExceptionResponse(new Date(), this.getClass().getSimpleName() + "/modificarPlanillaPerfil",
					e.getStackTrace()[0].getFileName() + " => " + e.getStackTrace()[0].getMethodName() + " => "
							+ e.getClass() + " => message: " + e.getMessage() + "=> linea nro: "
							+ e.getStackTrace()[0].getLineNumber(),
					tipoPlanillaDTO);
		}
	}

	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	@PostMapping("/modificar")
	public ResponseWrapper modificar(@RequestBody TipoPlanilla tipoPlan) {
		ResponseWrapper response = new ResponseWrapper();

		TipoPlanilla valTipPlan = service.encontrarTipPlan(tipoPlan);

		if (tipoPlan.getCategoriaPlanilla() == valTipPlan.getCategoriaPlanilla()) {
			TipoPlanilla resp = service.modificar(tipoPlan);

			if (resp != null) {
				response.setMsg(Constantes.msgModificarTipoPlanillaOK);
				response.setEstado(Constantes.valTransaccionOk);
				response.setDefaultObj(resp);
			} else {
				response.setMsg(Constantes.msgModificarTipoPlanillaError);
				response.setEstado(Constantes.valTransaccionError);
			}
		} else {
			Boolean eliminados = service_tpd.eliminar(tipoPlan);
			TipoPlanilla resp_tipPlan = service.modificar(tipoPlan);
			if (!eliminados && resp_tipPlan != null) {
				response.setMsg(Constantes.msgModificarTipoPlanillaOK);
				response.setEstado(Constantes.valTransaccionOk);
				response.setDefaultObj(resp_tipPlan);
			} else {
				response.setMsg(Constantes.msgModificarTipoPlanillaError);
				response.setEstado(Constantes.valTransaccionError);
			}
		}

		return response;
	}

	@PostMapping("/listarPorEmpresa")
	public ResponseWrapper listarPorEmpresa(@RequestBody Empresa empresa) throws Exception {
		try {
			ResponseWrapper response = new ResponseWrapper();
			List<TipoPlanilla> lsTipPlan = service.listarPorEmpresa(empresa);
			response.setEstado(Constantes.valTransaccionOk);
			response.setMsg(Constantes.msgListarTipoPlanillaOk);
			response.setAaData(lsTipPlan);
			return response;
		} catch (Exception e) {
			System.out.println(
					this.getClass().getSimpleName() + " listarTipoPlanillaPorEmpresa. ERROR : " + e.getMessage());
			throw new ExceptionResponse(new Date(), this.getClass().getSimpleName() + "/listarPorEmpresa",
					e.getStackTrace()[0].getFileName() + " => " + e.getStackTrace()[0].getMethodName() + " => "
							+ e.getClass() + " => message: " + e.getMessage() + "=> linea nro: "
							+ e.getStackTrace()[0].getLineNumber(),
					empresa);
		}
	}
	
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	@PostMapping("/eliminarTPD")
	public ResponseWrapper eliminarTPD(@RequestBody TipoPlanillaDTO tipPlanDTO) throws Exception {
		try {
			ResponseWrapper response = new ResponseWrapper();
			Boolean resp = service_tpd.eliminarTPD(tipPlanDTO.getLsTipoPlanillaDetalle());
			if (!resp) {
				response.setEstado(Constantes.valTransaccionOk);
				response.setMsg(Constantes.msgQuitarTrabajadoresTipoPlanillaOk);
				response.setDefaultObj(resp);
			} else {
				response.setEstado(Constantes.valTransaccionError);
				response.setMsg(Constantes.msgQuitarTrabajadoresTipoPlanillaError);
			}
			return response;
		} catch (Exception e) {
			System.out.println(
					this.getClass().getSimpleName() + " eliminarTPD. ERROR : " + e.getMessage());
			throw new ExceptionResponse(new Date(), this.getClass().getSimpleName() + "/listarPorEmpresa",
					e.getStackTrace()[0].getFileName() + " => " + e.getStackTrace()[0].getMethodName() + " => "
							+ e.getClass() + " => message: " + e.getMessage() + "=> linea nro: "
							+ e.getStackTrace()[0].getLineNumber(),
							tipPlanDTO);
		}
	}

	@DeleteMapping("/{idTipoPlanilla}")
	public ResponseWrapper eliminar(@PathVariable("idTipoPlanilla") Integer id) throws Exception {
		try {
			ResponseWrapper response = new ResponseWrapper();
			Boolean resp = service.eliminar(id);
			if (resp) {
				response.setEstado(Constantes.valTransaccionOk);
				response.setMsg(Constantes.msgEliminarTipoPlanillaOk);
				response.setDefaultObj(resp);
			} else {
				response.setEstado(Constantes.valTransaccionError);
				response.setMsg(Constantes.msgEliminarTipoPlanillaError);
				response.setDefaultObj(resp);
			}
			return response;
		} catch (Exception e) {
			System.out.println(this.getClass().getSimpleName() + " eliminarTipoPlanilla. ERROR : " + e.getMessage());
			throw new ExceptionResponse(new Date(), this.getClass().getSimpleName() + "/" + id,
					e.getStackTrace()[0].getFileName() + " => " + e.getStackTrace()[0].getMethodName() + " => "
							+ e.getClass() + " => message: " + e.getMessage() + "=> linea nro: "
							+ e.getStackTrace()[0].getLineNumber(),
					id);
		}
	}

	@PostMapping("/registrarTrabajador")
	public ResponseWrapper registrarTrabajadores(@RequestBody TipoPlanillaDTO tipoPlanillaDTO) throws Exception {
		try {
			ResponseWrapper response = new ResponseWrapper();
			List<TipoPlanillaDetalle> lsTipDetalle = service.registrarTrabajadores(tipoPlanillaDTO.getLsTrabajador(),
					tipoPlanillaDTO.getTipoPlanilla());
			if (lsTipDetalle != null) {
				response.setEstado(Constantes.valTransaccionOk);
				response.setMsg(Constantes.msgRegistrarTrabajadoresTipoPlanillaOk);
				response.setAaData(lsTipDetalle);
			} else {
				response.setEstado(Constantes.valTransaccionError);
				response.setMsg(Constantes.msgRegistrarTrabajadoresTipoPlanillaError);
			}
			return response;
		} catch (Exception e) {
			System.out.println(this.getClass().getSimpleName() + " eliminarTipoPlanilla. ERROR : " + e.getMessage());
			throw new ExceptionResponse(new Date(), this.getClass().getSimpleName() + "/asignarTrabajador",
					e.getStackTrace()[0].getFileName() + " => " + e.getStackTrace()[0].getMethodName() + " => "
							+ e.getClass() + " => message: " + e.getMessage() + "=> linea nro: "
							+ e.getStackTrace()[0].getLineNumber(),
					tipoPlanillaDTO);
		}

	}
	
	@PostMapping("/listarPorPerfil")
	public ResponseWrapper listarPorPerfil(@RequestBody Perfil perfil) throws Exception {
		try {
			ResponseWrapper response = new ResponseWrapper();
			List<TipoPlanilla> lsTipoPlanilla = service.listarPorPerfil(perfil);
			response.setEstado(Constantes.valTransaccionOk);
			response.setMsg(Constantes.msgListarTipoPlanillaOk);
			response.setAaData(lsTipoPlanilla);
			return response;
		} catch (Exception e) {
			System.out.println(this.getClass().getSimpleName() + " listarPorPerfil. ERROR : " + e.getMessage());
			throw new ExceptionResponse(new Date(), this.getClass().getSimpleName() + "/listarPorPerfil",
					e.getStackTrace()[0].getFileName() + " => " + e.getStackTrace()[0].getMethodName() + " => "
							+ e.getClass() + " => message: " + e.getMessage() + "=> linea nro: "
							+ e.getStackTrace()[0].getLineNumber(),
					perfil);
		}
	}
	
	@PostMapping("/listarTrabajadoresPorTipoPlanilla")
	public ResponseWrapper listarTrabajadoresPorTipoPlanilla(@RequestBody TipoPlanilla tipoPlanilla) throws Exception{
		try {
			ResponseWrapper response = new ResponseWrapper();
			int tipoCategoria = 0;
			if(tipoPlanilla.getCategoriaPlanilla()==4) { 
				tipoCategoria = 1;
			} else { 
				tipoCategoria = 2;
			}
			
			List<Contrato> lscontrato = service_contrato.listarPorEmpresaYTipoComp(tipoPlanilla.getEmpresa(), tipoCategoria);
			List<Contrato> lstrabajadorArmado = service_tpd.armarListContrato(lscontrato, tipoPlanilla);
			response.setEstado(Constantes.valTransaccionOk);
			response.setAaData(lstrabajadorArmado);
			return response;
		}catch(Exception e) {
			System.out.println(this.getClass().getSimpleName() + " listarTrabajadoresPorTipoPlanilla. ERROR : " + e.getMessage());
			throw new ExceptionResponse(new Date(), this.getClass().getSimpleName() + "/listarTrabajadoresPorTipoPlanilla",
					e.getStackTrace()[0].getFileName() + " => " + e.getStackTrace()[0].getMethodName() + " => "
							+ e.getClass() + " => message: " + e.getMessage() + "=> linea nro: "
							+ e.getStackTrace()[0].getLineNumber(),
					tipoPlanilla);
		}
	}
	
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	@PostMapping("/listarTrabajadores")
	public ResponseWrapper listarTrabajodesLibres(@RequestBody TipoPlanilla tipPlan) throws Exception {
		try {
			ResponseWrapper response = new ResponseWrapper();
			int tipoCategoria = 0;
			if(tipPlan.getCategoriaPlanilla()==4) { tipoCategoria = 1;
			} else { tipoCategoria = 2;}
			
			List<Contrato> lscontrato = service_contrato.listarPorEmpresaYTipoComp(tipPlan.getEmpresa(), tipoCategoria);
			List<Trabajador> lstrabajador = new ArrayList<>();
			for (Contrato contrato : lscontrato) {
				lstrabajador.add(contrato.getTrabajador());
			}
			
			List<Trabajador> lstrabajadorArmado = service_tpd.armarListTrab(lstrabajador);
			response.setEstado(Constantes.valTransaccionOk);
			response.setAaData(lstrabajadorArmado);
			return response;
		} catch (Exception e) {
			System.out.println(this.getClass().getSimpleName() + " listarPorPerfil. ERROR : " + e.getMessage());
			throw new ExceptionResponse(new Date(), this.getClass().getSimpleName() + "/listarPorPerfil",
					e.getStackTrace()[0].getFileName() + " => " + e.getStackTrace()[0].getMethodName() + " => "
							+ e.getClass() + " => message: " + e.getMessage() + "=> linea nro: "
							+ e.getStackTrace()[0].getLineNumber(),
							tipPlan);
		}
	}
	
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	@PostMapping("/listarTrabajadoresAsignados")
	public ResponseWrapper listarTrabajodesAsignados(@RequestBody TipoPlanilla tipPlan) throws Exception {
		try {
			ResponseWrapper response = new ResponseWrapper();
			List lstipPlaDet = service_tpd.listarTrabAsignados(tipPlan);
			response.setAaData(lstipPlaDet);
			return response;
		} catch (Exception e) {
			System.out.println(this.getClass().getSimpleName() + " listarPorPerfil. ERROR : " + e.getMessage());
			throw new ExceptionResponse(new Date(), this.getClass().getSimpleName() + "/listarPorPerfil",
					e.getStackTrace()[0].getFileName() + " => " + e.getStackTrace()[0].getMethodName() + " => "
							+ e.getClass() + " => message: " + e.getMessage() + "=> linea nro: "
							+ e.getStackTrace()[0].getLineNumber(),
							tipPlan);
		}
	}

}

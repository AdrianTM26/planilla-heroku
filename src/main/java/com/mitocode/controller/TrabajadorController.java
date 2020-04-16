package com.mitocode.controller;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mitocode.dto.ResponseWrapper;
import com.mitocode.dto.TrabajadorDTO;
import com.mitocode.exception.ExceptionResponse;
import com.mitocode.model.Contrato;
import com.mitocode.model.Empresa;
import com.mitocode.model.Trabajador;
import com.mitocode.service.ContratoService;
import com.mitocode.service.TrabajadorService;
import com.mitocode.util.Constantes;

@RestController
@RequestMapping("/api/trabajador")
public class TrabajadorController {

	@Autowired
	TrabajadorService serviceTrabajador;

	@Autowired
	ContratoService serviceContrato;

	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	@PostMapping("/registrar")
	public ResponseWrapper registrar(@Valid @RequestBody TrabajadorDTO trabajadorDTO, BindingResult result)
			throws Exception {

		if (result.hasErrors()) {
			List<String> errors = result.getFieldErrors().stream().map(err -> {
				return err.getDefaultMessage();
			}).collect(Collectors.toList());
			throw new ExceptionResponse(new Date(), this.getClass().getSimpleName() + "/registrar",
					"Error en la validacion: Lista de Errores:" + errors.toString(), trabajadorDTO);
		}

		try {
			ResponseWrapper response = new ResponseWrapper();
			Trabajador res_traba = new Trabajador();
			Trabajador tmp_traba = this.crearTrabajador(trabajadorDTO);
			Contrato tmp_contra = this.crearContrato(trabajadorDTO);

			res_traba = serviceTrabajador.registrar(tmp_traba);
			Contrato res_contra = new Contrato();
			tmp_contra.setTrabajador(res_traba);
			res_contra = serviceContrato.registrar(tmp_contra);
			if (res_contra != null) {
				response.setEstado(Constantes.valTransaccionOk);
				response.setMsg(Constantes.msgRegistrarTrabajadorOK);
				response.setDefaultObj(res_traba);

			} else {
				response.setEstado(Constantes.valTransaccionError);
				response.setMsg(Constantes.msgRegistrarTrabajadorError);
			}
			return response;

		} catch (Exception e) {
			System.out.println(this.getClass().getSimpleName() + " registrarTrabajador. ERROR : " + e.getMessage());
			throw new ExceptionResponse(new Date(), this.getClass().getSimpleName() + "/registrar",
					e.getStackTrace()[0].getFileName() + " => " + e.getStackTrace()[0].getMethodName() + " => "
							+ e.getClass() + " => message: " + e.getMessage() + "=> linea nro: "
							+ e.getStackTrace()[0].getLineNumber(),
					trabajadorDTO);
		}
	}

	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	@PutMapping("/modificar")
	public ResponseWrapper modificar(@Valid @RequestBody TrabajadorDTO trabajadorDTO, BindingResult result)
			throws Exception {

		if (result.hasErrors()) {
			List<String> errors = result.getFieldErrors().stream().map(err -> {
				return err.getDefaultMessage();
			}).collect(Collectors.toList());
			throw new ExceptionResponse(new Date(), this.getClass().getSimpleName() + "/modificar",
					"Error en la validacion: Lista de Errores:" + errors.toString(), trabajadorDTO);
		}

		try {
			ResponseWrapper response = new ResponseWrapper();
			Trabajador res_traba = new Trabajador();
			Trabajador tmp_trabajador = new Trabajador();
			tmp_trabajador = trabajadorDTO.getTrabajador();
			;
			tmp_trabajador.setHorario(trabajadorDTO.getHorario());
			tmp_trabajador.setTipoDoc(trabajadorDTO.getTipoDoc());
			tmp_trabajador.setPais(trabajadorDTO.getPais());
			tmp_trabajador.setEstadoCivil(trabajadorDTO.getEstadoCivil());
			tmp_trabajador.setDepartamento(trabajadorDTO.getDepartamento());
			tmp_trabajador.setProvincia(trabajadorDTO.getProvincia());
			tmp_trabajador.setDistrito(trabajadorDTO.getDistrito());
			tmp_trabajador.setTipoZona(trabajadorDTO.getTipoZona());
			tmp_trabajador.setNivelEdu(trabajadorDTO.getNivelEdu());
			tmp_trabajador.setOcupacion(trabajadorDTO.getOcupacion());
			tmp_trabajador.setEmpresa(trabajadorDTO.getEmpresa());
			tmp_trabajador.setAfp(trabajadorDTO.getAfp());
			tmp_trabajador.setEps(trabajadorDTO.getEpsRegSalud());
			tmp_trabajador.setRegSalud(trabajadorDTO.getRegSalud());
			tmp_trabajador.setSituacion(trabajadorDTO.getSituacion());
			Contrato tmp_contra = this.obtenerContrato(trabajadorDTO);
			tmp_contra.setBancoCts(trabajadorDTO.getBancoCts());
			tmp_contra.setBancoSueldo(trabajadorDTO.getBancoSueldo());
			tmp_contra.setCargo(trabajadorDTO.getCargo());
			tmp_contra.setCategoria(trabajadorDTO.getCategoria());
			tmp_contra.setCentroCosto(trabajadorDTO.getCentroCosto());
			tmp_contra.setRegimenLaboral(trabajadorDTO.getRegimenLaboral());
			tmp_contra.setSctrPension(trabajadorDTO.getSctrPension());
			tmp_contra.setSctrSalud(trabajadorDTO.getSctrSalud());
			tmp_contra.setEpsSalud(trabajadorDTO.getEpsSalud());
			tmp_contra.setEpsPension(trabajadorDTO.getEpsPension());
			tmp_contra.setTipoContrato(trabajadorDTO.getTipoContrato());
			tmp_contra.setTipoPago(trabajadorDTO.getTipoPago());
			tmp_contra.setTrabajador(trabajadorDTO.getTrabajador());

			res_traba = serviceTrabajador.modificar(tmp_trabajador);
			if (res_traba != null) {
				Contrato res_contra = new Contrato();
				res_contra = serviceContrato.modificar(tmp_contra);
				if (res_contra != null) {
					response.setEstado(Constantes.valTransaccionOk);
					response.setMsg(Constantes.msgModificarTrabajadorOK);
					response.setDefaultObj(res_traba);
				} else {
					response.setEstado(Constantes.valTransaccionError);
					response.setMsg(Constantes.msgModificarTrabajadorError);
				}
			} else {
				response.setEstado(Constantes.valTransaccionError);
				response.setMsg(Constantes.msgModificarTrabajadorError);
			}
			return response;
		} catch (Exception e) {
			System.out.println(this.getClass().getSimpleName() + " modificarTrabajador. ERROR : " + e.getMessage());
			throw new ExceptionResponse(new Date(), this.getClass().getSimpleName() + "/modificar",
					e.getStackTrace()[0].getFileName() + " => " + e.getStackTrace()[0].getMethodName() + " => "
							+ e.getClass() + " => message: " + e.getMessage() + "=> linea nro: "
							+ e.getStackTrace()[0].getLineNumber(),
					trabajadorDTO);
		}
	}

	@Secured({ "ROLE_ADMIN" })
	@PostMapping("/porEmpresa") // noseusa
	public ResponseWrapper listarPorEmpresa(@RequestBody Empresa empresa) throws Exception {

		if (empresa.getIdEmpresa() == null) {
			throw new ExceptionResponse(new Date(), this.getClass().getSimpleName() + "/porEmpresa",
					Constantes.msgListarTrabajadorError + " no se ha especificado una empresa valida", empresa);
		}

		try {
			ResponseWrapper response = new ResponseWrapper();
			List lstra = serviceContrato.listarPorEmpresa(empresa);
			if (lstra != null) {
				response.setEstado(Constantes.valTransaccionOk);
				response.setMsg(Constantes.msgListarTrabajadorOk);
				response.setAaData(lstra);
			} else {
				response.setEstado(Constantes.valTransaccionError);
				response.setMsg(Constantes.msgListarTrabajadorError);
			}
			return response;
		} catch (Exception e) {
			System.out.println(
					this.getClass().getSimpleName() + " listarTrabajadorPorEmpresa. ERROR : " + e.getMessage());
			throw new ExceptionResponse(new Date(), this.getClass().getSimpleName() + "/porEmpresa",
					e.getStackTrace()[0].getFileName() + " => " + e.getStackTrace()[0].getMethodName() + " => "
							+ e.getClass() + " => message: " + e.getMessage() + "=> linea nro: "
							+ e.getStackTrace()[0].getLineNumber(),
					empresa);
		}
	}

	@Secured({ "ROLE_ADMIN" })
	@PostMapping("/porEmpresayTipoComprobante/{idComprobante}")
	public ResponseWrapper listarPorEmpresaYTipoComprobante(@RequestBody Empresa empresa,
			@PathVariable("idComprobante") Integer tipoComp) throws Exception {

		if (empresa.getIdEmpresa() == null) {
			throw new ExceptionResponse(new Date(),
					this.getClass().getSimpleName() + "/porEmpresayTipoComprobante/" + tipoComp,
					Constantes.msgListarTrabajadorError + " no se ha especificado una empresa valida", empresa);
		}

		try {
			ResponseWrapper response = new ResponseWrapper();
			List lstra = serviceContrato.listarPorEmpresaYTipoComp(empresa, tipoComp);
			if (lstra != null) {
				response.setEstado(Constantes.valTransaccionOk);
				response.setMsg(Constantes.msgListarTrabajadorOk);
				response.setAaData(lstra);
			} else {
				response.setEstado(Constantes.valTransaccionError);
				response.setMsg(Constantes.msgListarTrabajadorError);
			}
			return response;
		} catch (Exception e) {
			System.out.println(this.getClass().getSimpleName() + " listarTrabajadorPorEmpresayTipoComprobante. ERROR : "
					+ e.getMessage());
			throw new ExceptionResponse(new Date(),
					this.getClass().getSimpleName() + "/porEmpresayTipoComprobante/" + tipoComp,
					e.getStackTrace()[0].getFileName() + " => " + e.getStackTrace()[0].getMethodName() + " => "
							+ e.getClass() + " => message: " + e.getMessage() + "=> linea nro: "
							+ e.getStackTrace()[0].getLineNumber(),
					empresa);
		}
	}

	public Trabajador crearTrabajador(TrabajadorDTO trabajadorDTO) {
		try {
			Trabajador res_trabajador = new Trabajador();
			res_trabajador = trabajadorDTO.getTrabajador();
			res_trabajador.setTipoDoc(trabajadorDTO.getTipoDoc());
			res_trabajador.setPais(trabajadorDTO.getPais());
			res_trabajador.setHorario(trabajadorDTO.getHorario());
			res_trabajador.setEstadoCivil(trabajadorDTO.getEstadoCivil());
			res_trabajador.setDepartamento(trabajadorDTO.getDepartamento());
			res_trabajador.setProvincia(trabajadorDTO.getProvincia());
			res_trabajador.setDistrito(trabajadorDTO.getDistrito());
			res_trabajador.setTipoZona(trabajadorDTO.getTipoZona());
			res_trabajador.setNivelEdu(trabajadorDTO.getNivelEdu());
			res_trabajador.setOcupacion(trabajadorDTO.getOcupacion());
			res_trabajador.setEmpresa(trabajadorDTO.getEmpresa());
			res_trabajador.setAfp(trabajadorDTO.getAfp());
			res_trabajador.setEps(trabajadorDTO.getEpsRegSalud());
			res_trabajador.setRegSalud(trabajadorDTO.getRegSalud());
			res_trabajador.setSituacion(trabajadorDTO.getSituacion());
			return res_trabajador;
		} catch (Exception e) {
			System.out.println(this.getClass().getSimpleName() + " crearTrabajador. ERROR : " + e.getMessage());
			throw e;
		}
	}

	public Contrato crearContrato(TrabajadorDTO trabajadorDTO) {
		try {
			Contrato res_contrato = new Contrato();
			res_contrato = trabajadorDTO.getContrato();
			res_contrato.setRegimenLaboral(trabajadorDTO.getRegimenLaboral());
			res_contrato.setTipoContrato(trabajadorDTO.getTipoContrato());
			res_contrato.setCentroCosto(trabajadorDTO.getCentroCosto());
			res_contrato.setCategoria(trabajadorDTO.getCategoria());
			res_contrato.setCargo(trabajadorDTO.getCargo());
			res_contrato.setTipoPago(trabajadorDTO.getTipoPago());
			res_contrato.setBancoSueldo(trabajadorDTO.getBancoSueldo());
			res_contrato.setBancoCts(trabajadorDTO.getBancoCts());
			res_contrato.setSctrPension(trabajadorDTO.getSctrPension());
			res_contrato.setSctrSalud(trabajadorDTO.getSctrSalud());
			res_contrato.setEpsSalud(trabajadorDTO.getEpsSalud());
			res_contrato.setEpsPension(trabajadorDTO.getEpsPension());
			return res_contrato;
		} catch (Exception e) {
			System.out.println(this.getClass().getSimpleName() + " crearContrato. ERROR : " + e.getMessage());
			throw e;
		}
	}

	public Contrato obtenerContrato(TrabajadorDTO trabajadorDTO) {
		try {
			Contrato cont = new Contrato();
			cont = trabajadorDTO.getContrato();
			return cont;

		} catch (Exception e) {
			System.out.println(this.getClass().getSimpleName() + " obtenerContrato. ERROR : " + e.getMessage());
			throw e;
		}
	}

}

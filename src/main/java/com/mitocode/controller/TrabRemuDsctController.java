package com.mitocode.controller;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mitocode.dto.ResponseWrapper;
import com.mitocode.dto.TrabajadorDTO;
import com.mitocode.exception.ExceptionResponse;
import com.mitocode.model.TrabDescuento;
import com.mitocode.model.TrabRemuneracion;
import com.mitocode.model.Trabajador;
import com.mitocode.service.TrabDescuentoService;
import com.mitocode.service.TrabRemuneracionService;
import com.mitocode.util.Constantes;

@RestController
@RequestMapping("/api/trabRemuDsct")
public class TrabRemuDsctController {

	@Autowired
	TrabRemuneracionService service_remu;

	@Autowired
	TrabDescuentoService service_dsct;

	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	@PostMapping("/listarTrabRemu")
	public ResponseWrapper listarTrabRemu(@RequestBody Trabajador trab) throws Exception {
		
		if (trab.getIdTrabajador() == null) {
			throw new ExceptionResponse(new Date(), this.getClass().getSimpleName() + "/listarTrabRemu",
					Constantes.msgListarRemuneracionesError + " no se ha especificado un trabajador valido", trab);
		}
		
		try {
			ResponseWrapper response = new ResponseWrapper();
			List lsTrabRem = service_remu.listarXTrab(trab);

			if (lsTrabRem.size() > 0) {
				response.setEstado(Constantes.valTransaccionOk);
				response.setMsg(Constantes.msgListarRemuneracionesOK);
				response.setAaData(lsTrabRem);
			} else if (lsTrabRem.size() == 0) {
				response.setEstado(Constantes.valTransaccionOk);
				response.setMsg(Constantes.msgListarRemuneracionesOKVacio);
				response.setAaData(lsTrabRem);
			} else {
				response.setEstado(Constantes.valTransaccionError);
				response.setMsg(Constantes.msgListarRemuneracionesError);
			}
			return response;
		} catch (Exception e) {
			System.out.println(this.getClass().getSimpleName() + " listarTrabRemu. ERROR : " + e.getMessage());
			throw new ExceptionResponse(new Date(), this.getClass().getSimpleName() + "/listarTrabRemu",
					e.getStackTrace()[0].getFileName() + " => " + e.getStackTrace()[0].getMethodName() + " => "
							+ e.getClass() + " => message: " + e.getMessage() + "=> linea nro: "
							+ e.getStackTrace()[0].getLineNumber(),
					trab);
		}
	}

	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	@PostMapping("/listarTrabDsct")
	public ResponseWrapper listarTrabDsct(@RequestBody Trabajador trab) throws Exception {
		
		if (trab.getIdTrabajador() == null) {
			throw new ExceptionResponse(new Date(), this.getClass().getSimpleName() + "/listarTrabDsct",
					Constantes.msgListarRemuneracionesError + " no se ha especificado un trabajador valido", trab);
		}
		
		try {
			ResponseWrapper response = new ResponseWrapper();
			List lsTrabDsct = service_dsct.listarXTrab(trab);
			if (lsTrabDsct.size() > 0) {
				response.setEstado(Constantes.valTransaccionOk);
				response.setMsg(Constantes.msgListarDescuentosOK);
				response.setAaData(lsTrabDsct);
			} else if (lsTrabDsct.size() == 0) {
				response.setEstado(Constantes.valTransaccionOk);
				response.setMsg(Constantes.msgListarDescuentosOKVacio);
				response.setAaData(lsTrabDsct);
			} else {
				response.setEstado(Constantes.valTransaccionError);
				response.setMsg(Constantes.msgListarDescuentosError);
			}
			return response;
		} catch (Exception e) {
			System.out.println(this.getClass().getSimpleName() + " listarTrabDsct. ERROR : " + e.getMessage());
			throw new ExceptionResponse(new Date(), this.getClass().getSimpleName() + "/listarTrabDsct",
					e.getStackTrace()[0].getFileName() + " => " + e.getStackTrace()[0].getMethodName() + " => "
							+ e.getClass() + " => message: " + e.getMessage() + "=> linea nro: "
							+ e.getStackTrace()[0].getLineNumber(),
					trab);
		}
	}

	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	@PostMapping("/registrarTrabRemu")
	public ResponseWrapper registrarTrabRemu(@Valid @RequestBody TrabajadorDTO trabDTO, BindingResult result) throws Exception {
		
		if (result.hasErrors()) {
			List<String> errors = result.getFieldErrors().stream().map(err -> {
				return err.getDefaultMessage();
			}).collect(Collectors.toList());
			throw new ExceptionResponse(new Date(), this.getClass().getSimpleName() + "/registrarTrabRemu",
					"Error en la validacion: Lista de Errores:" + errors.toString(), trabDTO);
		}
		
		try {
			ResponseWrapper response = new ResponseWrapper();
			TrabRemuneracion trabRemu = new TrabRemuneracion();
			Boolean resp = service_remu.existe(trabDTO.getRemuneraciones());
			if (resp) {
				response.setEstado(2);
				response.setMsg(Constantes.msgAgregarTrabRemuFail);
			} else {
				trabRemu.setTrabajador(trabDTO.getTrabajador());
				trabRemu.setRemuneraciones(trabDTO.getRemuneraciones());
				trabRemu.setEstado(Constantes.ConsActivo);
				TrabRemuneracion respTrabRem = service_remu.registrar(trabRemu);
				if (respTrabRem != null) {
					response.setEstado(Constantes.valTransaccionOk);
					response.setMsg(Constantes.msgRegistrarRemuneracionOk);
					response.setDefaultObj(respTrabRem);
				} else {
					response.setEstado(Constantes.valTransaccionError);
					response.setMsg(Constantes.msgRegistrarRemuneracionError);
				}
			}
			return response;
		} catch (Exception e) {
			System.out.println(this.getClass().getSimpleName() + " registrarTrabRemu. ERROR : " + e.getMessage());
			throw new ExceptionResponse(new Date(), this.getClass().getSimpleName() + "/registrarTrabRemu",
					e.getStackTrace()[0].getFileName() + " => " + e.getStackTrace()[0].getMethodName() + " => "
							+ e.getClass() + " => message: " + e.getMessage() + "=> linea nro: "
							+ e.getStackTrace()[0].getLineNumber(),
					trabDTO);
		}
	}

	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	@PostMapping("/registrarTrabDsct")
	public ResponseWrapper registrarTrabDsct(@Valid @RequestBody TrabajadorDTO trabDTO, BindingResult result) throws Exception {
		
		if (result.hasErrors()) {
			List<String> errors = result.getFieldErrors().stream().map(err -> {
				return err.getDefaultMessage();
			}).collect(Collectors.toList());
			throw new ExceptionResponse(new Date(), this.getClass().getSimpleName() + "/registrarTrabDsct",
					"Error en la validacion: Lista de Errores:" + errors.toString(), trabDTO);
		}
		
		try {
			ResponseWrapper response = new ResponseWrapper();
			TrabDescuento trabDsct = new TrabDescuento();
			Boolean resp = service_dsct.existe(trabDTO.getDescuentos());
			if (resp) {
				response.setEstado(2);
				response.setMsg(Constantes.msgAgregarTrabDsctFail);
			} else {
			trabDsct.setTrabajador(trabDTO.getTrabajador());
			trabDsct.setDescuentos(trabDTO.getDescuentos());
			trabDsct.setEstado(Constantes.ConsActivo);
			TrabDescuento respTrabDsct = service_dsct.registrar(trabDsct);
			if (respTrabDsct != null) {
				response.setEstado(Constantes.valTransaccionOk);
				response.setMsg(Constantes.msgRegistrarDescuentoOk);
				response.setDefaultObj(respTrabDsct);
			} else {
				response.setEstado(Constantes.valTransaccionError);
				response.setMsg(Constantes.msgRegistrarDescuentoError);
			}
			}
			return response;
		} catch (Exception e) {
			System.out.println(this.getClass().getSimpleName() + " registrarTrabDsct. ERROR : " + e.getMessage());
			throw new ExceptionResponse(new Date(), this.getClass().getSimpleName() + "/registrarTrabDsct",
					e.getStackTrace()[0].getFileName() + " => " + e.getStackTrace()[0].getMethodName() + " => "
							+ e.getClass() + " => message: " + e.getMessage() + "=> linea nro: "
							+ e.getStackTrace()[0].getLineNumber(),
					trabDTO);
		}
	}
	
	@Transactional(propagation = Propagation.REQUIRED,rollbackFor=Exception.class)
	@PostMapping("/darBajaRemu")
	public ResponseWrapper darBajaRemu(@Valid @RequestBody TrabRemuneracion trabRemu, BindingResult result) throws Exception {
		
		if (result.hasErrors()) {
			List<String> errors = result.getFieldErrors().stream().map(err -> {
				return err.getDefaultMessage();
			}).collect(Collectors.toList());
			throw new ExceptionResponse(new Date(), this.getClass().getSimpleName() + "/darBajaRemu",
					"Error en la validacion: Lista de Errores:" + errors.toString(), trabRemu);
		}
		
		try {
			ResponseWrapper response=new ResponseWrapper();
			TrabRemuneracion resp = service_remu.darBaja(trabRemu);
			if(resp!=null) {
				response.setEstado(Constantes.valTransaccionOk);
				response.setMsg(Constantes.msgDarBajaRemuneracionOK);
				response.setDefaultObj(resp);
			}else {
				response.setEstado(Constantes.valTransaccionError);
				response.setMsg(Constantes.msgDarBajaRemuneracionError);
			}
			
			return response;
		}catch(Exception e) {
			System.out.println(this.getClass().getSimpleName() + " darBajaRemu. ERROR : " + e.getMessage());
			throw new ExceptionResponse(new Date(), this.getClass().getSimpleName() + "/darBajaRemu",
					e.getStackTrace()[0].getFileName() + " => " + e.getStackTrace()[0].getMethodName() + " => "
							+ e.getClass() + " => message: " + e.getMessage() + "=> linea nro: "
							+ e.getStackTrace()[0].getLineNumber(),
					trabRemu);
		}				
	}
	
	@Transactional(propagation = Propagation.REQUIRED,rollbackFor=Exception.class)
	@PostMapping("/darBajaDsct")
	public ResponseWrapper darBajaDsct(@Valid @RequestBody TrabDescuento trabDsct, BindingResult result) throws Exception {
		
		if (result.hasErrors()) {
			List<String> errors = result.getFieldErrors().stream().map(err -> {
				return err.getDefaultMessage();
			}).collect(Collectors.toList());
			throw new ExceptionResponse(new Date(), this.getClass().getSimpleName() + "/darBajaDsct",
					"Error en la validacion: Lista de Errores:" + errors.toString(), trabDsct);
		}
		
		try {
			ResponseWrapper response=new ResponseWrapper();
			TrabDescuento resp = service_dsct.darBaja(trabDsct);
			if(resp!=null) {
				response.setEstado(Constantes.valTransaccionOk);
				response.setMsg(Constantes.msgDarBajaDescuentoOK);
				response.setDefaultObj(resp);
			}else {
				response.setEstado(Constantes.valTransaccionError);
				response.setMsg(Constantes.msgDarBajaDescuentoError);
			}
			return response;
		}catch(Exception e) {
			System.out.println(this.getClass().getSimpleName() + " darBajaDsct. ERROR : " + e.getMessage());
			throw new ExceptionResponse(new Date(), this.getClass().getSimpleName() + "/darBajaDsct",
					e.getStackTrace()[0].getFileName() + " => " + e.getStackTrace()[0].getMethodName() + " => "
							+ e.getClass() + " => message: " + e.getMessage() + "=> linea nro: "
							+ e.getStackTrace()[0].getLineNumber(),
					trabDsct);
		}				
	}
	
	
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	@PostMapping("/listarTrabRemuInac")
	public ResponseWrapper listarTrabRemuInac(@RequestBody Trabajador trab) throws Exception {
		
		if (trab.getIdTrabajador() == null) {
			throw new ExceptionResponse(new Date(), this.getClass().getSimpleName() + "/listarTrabRemuInac",
					Constantes.msgListarRemuneracionesError + " no se ha especificado un trabajador valido", trab);
		}
		
		try {
			ResponseWrapper response = new ResponseWrapper();
			List lsTrabRem = service_remu.listarXTrabInac(trab);

			if (lsTrabRem.size() > 0) {
				response.setEstado(Constantes.valTransaccionOk);
				response.setMsg(Constantes.msgListarRemuneracionesOK);
				response.setAaData(lsTrabRem);

			} else if (lsTrabRem.size() == 0) {
				response.setEstado(Constantes.valTransaccionOk);
				response.setMsg(Constantes.msgListarRemuneracionesOKVacio);
				response.setAaData(lsTrabRem);
			} else {
				response.setEstado(Constantes.valTransaccionError);
				response.setMsg(Constantes.msgListarRemuneracionesError);
			}
			return response;
		} catch (Exception e) {
			System.out.println(this.getClass().getSimpleName() + " listarTrabRemuInactivo. ERROR : " + e.getMessage());
			throw new ExceptionResponse(new Date(), this.getClass().getSimpleName() + "/listarTrabRemuInac",
					e.getStackTrace()[0].getFileName() + " => " + e.getStackTrace()[0].getMethodName() + " => "
							+ e.getClass() + " => message: " + e.getMessage() + "=> linea nro: "
							+ e.getStackTrace()[0].getLineNumber(),
					trab);
		}
	}

	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	@PostMapping("/listarTrabDsctInac")
	public ResponseWrapper listarTrabDsctInac(@RequestBody Trabajador trab) throws Exception {
		
		if (trab.getIdTrabajador() == null) {
			throw new ExceptionResponse(new Date(), this.getClass().getSimpleName() + "/listarTrabDsctInac",
					Constantes.msgListarRemuneracionesError + " no se ha especificado un trabajador valido", trab);
		}
		
		try {
			ResponseWrapper response = new ResponseWrapper();
			List lsTrabDsct = service_dsct.listarXTrabInac(trab);
			if (lsTrabDsct.size() > 0) {
				response.setEstado(Constantes.valTransaccionOk);
				response.setMsg(Constantes.msgListarDescuentosOK);
				response.setAaData(lsTrabDsct);
			} else if (lsTrabDsct.size() == 0) {
				response.setEstado(Constantes.valTransaccionOk);
				response.setMsg(Constantes.msgListarDescuentosOKVacio);
				response.setAaData(lsTrabDsct);
			} else {
				response.setEstado(Constantes.valTransaccionError);
				response.setMsg(Constantes.msgListarDescuentosError);
			}
			return response;
		} catch (Exception e) {
			System.out.println(this.getClass().getSimpleName() + " listarTrabDsctInac. ERROR : " + e.getMessage());
			throw new ExceptionResponse(new Date(), this.getClass().getSimpleName() + "/listarTrabDsctInac",
					e.getStackTrace()[0].getFileName() + " => " + e.getStackTrace()[0].getMethodName() + " => "
							+ e.getClass() + " => message: " + e.getMessage() + "=> linea nro: "
							+ e.getStackTrace()[0].getLineNumber(),
					trab);
		}
	}
	
	@Transactional(propagation = Propagation.REQUIRED,rollbackFor=Exception.class)
	@PostMapping("/activarRemu")
	public ResponseWrapper activarRemu(@Valid @RequestBody TrabRemuneracion trabRemu, BindingResult result) throws Exception {
		
		if (result.hasErrors()) {
			List<String> errors = result.getFieldErrors().stream().map(err -> {
				return err.getDefaultMessage();
			}).collect(Collectors.toList());
			throw new ExceptionResponse(new Date(), this.getClass().getSimpleName() + "/activarRemu",
					"Error en la validacion: Lista de Errores:" + errors.toString(), trabRemu);
		}
		
		try {
			ResponseWrapper response=new ResponseWrapper();
			trabRemu.setEstado(Constantes.ConsActivo);
			TrabRemuneracion resp = service_remu.modificar(trabRemu);
			if(resp!=null) {
				response.setEstado(Constantes.valTransaccionOk);
				response.setMsg(Constantes.msgActivarRemuneracionOK);
				response.setDefaultObj(resp);
			}else {
				response.setEstado(Constantes.valTransaccionError);
				response.setMsg(Constantes.msgActivarRemuneracionError);
			}
			return response;
		}catch(Exception e) {
			System.out.println(this.getClass().getSimpleName() + " activarRemu. ERROR : " + e.getMessage());
			throw new ExceptionResponse(new Date(), this.getClass().getSimpleName() + "/activarRemu",
					e.getStackTrace()[0].getFileName() + " => " + e.getStackTrace()[0].getMethodName() + " => "
							+ e.getClass() + " => message: " + e.getMessage() + "=> linea nro: "
							+ e.getStackTrace()[0].getLineNumber(),
							trabRemu);
		}
	}
	
	@Transactional(propagation = Propagation.REQUIRED,rollbackFor=Exception.class)
	@PostMapping("/activarDsct")
	public ResponseWrapper activarDsct(@Valid @RequestBody TrabDescuento trabDsct, BindingResult result) throws Exception {
		
		if (result.hasErrors()) {
			List<String> errors = result.getFieldErrors().stream().map(err -> {
				return err.getDefaultMessage();
			}).collect(Collectors.toList());
			throw new ExceptionResponse(new Date(), this.getClass().getSimpleName() + "/activarDsct",
					"Error en la validacion: Lista de Errores:" + errors.toString(), trabDsct);
		}
		
		try {
			ResponseWrapper response=new ResponseWrapper();
			trabDsct.setEstado(Constantes.ConsActivo);
			TrabDescuento resp = service_dsct.modificar(trabDsct);
			if(resp!=null) {
				response.setEstado(Constantes.valTransaccionOk);
				response.setMsg(Constantes.msgActivarDescuentoOK);
				response.setDefaultObj(resp);
			}else {
				response.setEstado(Constantes.valTransaccionError);
				response.setMsg(Constantes.msgActivarDescuentoError);
			}
			return response;
		}catch(Exception e) {
			System.out.println(this.getClass().getSimpleName() + " activarDsct. ERROR : " + e.getMessage());
			throw new ExceptionResponse(new Date(), this.getClass().getSimpleName() + "/activarDsct",
					e.getStackTrace()[0].getFileName() + " => " + e.getStackTrace()[0].getMethodName() + " => "
							+ e.getClass() + " => message: " + e.getMessage() + "=> linea nro: "
							+ e.getStackTrace()[0].getLineNumber(),
							trabDsct);
		}				
	}

}

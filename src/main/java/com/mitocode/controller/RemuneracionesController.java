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

import com.mitocode.dto.EmpresaDTO;
import com.mitocode.dto.ResponseWrapper;
import com.mitocode.exception.ExceptionResponse;
import com.mitocode.model.Empresa;
import com.mitocode.model.Remuneraciones;
import com.mitocode.service.RemuneracionesService;
import com.mitocode.util.Constantes;

@RestController
@RequestMapping("/api/remuneraciones")
public class RemuneracionesController {
	
	@Autowired
	RemuneracionesService service;
	
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	@PostMapping("/listar")
	public ResponseWrapper listarActivo(@RequestBody Empresa emp) throws Exception {
		
		if (emp.getIdEmpresa() == null) {
			throw new ExceptionResponse(new Date(), this.getClass().getSimpleName() + "/listar",
					Constantes.msgListarRemuneracionesError + " no se ha especificado una empresa valida", emp);
		}
		
		try {
			ResponseWrapper response = new ResponseWrapper();
			List lsRem = service.listarXEmpresa(emp);

			if (lsRem.size()>0) {
				response.setEstado(Constantes.valTransaccionOk);
				response.setMsg(Constantes.msgListarRemuneracionesOK);
				response.setAaData(lsRem);
			} else if (lsRem.size()==0) {
				response.setEstado(Constantes.valTransaccionOk);
				response.setMsg(Constantes.msgListarRemuneracionesOKVacio);
				response.setAaData(lsRem);
			} else {
				response.setEstado(Constantes.valTransaccionError);
				response.setMsg(Constantes.msgListarRemuneracionesError);
			}
			return response;
		} catch (Exception e) {
			System.out.println(this.getClass().getSimpleName() + " listarRemuneracionesPorEmpresa. ERROR : " + e.getMessage());
			throw new ExceptionResponse(new Date(), this.getClass().getSimpleName() + "/listar",
					e.getStackTrace()[0].getFileName() + " => " + e.getStackTrace()[0].getMethodName() + " => "
							+ e.getClass() + " => message: " + e.getMessage() + "=> linea nro: "
							+ e.getStackTrace()[0].getLineNumber(),
					emp);
		}
	}
	
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	@PostMapping("/listarInac")
	public ResponseWrapper listarInactivo(@RequestBody Empresa emp) throws Exception {
		
		if (emp.getIdEmpresa() == null) {
			throw new ExceptionResponse(new Date(), this.getClass().getSimpleName() + "/listarInac",
					Constantes.msgListarRemuneracionesError + " no se ha especificado una empresa valida", emp);
		}
		
		try {
			ResponseWrapper response = new ResponseWrapper();
			List lsRem = service.listarXEmpresaInac(emp);

			if (lsRem.size()>0) {
				response.setEstado(Constantes.valTransaccionOk);
				response.setMsg(Constantes.msgListarRemuneracionesOK);
				response.setAaData(lsRem);
			} else if (lsRem.size()==0) {
				response.setEstado(Constantes.valTransaccionOk);
				response.setMsg(Constantes.msgListarRemuneracionesOKVacio);
				response.setAaData(lsRem);
			} else {
				response.setEstado(Constantes.valTransaccionError);
				response.setMsg(Constantes.msgListarRemuneracionesError);
			}
			return response;
		} catch (Exception e) {
			System.out.println(this.getClass().getSimpleName() + " listarRemuneracionesInactivoPorEmpresa. ERROR : " + e.getMessage());
			throw new ExceptionResponse(new Date(), this.getClass().getSimpleName() + "/listarInac",
					e.getStackTrace()[0].getFileName() + " => " + e.getStackTrace()[0].getMethodName() + " => "
							+ e.getClass() + " => message: " + e.getMessage() + "=> linea nro: "
							+ e.getStackTrace()[0].getLineNumber(),
					emp);
		}
	}
	
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	@PostMapping("/registrar")
	public ResponseWrapper registrar(@Valid @RequestBody EmpresaDTO empresaDTO, BindingResult result) throws Exception {
		
		if (result.hasErrors()) {
			List<String> errors = result.getFieldErrors().stream().map(err -> {
				return err.getDefaultMessage();
			}).collect(Collectors.toList());
			throw new ExceptionResponse(new Date(), this.getClass().getSimpleName() + "/registrar",
					"Error en la validacion: Lista de Errores:" + errors.toString(), empresaDTO);
		}

		try {
			ResponseWrapper response = new ResponseWrapper();
			Remuneraciones rem = empresaDTO.getRemuneraciones();
			rem.setEmpresa(empresaDTO.getEmpresa());
			rem.setEstado(Constantes.ConsActivo);
			
			Remuneraciones respRem = service.registrar(rem);
		
			if (respRem!=null) {
				response.setEstado(Constantes.valTransaccionOk);
				response.setMsg(Constantes.msgRegistrarRemuneracionOk);
				response.setDefaultObj(respRem);
			} else {
				response.setEstado(Constantes.valTransaccionError);
				response.setMsg(Constantes.msgRegistrarRemuneracionError);
			}
			return response;
		} catch (Exception e) {
			System.out.println(this.getClass().getSimpleName() + " registrarRemuneracion. ERROR : " + e.getMessage());
			throw new ExceptionResponse(new Date(), this.getClass().getSimpleName() + "/registrar",
					e.getStackTrace()[0].getFileName() + " => " + e.getStackTrace()[0].getMethodName() + " => "
							+ e.getClass() + " => message: " + e.getMessage() + "=> linea nro: "
							+ e.getStackTrace()[0].getLineNumber(),
					empresaDTO);
		}
	}
	
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	@PostMapping("/modificar")
	public ResponseWrapper modificar(@Valid @RequestBody Remuneraciones rem, BindingResult result) throws Exception {
		
		if (result.hasErrors()) {
			List<String> errors = result.getFieldErrors().stream().map(err -> {
				return err.getDefaultMessage();
			}).collect(Collectors.toList());
			throw new ExceptionResponse(new Date(), this.getClass().getSimpleName() + "/modificar",
					"Error en la validacion: Lista de Errores:" + errors.toString(),rem);
		}
		
		try {
			ResponseWrapper response = new ResponseWrapper();
			Remuneraciones respRem = service.modificar(rem);
			if (respRem!=null) {
				response.setEstado(Constantes.valTransaccionOk);
				response.setMsg(Constantes.msgModificarRemuneracionOK);
				response.setDefaultObj(respRem);
			} else {
				response.setEstado(Constantes.valTransaccionError);
				response.setMsg(Constantes.msgModificarRemuneracionError);
			}
			return response;
		} catch (Exception e) {
			System.out.println(this.getClass().getSimpleName() + " modificarRemuneracion. ERROR : " + e.getMessage());
			throw new ExceptionResponse(new Date(), this.getClass().getSimpleName() + "/modificar",
					e.getStackTrace()[0].getFileName() + " => " + e.getStackTrace()[0].getMethodName() + " => "
							+ e.getClass() + " => message: " + e.getMessage() + "=> linea nro: "
							+ e.getStackTrace()[0].getLineNumber(),
					rem);
		}
	}
	
	@Transactional(propagation = Propagation.REQUIRED,rollbackFor=Exception.class)
	@PostMapping("/darBaja")
	public ResponseWrapper darBaja(@Valid @RequestBody Remuneraciones rem, BindingResult result) throws Exception {
		
		if (result.hasErrors()) {
			List<String> errors = result.getFieldErrors().stream().map(err -> {
				return err.getDefaultMessage();
			}).collect(Collectors.toList());
			throw new ExceptionResponse(new Date(), this.getClass().getSimpleName() + "/darBaja",
					"Error en la validacion: Lista de Errores:" + errors.toString(),rem);
		}
		
		try {
			ResponseWrapper response=new ResponseWrapper();
			Remuneraciones resp = service.darBaja(rem);
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
			System.out.println(this.getClass().getSimpleName() + " darBajaRemuneracion. ERROR : " + e.getMessage());
			throw new ExceptionResponse(new Date(), this.getClass().getSimpleName() + "/darBaja",
					e.getStackTrace()[0].getFileName() + " => " + e.getStackTrace()[0].getMethodName() + " => "
							+ e.getClass() + " => message: " + e.getMessage() + "=> linea nro: "
							+ e.getStackTrace()[0].getLineNumber(),
					rem);
		}				
	}
	
	@Transactional(propagation = Propagation.REQUIRED,rollbackFor=Exception.class)
	@PostMapping("/activar")
	public ResponseWrapper activar(@Valid @RequestBody Remuneraciones rem, BindingResult result) throws Exception {
		
		if (result.hasErrors()) {
			List<String> errors = result.getFieldErrors().stream().map(err -> {
				return err.getDefaultMessage();
			}).collect(Collectors.toList());
			throw new ExceptionResponse(new Date(), this.getClass().getSimpleName() + "/activar",
					"Error en la validacion: Lista de Errores:" + errors.toString(),rem);
		}
		
		try {
			ResponseWrapper response=new ResponseWrapper();
			Remuneraciones resp = service.activar(rem);
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
			System.out.println(this.getClass().getSimpleName() + " activarRemuneracion. ERROR : " + e.getMessage());
			throw new ExceptionResponse(new Date(), this.getClass().getSimpleName() + "/activar",
					e.getStackTrace()[0].getFileName() + " => " + e.getStackTrace()[0].getMethodName() + " => "
							+ e.getClass() + " => message: " + e.getMessage() + "=> linea nro: "
							+ e.getStackTrace()[0].getLineNumber(),
					rem);
		}				
	}
}

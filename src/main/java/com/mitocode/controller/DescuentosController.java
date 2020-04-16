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
import com.mitocode.model.Descuentos;
import com.mitocode.model.Empresa;
import com.mitocode.service.DescuentosService;
import com.mitocode.util.Constantes;

@RestController
@RequestMapping("/api/descuentos")
public class DescuentosController {
	
	@Autowired
	DescuentosService service;
	
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	@PostMapping("/listar")
	public ResponseWrapper listar(@RequestBody Empresa emp) throws Exception {
		
		if (emp.getIdEmpresa() == null) {
			throw new ExceptionResponse(new Date(), this.getClass().getSimpleName() + "/listar",
					Constantes.msgListarDescuentosError + " no se ha especificado una empresa valida", emp);
		}
		
		try {
			ResponseWrapper response = new ResponseWrapper();
			List lsDsct = service.listarXEmpresa(emp);

			if (lsDsct.size()>0) {
				response.setEstado(Constantes.valTransaccionOk);
				response.setMsg(Constantes.msgListarDescuentosOK);
				response.setAaData(lsDsct);
			} else if (lsDsct.size()==0) {
				response.setEstado(Constantes.valTransaccionOk);
				response.setMsg(Constantes.msgListarDescuentosOKVacio);
				response.setAaData(lsDsct);
			} else {
				response.setEstado(Constantes.valTransaccionError);
				response.setMsg(Constantes.msgListarDescuentosError);
			}
			return response;
		} catch (Exception e) {
			System.out.println(this.getClass().getSimpleName() + " listarDescuentos. ERROR : " + e.getMessage());
			throw new ExceptionResponse(new Date(), this.getClass().getSimpleName() + "/listar",
					e.getStackTrace()[0].getFileName() + " => " + e.getStackTrace()[0].getMethodName() + " => "
							+ e.getClass() + " => message: " + e.getMessage() + "=> linea nro: "
							+ e.getStackTrace()[0].getLineNumber(),
					emp);
		}
	}
	
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	@PostMapping("/listarInac")
	public ResponseWrapper listarInac(@RequestBody Empresa emp) throws Exception {
		
		if (emp.getIdEmpresa() == null) {
			throw new ExceptionResponse(new Date(), this.getClass().getSimpleName() + "/listarInac",
					Constantes.msgListarDescuentosError + " no se ha especificado una empresa valida", emp);
		}
		
		try {
			ResponseWrapper response = new ResponseWrapper();
			List lsDsct = service.listarXEmpresaInac(emp);

			if (lsDsct.size()>0) {
				response.setEstado(Constantes.valTransaccionOk);
				response.setMsg(Constantes.msgListarDescuentosOK);
				response.setAaData(lsDsct);
			} else if (lsDsct.size()==0) {
				response.setEstado(Constantes.valTransaccionOk);
				response.setMsg(Constantes.msgListarDescuentosOKVacio);
				response.setAaData(lsDsct);
			} else {
				response.setEstado(Constantes.valTransaccionError);
				response.setMsg(Constantes.msgListarDescuentosError);
			}
			return response;
		} catch (Exception e) {
			System.out.println(this.getClass().getSimpleName() + " listarDescuentosInactivos. ERROR : " + e.getMessage());
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
			Descuentos dsct = empresaDTO.getDescuentos();
			dsct.setEmpresa(empresaDTO.getEmpresa());
			dsct.setEstado(Constantes.ConsActivo);
			
			Descuentos respDsct = service.registrar(dsct);
		
			if (respDsct!=null) {
				response.setEstado(Constantes.valTransaccionOk);
				response.setMsg(Constantes.msgRegistrarDescuentoOk);
				response.setDefaultObj(respDsct);
			} else {
				response.setEstado(Constantes.valTransaccionError);
				response.setMsg(Constantes.msgRegistrarDescuentoError);
			}
			return response;
		} catch (Exception e) {
			System.out.println(this.getClass().getSimpleName() + " registrarDescuento. ERROR : " + e.getMessage());
			throw new ExceptionResponse(new Date(), this.getClass().getSimpleName() + "/registrar",
					e.getStackTrace()[0].getFileName() + " => " + e.getStackTrace()[0].getMethodName() + " => "
							+ e.getClass() + " => message: " + e.getMessage() + "=> linea nro: "
							+ e.getStackTrace()[0].getLineNumber(),
					empresaDTO);
		}
	}
	
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	@PostMapping("/modificar")
	public ResponseWrapper modificar(@Valid @RequestBody Descuentos dsct, BindingResult result) throws Exception {
		
		if (result.hasErrors()) {
			List<String> errors = result.getFieldErrors().stream().map(err -> {
				return err.getDefaultMessage();
			}).collect(Collectors.toList());
			throw new ExceptionResponse(new Date(), this.getClass().getSimpleName() + "/modificar",
					"Error en la validacion: Lista de Errores:" + errors.toString(), dsct);
		}
		
		try {
			ResponseWrapper response = new ResponseWrapper();
			Descuentos respDsct = service.modificar(dsct);
			if (respDsct!=null) {
				response.setEstado(Constantes.valTransaccionOk);
				response.setMsg(Constantes.msgModificarDescuentoOK);
				response.setDefaultObj(respDsct);
			} else {
				response.setEstado(Constantes.valTransaccionError);
				response.setMsg(Constantes.msgModificarDescuentoError);
			}
			return response;
		} catch (Exception e) {
			System.out.println(this.getClass().getSimpleName() + " modificarDescuento. ERROR : " + e.getMessage());
			throw new ExceptionResponse(new Date(), this.getClass().getSimpleName() + "/modificar",
					e.getStackTrace()[0].getFileName() + " => " + e.getStackTrace()[0].getMethodName() + " => "
							+ e.getClass() + " => message: " + e.getMessage() + "=> linea nro: "
							+ e.getStackTrace()[0].getLineNumber(),
					dsct);
		}
	}
	
	@Transactional(propagation = Propagation.REQUIRED,rollbackFor=Exception.class)
	@PostMapping("/darBaja")
	public ResponseWrapper darBaja(@Valid @RequestBody Descuentos dsct, BindingResult result) throws Exception {
		
		if (result.hasErrors()) {
			List<String> errors = result.getFieldErrors().stream().map(err -> {
				return err.getDefaultMessage();
			}).collect(Collectors.toList());
			throw new ExceptionResponse(new Date(), this.getClass().getSimpleName() + "/darBaja",
					"Error en la validacion: Lista de Errores:" + errors.toString(), dsct);
		}
		
		try {
			ResponseWrapper response=new ResponseWrapper();
			Descuentos resp = service.darBaja(dsct);
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
			System.out.println(this.getClass().getSimpleName() + " darBajaDescuento. ERROR : " + e.getMessage());
			throw new ExceptionResponse(new Date(), this.getClass().getSimpleName() + "/darBaja",
					e.getStackTrace()[0].getFileName() + " => " + e.getStackTrace()[0].getMethodName() + " => "
							+ e.getClass() + " => message: " + e.getMessage() + "=> linea nro: "
							+ e.getStackTrace()[0].getLineNumber(),
					dsct);
		}				
	}
	
	@Transactional(propagation = Propagation.REQUIRED,rollbackFor=Exception.class)
	@PostMapping("/activar")
	public ResponseWrapper activar(@Valid @RequestBody Descuentos dsct, BindingResult result) throws Exception {
		
		if (result.hasErrors()) {
			List<String> errors = result.getFieldErrors().stream().map(err -> {
				return err.getDefaultMessage();
			}).collect(Collectors.toList());
			throw new ExceptionResponse(new Date(), this.getClass().getSimpleName() + "/activar",
					"Error en la validacion: Lista de Errores:" + errors.toString(), dsct);
		}
		
		try {
			ResponseWrapper response=new ResponseWrapper();
			Descuentos resp = service.activar(dsct);
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
			System.out.println(this.getClass().getSimpleName() + " activarDescuento. ERROR : " + e.getMessage());
			throw new ExceptionResponse(new Date(), this.getClass().getSimpleName() + "/activar",
					e.getStackTrace()[0].getFileName() + " => " + e.getStackTrace()[0].getMethodName() + " => "
							+ e.getClass() + " => message: " + e.getMessage() + "=> linea nro: "
							+ e.getStackTrace()[0].getLineNumber(),
					dsct);
		}				
	}
}

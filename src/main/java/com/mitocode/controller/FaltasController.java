package com.mitocode.controller;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mitocode.dto.ResponseWrapper;
import com.mitocode.exception.ExceptionResponse;
import com.mitocode.model.Falta;
import com.mitocode.service.FaltasService;
import com.mitocode.util.Constantes;

@RestController
@RequestMapping("/api/falta")
public class FaltasController {
	
	@Autowired
	FaltasService service;
	
	@PostMapping("/listarXTrabajador")
	public ResponseWrapper listarXTrabajador(@Valid @RequestBody Falta falta, BindingResult result) throws Exception {
		
		if (result.hasErrors()) {
			List<String> errors = result.getFieldErrors().stream().map(err -> {
				return err.getDefaultMessage();

			}).collect(Collectors.toList());
			errors.remove(null);
			throw new ExceptionResponse(new Date(), this.getClass().getSimpleName() + "/listarXTrabajador",
					"Error en la validacion: Lista de Errores:" + errors.toString(), falta);
		}
		
		try {
			ResponseWrapper response = new ResponseWrapper();
			List lsfalta = service.busarPorTrabajadoryPeriodo(falta);
			if (lsfalta != null) {
				response.setEstado(Constantes.valTransaccionOk);
				response.setMsg(Constantes.msgListarFaltasOK);
				response.setAaData(lsfalta);
			} else {
				response.setEstado(Constantes.valTransaccionError);
				response.setMsg(Constantes.msgListarFaltasError);
			}
			return response;
		} catch (Exception e) {
			System.out.println(this.getClass().getSimpleName()+" listarFaltasPorTrabajador. ERROR : "+e.getMessage());
			throw new ExceptionResponse(new Date(),	this.getClass().getSimpleName() + "/listarXTrabajador",
	 				e.getStackTrace()[0].getFileName() + " => " + e.getStackTrace()[0].getMethodName() + " => " + e.getClass() + " => message: " + 
	 				e.getMessage() + "=> linea nro: " + e.getStackTrace()[0].getLineNumber(),falta);
		}
	}
	
	@PostMapping("/registrar")
	public ResponseWrapper registrar(@Valid @RequestBody Falta falta, BindingResult result) throws Exception {

		if(result.hasErrors()) {
			List<String> errors = result.getFieldErrors()
					.stream().map(err -> {
						return err.getDefaultMessage();
					})
					.collect(Collectors.toList());
			throw new ExceptionResponse(new Date(),this.getClass().getSimpleName() + "/registrar","Error en la validacion: Lista de Errores:"+errors.toString(),falta);
		}
		try {
			ResponseWrapper response = new ResponseWrapper();
			Falta res_falta = service.registrar(falta);
			if(res_falta!=null) {
				response.setEstado(Constantes.valTransaccionOk);
				response.setMsg(Constantes.msgRegistrarFaltaOK);
				response.setDefaultObj(res_falta);
			}else {
				response.setEstado(Constantes.valTransaccionError);
				response.setMsg(Constantes.msgRegistrarFaltaError);
			}
			return response;
		}catch(Exception e) {
			System.out.println(this.getClass().getSimpleName()+" registrarFata. ERROR : "+e.getMessage());
			throw new ExceptionResponse(new Date(),	this.getClass().getSimpleName() + "/registrar",
	 				e.getStackTrace()[0].getFileName() + " => " + e.getStackTrace()[0].getMethodName() + " => " + e.getClass() + " => message: " + 
	 				e.getMessage() + "=> linea nro: " + e.getStackTrace()[0].getLineNumber(),falta);
		}
	}
	
	@PostMapping("/buscarFecha")
	public ResponseWrapper buscarFecha(@Valid @RequestBody Falta falta, BindingResult result) throws Exception {
		
		if (result.hasErrors()) {
			List<String> errors = result.getFieldErrors().stream().map(err -> {
				return err.getDefaultMessage();

			}).collect(Collectors.toList());
			errors.remove(null);
			throw new ExceptionResponse(new Date(), this.getClass().getSimpleName() + "/buscarFecha",
					"Error en la validacion: Lista de Errores:" + errors.toString(), falta);
		}
		
		try {
			ResponseWrapper response = new ResponseWrapper();
			Integer resp = service.buscarPorFechaYTrabajador(falta.getFecha(), falta.getTrabajador());
			response.setDefaultObj(resp);
			return response;
		} catch (Exception e) {
			System.out.println(this.getClass().getSimpleName() + "buscarFecha. ERROR : " + e.getMessage());
			throw new ExceptionResponse(new Date(), this.getClass().getSimpleName() + "/buscarFecha",
					e.getStackTrace()[0].getFileName() + " => " + e.getStackTrace()[0].getMethodName() + " => "
							+ e.getClass() + " => message: " + e.getMessage() + "=> linea nro: "
							+ e.getStackTrace()[0].getLineNumber(),
					falta);
		}
	}
	
	@Transactional(propagation = Propagation.REQUIRED,rollbackFor=Exception.class)
	@PutMapping("/modificar")
	public ResponseWrapper modificar(@Valid @RequestBody Falta falta, BindingResult result) throws Exception {
		
		if (result.hasErrors()) {
			List<String> errors = result.getFieldErrors().stream().map(err -> {
				return err.getDefaultMessage();

			}).collect(Collectors.toList());
			errors.remove(null);
			throw new ExceptionResponse(new Date(), this.getClass().getSimpleName() + "/modificar",
					"Error en la validacion: Lista de Errores:" + errors.toString(), falta);
		}
		
		try {
			ResponseWrapper response = new ResponseWrapper();
			Falta resp_falta = service.modificar(falta);
			if(resp_falta!=null) {
				response.setEstado(Constantes.valTransaccionOk);
				response.setMsg(Constantes.msgActualizarFaltaOK);
				response.setDefaultObj(resp_falta);
			}else {
				response.setEstado(Constantes.valTransaccionError);
				response.setMsg(Constantes.msgActualizarFaltaError);
			}
			return response;
		}catch(Exception e) {
			System.out.println(this.getClass().getSimpleName() + "modificarFalta. ERROR : " + e.getMessage());
			throw new ExceptionResponse(new Date(), this.getClass().getSimpleName() + "/modificar",
					e.getStackTrace()[0].getFileName() + " => " + e.getStackTrace()[0].getMethodName() + " => "
							+ e.getClass() + " => message: " + e.getMessage() + "=> linea nro: "
							+ e.getStackTrace()[0].getLineNumber(),
					falta);
		}				
	}
	
	
	@Transactional(propagation = Propagation.REQUIRED,rollbackFor=Exception.class)
	@DeleteMapping("/{idFalta}")
	public ResponseWrapper eliminar(@PathVariable("idFalta") Integer id) throws Exception {
		try {
			ResponseWrapper response=new ResponseWrapper();
			
			Boolean resp = service.eliminar(id);
			
			if(resp) {
				response.setEstado(Constantes.valTransaccionOk);
				response.setMsg(Constantes.msgEliminarFaltaOK);
				response.setDefaultObj(resp);
			}else {
				response.setEstado(Constantes.valTransaccionError);
				response.setMsg(Constantes.msgEliminarFaltaError);
				response.setDefaultObj(resp);
			}
			return response;
		}catch(Exception e) {
			System.out.println(this.getClass().getSimpleName() + " eliminarFalta. ERROR : " + e.getMessage());
			throw new ExceptionResponse(new Date(), this.getClass().getSimpleName() + "/" + id,
					e.getStackTrace()[0].getFileName() + " => " + e.getStackTrace()[0].getMethodName() + " => "
							+ e.getClass() + " => message: " + e.getMessage() + "=> linea nro: "
							+ e.getStackTrace()[0].getLineNumber(),
					id);
		}			
	}
}

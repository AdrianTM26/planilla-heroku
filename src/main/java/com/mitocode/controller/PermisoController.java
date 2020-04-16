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
import com.mitocode.model.Permiso;
import com.mitocode.service.PermisoService;
import com.mitocode.util.Constantes;

@RestController
@RequestMapping("/api/permiso")
public class PermisoController {
	
	@Autowired
	PermisoService service;
	
	@PostMapping("/listarXTrabajador")
	public ResponseWrapper listarXTrabajador(@Valid @RequestBody Permiso permiso, BindingResult result) throws Exception {
		
		if (result.hasErrors()) {
			List<String> errors = result.getFieldErrors().stream().map(err -> {
				return err.getDefaultMessage();

			}).collect(Collectors.toList());
			errors.remove(null);
			throw new ExceptionResponse(new Date(), this.getClass().getSimpleName() + "/listarXTrabajador",
					"Error en la validacion: Lista de Errores:" + errors.toString(), permiso);
		}
		
		try {
			ResponseWrapper response = new ResponseWrapper();
			List lspermiso = service.listarPorTrabajadoryPeriodo(permiso);
			if (lspermiso != null) {
				response.setEstado(Constantes.valTransaccionOk);
				response.setMsg(Constantes.msgListarPermisosOK);
				response.setAaData(lspermiso);
			} else {
				response.setEstado(Constantes.valTransaccionError);
				response.setMsg(Constantes.msgListarPermisosError);
			}
			return response;
		} catch (Exception e) {
			System.out.println(this.getClass().getSimpleName() + "listarPermisosPorTrabajadorAnoMes. ERROR : "
					+ e.getMessage());
			throw new ExceptionResponse(new Date(), this.getClass().getSimpleName() + "/listarXTrabajador",
					e.getStackTrace()[0].getFileName() + " => " + e.getStackTrace()[0].getMethodName() + " => "
							+ e.getClass() + " => message: " + e.getMessage() + "=> linea nro: "
							+ e.getStackTrace()[0].getLineNumber(),
					permiso);
		}
	}
	
	@PostMapping("/registrar")
	public ResponseWrapper registrar(@Valid @RequestBody Permiso permiso, BindingResult result) throws Exception {

		if(result.hasErrors()) {
			List<String> errors = result.getFieldErrors()
					.stream().map(err -> {
						return err.getDefaultMessage();
					})
					.collect(Collectors.toList());
			throw new ExceptionResponse(new Date(),this.getClass().getSimpleName() + "/registrar","Error en la validacion: Lista de Errores:"+errors.toString(),permiso);
		}
		try {
			ResponseWrapper response = new ResponseWrapper();
			Permiso res_permiso = service.registrar(permiso);
			if(res_permiso!=null) {
				response.setEstado(Constantes.valTransaccionOk);
				response.setMsg(Constantes.msgRegistrarPermisoOK);
				response.setDefaultObj(res_permiso);
			}else {
				response.setEstado(Constantes.valTransaccionError);
				response.setMsg(Constantes.msgRegistrarPermisoError);
			}
			return response;
		}catch(Exception e) {
			System.out.println(this.getClass().getSimpleName()+" registrarPermiso. ERROR : "+e.getMessage());
			throw new ExceptionResponse(new Date(),	this.getClass().getSimpleName() + "/registrar",
	 				e.getStackTrace()[0].getFileName() + " => " + e.getStackTrace()[0].getMethodName() + " => " + e.getClass() + " => message: " + 
	 				e.getMessage() + "=> linea nro: " + e.getStackTrace()[0].getLineNumber(),permiso);
		}
	}
	
	@PostMapping("/buscarFecha")
	public ResponseWrapper buscarFecha(@Valid @RequestBody Permiso permiso, BindingResult result) throws Exception {
		
		if (result.hasErrors()) {
			List<String> errors = result.getFieldErrors().stream().map(err -> {
				return err.getDefaultMessage();

			}).collect(Collectors.toList());
			errors.remove(null);
			throw new ExceptionResponse(new Date(), this.getClass().getSimpleName() + "/buscarFecha",
					"Error en la validacion: Lista de Errores:" + errors.toString(), permiso);
		}
		
		try {
			ResponseWrapper response = new ResponseWrapper();
			Boolean resp = service.buscarPorFechaYTrabajador(permiso.getFechaIni(), permiso.getTrabajador());
			response.setDefaultObj(resp);
			return response;
		} catch (Exception e) {
			System.out.println(this.getClass().getSimpleName() + "buscarFecha. ERROR : " + e.getMessage());
			throw new ExceptionResponse(new Date(), this.getClass().getSimpleName() + "/buscarFecha",
					e.getStackTrace()[0].getFileName() + " => " + e.getStackTrace()[0].getMethodName() + " => "
							+ e.getClass() + " => message: " + e.getMessage() + "=> linea nro: "
							+ e.getStackTrace()[0].getLineNumber(),
					permiso);
		}
	}
	
	@Transactional(propagation = Propagation.REQUIRED,rollbackFor=Exception.class)
	@PutMapping("/modificar")
	public ResponseWrapper modificar(@Valid @RequestBody Permiso permiso, BindingResult result) throws Exception {
		
		if (result.hasErrors()) {
			List<String> errors = result.getFieldErrors().stream().map(err -> {
				return err.getDefaultMessage();
			}).collect(Collectors.toList());
			throw new ExceptionResponse(new Date(), this.getClass().getSimpleName() + "/modificar",
					"Error en la validacion: Lista de Errores:" + errors.toString(), result);
		}
		
		try {
			ResponseWrapper response = new ResponseWrapper();
			Permiso resp_perm = service.modificar(permiso);
			if(resp_perm!=null) {
				response.setEstado(Constantes.valTransaccionOk);
				response.setMsg(Constantes.msgActualizarPermisoOK);
				response.setDefaultObj(resp_perm);
			}else {
				response.setEstado(Constantes.valTransaccionError);
				response.setMsg(Constantes.msgActualizarPermisoError);
			}
			return response;
		}catch(Exception e) {
			System.out.println(this.getClass().getSimpleName() + "modificarPermiso. ERROR : " + e.getMessage());
			throw new ExceptionResponse(new Date(), this.getClass().getSimpleName() + "/modificar",
					e.getStackTrace()[0].getFileName() + " => " + e.getStackTrace()[0].getMethodName() + " => "
							+ e.getClass() + " => message: " + e.getMessage() + "=> linea nro: "
							+ e.getStackTrace()[0].getLineNumber(),
					permiso);
		}				
	}
	
	@Transactional(propagation = Propagation.REQUIRED,rollbackFor=Exception.class)
	@DeleteMapping("/{idPermiso}")
	public ResponseWrapper eliminar(@PathVariable("idPermiso") Integer id) throws Exception {
		try {
			ResponseWrapper response=new ResponseWrapper();
			
			Boolean resp = service.eliminar(id);
			
			if(resp) {
				response.setEstado(Constantes.valTransaccionOk);
				response.setMsg(Constantes.msgEliminarPermisoOK);
				response.setDefaultObj(resp);
			}else {
				response.setEstado(Constantes.valTransaccionError);
				response.setMsg(Constantes.msgEliminarPermisoError);
				response.setDefaultObj(resp);
			}
			return response;
		}catch(Exception e) {
			System.out.println(this.getClass().getSimpleName() + "eliminarPermiso. ERROR : " + e.getMessage());
			throw new ExceptionResponse(new Date(), this.getClass().getSimpleName() + "/"+id,
					e.getStackTrace()[0].getFileName() + " => " + e.getStackTrace()[0].getMethodName() + " => "
							+ e.getClass() + " => message: " + e.getMessage() + "=> linea nro: "
							+ e.getStackTrace()[0].getLineNumber(),
					id);
		}			
	}
	

}

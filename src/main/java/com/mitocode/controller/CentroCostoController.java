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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mitocode.dto.EmpresaDTO;
import com.mitocode.dto.ResponseWrapper;
import com.mitocode.exception.ExceptionResponse;
import com.mitocode.model.CentroCosto;
import com.mitocode.model.Empresa;
import com.mitocode.service.CentroCostoService;
import com.mitocode.util.Constantes;

@RestController
@RequestMapping("/api/centroCosto")
public class CentroCostoController {
	
	@Autowired
	CentroCostoService service;
	
	@Transactional(propagation = Propagation.REQUIRED,rollbackFor=Exception.class)
	@PostMapping ("/porEmpresa") 
	public ResponseWrapper listar(@RequestBody Empresa empresa) throws Exception {
		

		if (empresa.getIdEmpresa() == null) {
			throw new ExceptionResponse(new Date(), this.getClass().getSimpleName() + "/porEmpresa",
					Constantes.msgListarCentroCostoError + " no se ha especificado una empresa valida", empresa);
		}
		
		try {
			ResponseWrapper response = new ResponseWrapper();
			List lscencos = service.listarPorEmpresa(empresa);
			if (lscencos != null) {
				response.setEstado(Constantes.valTransaccionOk);
				response.setMsg(Constantes.msgListarCentroCostoOK);
				response.setAaData(lscencos);
			} else {
				response.setEstado(Constantes.valTransaccionError);
				response.setMsg(Constantes.msgListarCentroCostoError);
			}
			
			return response;
		} catch (Exception e) {
			System.out.println(this.getClass().getSimpleName() + " listarPorEmpresa. ERROR : " + e.getMessage());
			throw new ExceptionResponse(new Date(), this.getClass().getSimpleName() + "/porEmpresa",
					e.getStackTrace()[0].getFileName() + " => " + e.getStackTrace()[0].getMethodName() + " => "
							+ e.getClass() + " => message: " + e.getMessage() + "=> linea nro: "
							+ e.getStackTrace()[0].getLineNumber(),
					empresa);
		}
	}
	
	
	@Transactional(propagation = Propagation.REQUIRED,rollbackFor=Exception.class)
	@PostMapping("/insertar")
	public ResponseWrapper insertar(@Valid @RequestBody EmpresaDTO empresaDTO, BindingResult result) throws Exception {
		
		if (result.hasErrors()) {
			List<String> errors = result.getFieldErrors().stream().map(err -> {
				return err.getDefaultMessage();
			}).collect(Collectors.toList());
			throw new ExceptionResponse(new Date(), this.getClass().getSimpleName() + "/insertar",
					"Error en la validacion: Lista de Errores:" + errors.toString(), empresaDTO);
		}
		
		try {
			ResponseWrapper response = new ResponseWrapper();
			CentroCosto ceCos = empresaDTO.getCentroCosto();
			ceCos.setEmpresa(empresaDTO.getEmpresa());
			
			CentroCosto respCeCos= service.registrar(ceCos);			
			if(respCeCos!=null) {
				response.setEstado(Constantes.valTransaccionOk);
				response.setMsg(Constantes.msgRegistrarCentroCostoOK);
				response.setDefaultObj(respCeCos);
			}else {
				response.setEstado(Constantes.valTransaccionError);
				response.setMsg(Constantes.msgRegistrarCentroCostoError);
			}
			return response;
		}catch(Exception e) {
			System.out.println(this.getClass().getSimpleName() + " insertarCentroCosto. ERROR : " + e.getMessage());
			throw new ExceptionResponse(new Date(), this.getClass().getSimpleName() + "/insertar",
					e.getStackTrace()[0].getFileName() + " => " + e.getStackTrace()[0].getMethodName() + " => "
							+ e.getClass() + " => message: " + e.getMessage() + "=> linea nro: "
							+ e.getStackTrace()[0].getLineNumber(),
					empresaDTO);
		}				
	}
	
	
	@Transactional(propagation = Propagation.REQUIRED,rollbackFor=Exception.class)
	@PostMapping ("/actualizar")
	public ResponseWrapper actualizar(@Valid @RequestBody CentroCosto ceCos, BindingResult result) throws Exception {
		
		if (result.hasErrors()) {
			List<String> errors = result.getFieldErrors().stream().map(err -> {
				return err.getDefaultMessage();
			}).collect(Collectors.toList());
			throw new ExceptionResponse(new Date(), this.getClass().getSimpleName() + "/actualizar",
					"Error en la validacion: Lista de Errores:" + errors.toString(), ceCos);
		}
		
		try {
			ResponseWrapper response = new ResponseWrapper();
			//CentroCosto ceCos = empresaDTO.getCentroCosto();
			//ceCos.setEmpresa(empresaDTO.getEmpresa());
			CentroCosto respCeCos = service.modificar(ceCos);
			if(respCeCos!=null) {
				response.setEstado(Constantes.valTransaccionOk);
				response.setMsg(Constantes.msgActualizarCentroCostoOK);
				response.setDefaultObj(respCeCos);
			}else {
				response.setEstado(Constantes.valTransaccionError);
				response.setMsg(Constantes.msgActualizarCentroCostoError);
			}
			return response;
		}catch(Exception e) {
			System.out.println(this.getClass().getSimpleName() + " actualizarCentroCosto. ERROR : " + e.getMessage());
			throw new ExceptionResponse(new Date(), this.getClass().getSimpleName() + "/actualizar",
					e.getStackTrace()[0].getFileName() + " => " + e.getStackTrace()[0].getMethodName() + " => "
							+ e.getClass() + " => message: " + e.getMessage() + "=> linea nro: "
							+ e.getStackTrace()[0].getLineNumber(),
					ceCos);
		}				
	}
	
	
	@Transactional(propagation = Propagation.REQUIRED,rollbackFor=Exception.class)
	@DeleteMapping("/{idCentroCosto}")
	public ResponseWrapper eliminar (@PathVariable("idCentroCosto") Integer id) throws Exception {
		try {
			ResponseWrapper response = new ResponseWrapper();
			Boolean cat = service.eliminar(id);
			
			if(!cat) {
				response.setEstado(Constantes.valTransaccionOk);
				response.setMsg(Constantes.msgEliminarCentroCostoOK);
				response.setDefaultObj(cat);
			}else {
				response.setEstado(Constantes.valTransaccionError);
				response.setMsg(Constantes.msgEliminarCentroCostoError);
			}
			return response;
		}catch(Exception e) {
			System.out.println(this.getClass().getSimpleName() + " eliminarCentroCosto. ERROR : " + e.getMessage());
			throw new ExceptionResponse(new Date(), this.getClass().getSimpleName() + "/"+id,
					e.getStackTrace()[0].getFileName() + " => " + e.getStackTrace()[0].getMethodName() + " => "
							+ e.getClass() + " => message: " + e.getMessage() + "=> linea nro: "
							+ e.getStackTrace()[0].getLineNumber(),
					id);
		}				
	}
}

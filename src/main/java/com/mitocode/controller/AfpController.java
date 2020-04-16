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
import com.mitocode.model.Afp;
import com.mitocode.model.Empresa;
import com.mitocode.service.AfpService;
import com.mitocode.util.Constantes;

@RestController
@RequestMapping("/api/afp")
public class AfpController {

	@Autowired
	private AfpService service;

	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	@DeleteMapping("/{idAfp}")
	public ResponseWrapper eliminar(@PathVariable("idAfp") Integer id) throws Exception {

		try {
			ResponseWrapper response = new ResponseWrapper();
			Boolean resp = service.eliminar(id);

			if (!resp) {
				response.setEstado(Constantes.valTransaccionOk);
				response.setMsg(Constantes.msgEliminarAfpOK);
				response.setDefaultObj(resp);
			} else {
				response.setEstado(Constantes.valTransaccionError);
				response.setMsg(Constantes.msgEliminarAfpError);
				response.setDefaultObj(resp);
			}
			
			return response;
		} catch (Exception e) {
			System.out.println(this.getClass().getSimpleName() + " eliminarAfp. ERROR : " + e.getMessage());
			throw new ExceptionResponse(new Date(), this.getClass().getSimpleName() + "/" + id,
					e.getStackTrace()[0].getFileName() + " => " + e.getStackTrace()[0].getMethodName() + " => "
							+ e.getClass() + " => message: " + e.getMessage() + "=> linea nro: "
							+ e.getStackTrace()[0].getLineNumber(),
					id);
		}
	}

	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	@PostMapping("/listarXEmpresa")
	public ResponseWrapper listarXempresa(@RequestBody Empresa empresa) throws Exception {

		if (empresa.getIdEmpresa() == null) {
			throw new ExceptionResponse(new Date(), this.getClass().getSimpleName() + "/listarXEmpresa",
					Constantes.msgListarAdeSueldoError + " no se ha especificado una empresa valida", empresa);
		}

		try {
			ResponseWrapper response = new ResponseWrapper();
			List lsafp = service.listarXEmpresa(empresa);

			if (lsafp != null) {
				response.setEstado(Constantes.valTransaccionOk);
				response.setMsg(Constantes.msgListarXEmpresaAfpOK);
				response.setAaData(lsafp);
			} else {
				response.setEstado(Constantes.valTransaccionError);
				response.setMsg(Constantes.msgListarXEmpresaAfpError);
			}
			
			return response;
		} catch (Exception e) {
			System.out.println(this.getClass().getSimpleName() + " listarAfpPorEmpresa. ERROR : " + e.getMessage());
			throw new ExceptionResponse(new Date(), this.getClass().getSimpleName() + "/listarXEmpresa",
					e.getStackTrace()[0].getFileName() + " => " + e.getStackTrace()[0].getMethodName() + " => "
							+ e.getClass() + " => message: " + e.getMessage() + "=> linea nro: "
							+ e.getStackTrace()[0].getLineNumber(),
					empresa);
		}
	}

	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	@PostMapping("/registrar")
	public ResponseWrapper insertar(@Valid @RequestBody EmpresaDTO empresaDTO, BindingResult result) throws Exception {
	
		if (result.hasErrors()) {
			List<String> errors = result.getFieldErrors().stream().map(err -> {
				return err.getDefaultMessage();
			}).collect(Collectors.toList());
			throw new ExceptionResponse(new Date(), this.getClass().getSimpleName() + "/registrar",
					"Error en la validacion: Lista de Errores:" + errors.toString(), empresaDTO);
		}

		try {
			ResponseWrapper response = new ResponseWrapper();
			Afp afp = empresaDTO.getAfp();
			afp.setEmpresa(empresaDTO.getEmpresa());
			Afp respAfp = service.registrar(afp);
			if (respAfp != null) {
				response.setEstado(Constantes.valTransaccionOk);
				response.setMsg(Constantes.msgRegistrarAfpOK);
				response.setDefaultObj(respAfp);
			} else {
				response.setEstado(Constantes.valTransaccionError);
				response.setMsg(Constantes.msgRegistrarAfpError);
			}
			
			return response;
		} catch (Exception e) {
			System.out.println(this.getClass().getSimpleName() + " registrarAFP. ERROR : " + e.getMessage());
			throw new ExceptionResponse(new Date(), this.getClass().getSimpleName() + "/registrar",
					e.getStackTrace()[0].getFileName() + " => " + e.getStackTrace()[0].getMethodName() + " => "
							+ e.getClass() + " => message: " + e.getMessage() + "=> linea nro: "
							+ e.getStackTrace()[0].getLineNumber(),
					empresaDTO);
		}
	}

	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	@PostMapping("/modificar")
	public ResponseWrapper modificar(@Valid @RequestBody EmpresaDTO empresaDTO, BindingResult result) throws Exception {

		if (result.hasErrors()) {
			List<String> errors = result.getFieldErrors().stream().map(err -> {
				return err.getDefaultMessage();
			}).collect(Collectors.toList());
			throw new ExceptionResponse(new Date(), this.getClass().getSimpleName() + "/modificar",
					"Error en la validacion: Lista de Errores:" + errors.toString(), empresaDTO);
		}

		try {
			ResponseWrapper response = new ResponseWrapper();
			Afp afp = empresaDTO.getAfp();
			afp.setEmpresa(empresaDTO.getEmpresa());
			Afp respAfp = service.modificar(afp);
			if (respAfp != null) {
				response.setEstado(Constantes.valTransaccionOk);
				response.setMsg(Constantes.msgActualizarAfpOK);
				response.setDefaultObj(respAfp);
			} else {
				response.setEstado(Constantes.valTransaccionError);
				response.setMsg(Constantes.msgActualizarAfpError);
			}
			
			return response;
		} catch (Exception e) {
			System.out.println(this.getClass().getSimpleName() + " actualizarAFP. ERROR : " + e.getMessage());
			throw new ExceptionResponse(new Date(), this.getClass().getSimpleName() + "/modificar",
					e.getStackTrace()[0].getFileName() + " => " + e.getStackTrace()[0].getMethodName() + " => "
							+ e.getClass() + " => message: " + e.getMessage() + "=> linea nro: "
							+ e.getStackTrace()[0].getLineNumber(),
					empresaDTO);
		}
	}

}

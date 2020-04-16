package com.mitocode.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mitocode.dto.ResponseWrapper;
import com.mitocode.exception.ExceptionResponse;
import com.mitocode.model.Perfil;
import com.mitocode.service.ModuloService;
import com.mitocode.service.PerfilService;
import com.mitocode.util.Constantes;


@RestController
@RequestMapping("/api/modulo")
public class ModuloController {

	@Autowired
	private ModuloService service;
	
	@Autowired
	private PerfilService service_perfil;
	
	@PostMapping("/listar")
	public ResponseWrapper listar(@RequestBody Perfil perfil) throws Exception {
		
		if (perfil.getIdPerfil() == null) {
			throw new ExceptionResponse(new Date(), this.getClass().getSimpleName() + "/listar",
					Constantes.msgListarXPerfilModuloError + " no se ha especificado un perfil valida", perfil);
		}
		
		try {
			ResponseWrapper response = new ResponseWrapper();
			List res_modulo = service.listarModuloPorPerfil(perfil);
			if (res_modulo != null) {
				response.setEstado(Constantes.valTransaccionOk);
				response.setMsg(Constantes.msgListarXPerfilModuloOk);
				response.setAaData(res_modulo);
			} else {
				response.setEstado(Constantes.valTransaccionError);
				response.setMsg(Constantes.msgListarXPerfilModuloError);
			}
			return response;
		} catch (Exception e) {
			System.out.println(this.getClass().getSimpleName() + " listarModulosPorPerfil. ERROR : " + e.getMessage());
			throw new ExceptionResponse(new Date(), this.getClass().getSimpleName() + "/listar",
					e.getStackTrace()[0].getFileName() + " => " + e.getStackTrace()[0].getMethodName() + " => "
							+ e.getClass() + " => message: " + e.getMessage() + "=> linea nro: "
							+ e.getStackTrace()[0].getLineNumber(),
					perfil);
		}
	}
	
	@GetMapping("/listarPerfiles")
	public ResponseWrapper listar() throws Exception {
		try {
			ResponseWrapper response = new ResponseWrapper();
			List res_perfil = service_perfil.listar();
			if (res_perfil != null) {
				response.setEstado(Constantes.valTransaccionOk);
				response.setMsg(Constantes.msgListarPerfilesOk);
				response.setAaData(res_perfil);
			} else {
				response.setEstado(Constantes.valTransaccionError);
				response.setMsg(Constantes.msgListarPerfilesError);
			}
			return response;
		} catch (Exception e) {
			System.out.println(this.getClass().getSimpleName() + " listarPerfiles. ERROR : " + e.getMessage());
			throw new ExceptionResponse(new Date(), this.getClass().getSimpleName() + "/listarPerfiles",
					e.getStackTrace()[0].getFileName() + " => " + e.getStackTrace()[0].getMethodName() + " => "
							+ e.getClass() + " => message: " + e.getMessage() + "=> linea nro: "
							+ e.getStackTrace()[0].getLineNumber(),
					null);
		}
	}
}

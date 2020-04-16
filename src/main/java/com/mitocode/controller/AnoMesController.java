package com.mitocode.controller;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mitocode.dto.ResponseWrapper;
import com.mitocode.exception.ExceptionResponse;
import com.mitocode.model.Empresa;
import com.mitocode.model.PdoAno;
import com.mitocode.model.PdoMes;
import com.mitocode.service.AnoMesService;
import com.mitocode.util.Constantes;

@RestController
@RequestMapping("/api/anomes")
public class AnoMesController {

	@Autowired
	AnoMesService service;

	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	@PostMapping("/listarPorEmpresa")
	public ResponseWrapper listarPorEmpresa(@RequestBody Empresa empresa) throws Exception {

		if (empresa.getIdEmpresa() == null) {
			throw new ExceptionResponse(new Date(), this.getClass().getSimpleName() + "/listarPorEmpresa",
					Constantes.msgListarAñosError + " no se ha especificado una empresa valida", empresa);
		}

		try {
			ResponseWrapper response = new ResponseWrapper();
			List lsano = service.listarPorEmpresa(empresa);
			if (lsano != null) {
				response.setEstado(Constantes.valTransaccionOk);
				response.setMsg(Constantes.msgTransaccionOk);
				response.setAaData(lsano);
			} else {
				response.setEstado(Constantes.valTransaccionError);
				response.setMsg(Constantes.msgTransaccionError);
			}

			return response;
		} catch (Exception e) {
			System.out.println(this.getClass().getSimpleName() + " listarAñosPorEmpresa. ERROR : " + e.getMessage());
			throw new ExceptionResponse(new Date(), this.getClass().getSimpleName() + "/listarPorEmpresa",
					e.getStackTrace()[0].getFileName() + " => " + e.getStackTrace()[0].getMethodName() + " => "
							+ e.getClass() + " => message: " + e.getMessage() + "=> linea nro: "
							+ e.getStackTrace()[0].getLineNumber(),
					empresa);
		}
	}

	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	@GetMapping("/listarMeses")
	public ResponseWrapper listarMeses() throws Exception {

		try {
			ResponseWrapper response = new ResponseWrapper();
			List lsmeses = service.listarMeses();
			if (lsmeses != null) {
				response.setEstado(Constantes.valTransaccionOk);
				response.setMsg(Constantes.msgListarMesesOk);
				response.setAaData(lsmeses);
			} else {
				response.setEstado(Constantes.valTransaccionError);
				response.setMsg(Constantes.msgListarMesesError);
			}

			return response;
		} catch (Exception e) {
			System.out.println(this.getClass().getSimpleName() + " listarMeses. ERROR : " + e.getMessage());
			throw new ExceptionResponse(new Date(), this.getClass().getSimpleName() + "/listarMeses",
					e.getStackTrace()[0].getFileName() + " => " + e.getStackTrace()[0].getMethodName() + " => "
							+ e.getClass() + " => message: " + e.getMessage() + "=> linea nro: "
							+ e.getStackTrace()[0].getLineNumber(),
					null);
		}
	}

	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	@PostMapping("/registrar")
	public ResponseWrapper registrar(@Valid @RequestBody PdoAno pdoAno, BindingResult result) throws Exception {

		if (result.hasErrors()) {
			List<String> errors = result.getFieldErrors().stream().map(err -> {
				return err.getDefaultMessage();
			}).collect(Collectors.toList());
			throw new ExceptionResponse(new Date(), this.getClass().getSimpleName() + "/registrar",
					"Error en la validacion: Lista de Errores:" + errors.toString(), pdoAno);
		}

		try {
			ResponseWrapper response = new ResponseWrapper();
			PdoAno res_encontrado = service.buscarSiExistePorDesc(pdoAno.getEmpresa(), pdoAno);
			if (res_encontrado != null) {
				response.setEstado(Constantes.valTransaccionError);
				response.setMsg(Constantes.msgAnoRepetidoOk);
				response.setDefaultObj(res_encontrado);
				return response;
			} else {
				PdoAno res_ano = service.registrar(pdoAno);
				if (res_ano != null) {
					response.setEstado(Constantes.valTransaccionOk);
					response.setMsg(Constantes.msgRegistrarAnoOk);
					response.setDefaultObj(res_ano);
				} else {
					response.setEstado(Constantes.valTransaccionError);
					response.setMsg(Constantes.msgRegistrarAnoError);
				}
			}

			return response;
		} catch (Exception e) {
			System.out.println(this.getClass().getSimpleName() + " registrarAnoMes. ERROR : " + e.getMessage());
			throw new ExceptionResponse(new Date(), this.getClass().getSimpleName() + "/registrar",
					e.getStackTrace()[0].getFileName() + " => " + e.getStackTrace()[0].getMethodName() + " => "
							+ e.getClass() + " => message: " + e.getMessage() + "=> linea nro: "
							+ e.getStackTrace()[0].getLineNumber(),
					pdoAno);
		}
	}

	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	@PutMapping("/modificarMes")
	public ResponseWrapper actualizarMes(@Valid @RequestBody PdoMes pdomes, BindingResult result) throws Exception {

		if (result.hasErrors()) {
			List<String> errors = result.getFieldErrors().stream().map(err -> {
				return err.getDefaultMessage();
			}).collect(Collectors.toList());
			throw new ExceptionResponse(new Date(), this.getClass().getSimpleName() + "/modificarMes",
					"Error en la validacion: Lista de Errores:" + errors.toString(), pdomes);
		}

		try {
			ResponseWrapper response = new ResponseWrapper();
			PdoMes res_mes = service.ModificarMes(pdomes);
			if (res_mes != null) {
				response.setEstado(Constantes.valTransaccionOk);
				response.setMsg(Constantes.msgActualizarMesOk);
				response.setDefaultObj(res_mes);
			} else {
				response.setEstado(Constantes.valTransaccionError);
				response.setMsg(Constantes.msgActualizarMesError);
			}
			return response;
		} catch (Exception e) {
			System.out.println(this.getClass().getSimpleName() + " modificarMes. ERROR : " + e.getMessage());
			throw new ExceptionResponse(new Date(), this.getClass().getSimpleName() + "/modificarMes",
					e.getStackTrace()[0].getFileName() + " => " + e.getStackTrace()[0].getMethodName() + " => "
							+ e.getClass() + " => message: " + e.getMessage() + "=> linea nro: "
							+ e.getStackTrace()[0].getLineNumber(),
					pdomes);
		}
	}

}

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
import com.mitocode.model.Asistencia;
import com.mitocode.service.AsistenciaService;
import com.mitocode.util.Constantes;

@RestController
@RequestMapping("/api/asistencia")
public class AsistenciaController {

	@Autowired
	AsistenciaService service;

	@PostMapping("/listarXTrabajadorAnoMes")
	public ResponseWrapper listarXTrabajadorXAnoXMes(@Valid @RequestBody Asistencia asistencia, BindingResult result)
			throws Exception {

		if (result.hasErrors()) {
			List<String> errors = result.getFieldErrors().stream().map(err -> {
				return err.getDefaultMessage();

			}).collect(Collectors.toList());
			errors.remove(null);
			throw new ExceptionResponse(new Date(), this.getClass().getSimpleName() + "/listarXTrabajadorAnoMes",
					"Error en la validacion: Lista de Errores:" + errors.toString(), asistencia);
		}

		try {
			ResponseWrapper response = new ResponseWrapper();
			List lsasist = service.buscarPorTrabajador(asistencia.getTrabajador(), asistencia.getPdoAno(),
					asistencia.getPdoMes());
			if (lsasist != null) {
				response.setEstado(Constantes.valTransaccionOk);
				response.setMsg(Constantes.msgListarAsistenciaOK);
				response.setAaData(lsasist);
			} else {
				response.setEstado(Constantes.valTransaccionError);
				response.setMsg(Constantes.msgListarAsistenciaError);
			}

			return response;
		} catch (Exception e) {
			System.out.println(this.getClass().getSimpleName() + "listarAsistenciasPorTrabajadorAnoMes. ERROR : "
					+ e.getMessage());
			throw new ExceptionResponse(new Date(), this.getClass().getSimpleName() + "/listarXTrabajadorAnoMes",
					e.getStackTrace()[0].getFileName() + " => " + e.getStackTrace()[0].getMethodName() + " => "
							+ e.getClass() + " => message: " + e.getMessage() + "=> linea nro: "
							+ e.getStackTrace()[0].getLineNumber(),
					asistencia);
		}
	}

	@PostMapping("/buscarFecha")
	public ResponseWrapper buscarFecha(@Valid @RequestBody Asistencia asistencia, BindingResult result)
			throws Exception {

		if (result.hasErrors()) {
			List<String> errors = result.getFieldErrors().stream().map(err -> {
				return err.getDefaultMessage();

			}).collect(Collectors.toList());
			throw new ExceptionResponse(new Date(), this.getClass().getSimpleName() + "/buscarFecha",
					"Error en la validacion: Lista de Errores:" + errors.toString(), asistencia);
		}

		try {
			ResponseWrapper response = new ResponseWrapper();
			Boolean resp = service.buscarPorFechaYTrabajador(asistencia.getFecha(), asistencia.getTrabajador());
			response.setDefaultObj(resp);
			return response;

		} catch (Exception e) {
			System.out.println(this.getClass().getSimpleName() + "buscarFecha. ERROR : " + e.getMessage());
			throw new ExceptionResponse(new Date(), this.getClass().getSimpleName() + "/buscarFecha",
					e.getStackTrace()[0].getFileName() + " => " + e.getStackTrace()[0].getMethodName() + " => "
							+ e.getClass() + " => message: " + e.getMessage() + "=> linea nro: "
							+ e.getStackTrace()[0].getLineNumber(),
					asistencia);
		}
	}

	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	@PostMapping("/registrar")
	public ResponseWrapper registrar(@Valid @RequestBody Asistencia asistencia, BindingResult result) throws Exception {
		ResponseWrapper response = new ResponseWrapper();

		if (result.hasErrors()) {
			List<String> errors = result.getFieldErrors().stream().map(err -> {
				return err.getDefaultMessage();
			}).collect(Collectors.toList());
			throw new ExceptionResponse(new Date(), this.getClass().getSimpleName() + "/registrar",
					"Error en la validacion: Lista de Errores:" + errors.toString(), asistencia);
		}
		try {
			Asistencia res_asistencia = service.registrar(asistencia);
			if (res_asistencia != null) {
				response.setEstado(Constantes.valTransaccionOk);
				response.setMsg(Constantes.msgRegistrarAsistenciaOK);
				response.setDefaultObj(res_asistencia);
			} else {
				response.setEstado(Constantes.valTransaccionError);
				response.setMsg(Constantes.msgRegistrarAsistenciaError);
			}
		} catch (Exception e) {
			System.out.println(this.getClass().getSimpleName() + " registrarAsistencia. ERROR : " + e.getMessage());
			throw new ExceptionResponse(new Date(), this.getClass().getSimpleName() + "/registrar",
					e.getStackTrace()[0].getFileName() + " => " + e.getStackTrace()[0].getMethodName() + " => "
							+ e.getClass() + " => message: " + e.getMessage() + "=> linea nro: "
							+ e.getStackTrace()[0].getLineNumber(),
					asistencia);
		}

		return response;
	}

	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	@PutMapping("/modificar")
	public ResponseWrapper modificar(@Valid @RequestBody Asistencia asistencia, BindingResult result) throws Exception {
		
		if (result.hasErrors()) {
			List<String> errors = result.getFieldErrors().stream().map(err -> {
				return err.getDefaultMessage();
			}).collect(Collectors.toList());
			throw new ExceptionResponse(new Date(), this.getClass().getSimpleName() + "/modificar",
					"Error en la validacion: Lista de Errores:" + errors.toString(), asistencia);
		}
		
		try {
			ResponseWrapper response = new ResponseWrapper();
			Asistencia resp_asist = service.modificar(asistencia);
			if (resp_asist != null) {
				response.setEstado(Constantes.valTransaccionOk);
				response.setMsg(Constantes.msgActualizarAsistenciaOK);
				response.setDefaultObj(resp_asist);
			} else {
				response.setEstado(Constantes.valTransaccionError);
				response.setMsg(Constantes.msgActualizarAsistenciaError);
			}
			
			return response;
		} catch (Exception e) {
			System.out.println(this.getClass().getSimpleName() + " modificarAsistencia. ERROR : " + e.getMessage());
			throw new ExceptionResponse(new Date(), this.getClass().getSimpleName() + "/modificar",
					e.getStackTrace()[0].getFileName() + " => " + e.getStackTrace()[0].getMethodName() + " => "
							+ e.getClass() + " => message: " + e.getMessage() + "=> linea nro: "
							+ e.getStackTrace()[0].getLineNumber(),
					asistencia);
		}
	}

	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	@DeleteMapping("/{idAsistencia}")
	public ResponseWrapper eliminar(@PathVariable("idAsistencia") Integer id) throws Exception {
		try {
			ResponseWrapper response = new ResponseWrapper();

			Boolean resp = service.eliminar(id);

			if (resp) {
				response.setEstado(Constantes.valTransaccionOk);
				response.setMsg(Constantes.msgEliminarAsistenciaOK);
				response.setDefaultObj(resp);
			} else {
				response.setEstado(Constantes.valTransaccionError);
				response.setMsg(Constantes.msgEliminarAsistenciaError);
				response.setDefaultObj(resp);
			}
			return response;
		} catch (Exception e) {
			System.out.println(this.getClass().getSimpleName() + " eliminarAsistencia. ERROR : " + e.getMessage());
			throw new ExceptionResponse(new Date(), this.getClass().getSimpleName() + "/" + id,
					e.getStackTrace()[0].getFileName() + " => " + e.getStackTrace()[0].getMethodName() + " => "
							+ e.getClass() + " => message: " + e.getMessage() + "=> linea nro: "
							+ e.getStackTrace()[0].getLineNumber(),
					id);
		}
	}

}

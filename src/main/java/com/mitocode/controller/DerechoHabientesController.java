package com.mitocode.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.mitocode.dto.ResponseWrapper;
import com.mitocode.dto.TrabajadorDTO;
import com.mitocode.exception.ExceptionResponse;
import com.mitocode.model.DerechoHabientes;
import com.mitocode.model.Trabajador;
import com.mitocode.service.DerechoHabientesService;
import com.mitocode.service.TrabajadorService;
import com.mitocode.util.Constantes;

@RestController
@RequestMapping("/api/derechohabientes")
public class DerechoHabientesController {

	@Autowired
	DerechoHabientesService service;

	@Autowired
	TrabajadorService service_trab;

	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	@PostMapping("/registrar")
	public ResponseWrapper registrar(@Valid @RequestBody TrabajadorDTO trabajadorDTO, BindingResult result)
			throws Exception {

		if (result.hasErrors()) {
			List<String> errors = result.getFieldErrors().stream().map(err -> {
				return err.getDefaultMessage();
			}).collect(Collectors.toList());
			throw new ExceptionResponse(new Date(), this.getClass().getSimpleName() + "/registrar",
					"Error en la validacion: Lista de Errores:" + errors.toString(), trabajadorDTO);
		}

		try {
			ResponseWrapper response = new ResponseWrapper();

			DerechoHabientes derHab = trabajadorDTO.getDerechoHabientes();
			derHab.setTrabajador(trabajadorDTO.getTrabajador());
			derHab.setEstado(Constantes.ConsActivo);
			DerechoHabientes resp = service.registrar(derHab);

			if (resp != null) {
				response.setEstado(Constantes.valTransaccionOk);
				response.setMsg(Constantes.msgRegistrarDerHabOk);
				response.setDefaultObj(resp);
			} else {
				response.setEstado(Constantes.valTransaccionError);
				response.setMsg(Constantes.msgRegistrarDerHabError);
			}

			return response;
		} catch (Exception e) {
			System.out
					.println(this.getClass().getSimpleName() + " registrarDerechoHabiente. ERROR : " + e.getMessage());
			throw new ExceptionResponse(new Date(), this.getClass().getSimpleName() + "/registrar",
					e.getStackTrace()[0].getFileName() + " => " + e.getStackTrace()[0].getMethodName() + " => "
							+ e.getClass() + " => message: " + e.getMessage() + "=> linea nro: "
							+ e.getStackTrace()[0].getLineNumber(),
					trabajadorDTO);
		}
	}

	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	@PostMapping("/listarxTrab")
	public ResponseWrapper listarXTrab(@RequestBody Trabajador trab) throws Exception {

		if (trab.getIdTrabajador() == null) {
			throw new ExceptionResponse(new Date(), this.getClass().getSimpleName() + "/listarxTrab",
					Constantes.msgListarDerHabError + " no se ha especificado una empresa valida", trab);
		}

		try {
			ResponseWrapper response = new ResponseWrapper();
			List resp = service.listarXTrab(trab);
			if (resp != null) {
				response.setEstado(Constantes.valTransaccionOk);
				response.setMsg(Constantes.msgListarDerHabOk);
				response.setAaData(resp);
			} else {
				response.setEstado(Constantes.valTransaccionError);
				response.setMsg(Constantes.msgListarDerHabError);
			}
			return response;
		} catch (Exception e) {
			System.out.println(
					this.getClass().getSimpleName() + " listarDerechoHabientePorTrabajador. ERROR : " + e.getMessage());
			throw new ExceptionResponse(new Date(), this.getClass().getSimpleName() + "/listarxTrab",
					e.getStackTrace()[0].getFileName() + " => " + e.getStackTrace()[0].getMethodName() + " => "
							+ e.getClass() + " => message: " + e.getMessage() + "=> linea nro: "
							+ e.getStackTrace()[0].getLineNumber(),
					trab);
		}
	}

	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	@PostMapping("/darBaja")
	public ResponseWrapper darBaja(@Valid @RequestBody DerechoHabientes derHab, BindingResult result) throws Exception {

		if (result.hasErrors()) {
			List<String> errors = result.getFieldErrors().stream().map(err -> {
				return err.getDefaultMessage();
			}).collect(Collectors.toList());
			throw new ExceptionResponse(new Date(), this.getClass().getSimpleName() + "/darBaja",
					"Error en la validacion: Lista de Errores:" + errors.toString(), derHab);
		}

		try {
			ResponseWrapper response = new ResponseWrapper();
			derHab.setEstado(Constantes.ConsInActivo);
			DerechoHabientes resp = service.modificar(derHab);

			if (resp != null) {
				response.setEstado(Constantes.valTransaccionOk);
				response.setMsg(Constantes.msgDarBajaDerHabOk);
				response.setDefaultObj(resp);
			} else {
				response.setEstado(Constantes.valTransaccionError);
				response.setMsg(Constantes.msgDarBajaDerHabError);
			}

			return response;
		} catch (Exception e) {
			System.out.println(this.getClass().getSimpleName() + " darBaja. ERROR : " + e.getMessage());
			throw new ExceptionResponse(new Date(), this.getClass().getSimpleName() + "/darBaja",
					e.getStackTrace()[0].getFileName() + " => " + e.getStackTrace()[0].getMethodName() + " => "
							+ e.getClass() + " => message: " + e.getMessage() + "=> linea nro: "
							+ e.getStackTrace()[0].getLineNumber(),
					derHab);
		}
	}

	// ***********************************************
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	@PostMapping("/subirArchivo/{idDerechoHabiente}")
	public ResponseWrapper subirArchivo(@RequestParam("file") MultipartFile file,
			@PathVariable("idDerechoHabiente") Integer id) throws Exception {

		try {
			ResponseWrapper response = new ResponseWrapper();

			String nombreArch = file.getOriginalFilename();
			String tipoArc = "";

			if (nombreArch.contains(".docx")) {
				tipoArc = ".docx";
			} else if (nombreArch.contains(".jpg")) {
				tipoArc = ".jpg";
			} else if (nombreArch.contains(".png")) {
				tipoArc = ".png";
			} else if (nombreArch.contains(".doc")) {
				tipoArc = ".doc";
			}

			DerechoHabientes respDH = service.encontrarDH(id);
			Trabajador respTrab = service_trab.encontrarTrab(respDH.getTrabajador().getIdTrabajador());

			if (respDH.getNombreArchivo() == null) {

				if (respDH.getIdTipoDerechoHabiente() == 1) {
					String rutaAlmacenamientoCY = "src/main/resources/DerechoHabiente/CY";
					String nombreArchivoCY = respTrab.getNroDoc() + "_DH_" + respDH.getApellido() + "_"
							+ respDH.getNombre() + tipoArc;
					respDH.setNombreArchivo(nombreArchivoCY);
					service.registrar(respDH);
					Path rutaArchivo = Paths.get(rutaAlmacenamientoCY).resolve(nombreArchivoCY).toAbsolutePath();
					try {
						Files.copy(file.getInputStream(), rutaArchivo);
					} catch (IOException e) {
						throw e;
					}

				} else if (respDH.getIdTipoDerechoHabiente() == 2) {
					String rutaAlmacenamientoHIC = "src/main/resources/DerechoHabiente/HIC";
					String nombreArchivoHIC = respTrab.getNroDoc() + "_DH_" + respDH.getApellido() + "_"
							+ respDH.getNombre() + tipoArc;
					Path rutaArchivo = Paths.get(rutaAlmacenamientoHIC).resolve(nombreArchivoHIC).toAbsolutePath();
					respDH.setNombreArchivo(nombreArchivoHIC);
					service.registrar(respDH);
					try {
						Files.copy(file.getInputStream(), rutaArchivo);
					} catch (IOException e) {
						throw e;
					}

				} else {
					String rutaAlmacenamientoMG = "src/main/resources/DerechoHabiente/MG";

					String nombreArchivoMG = respTrab.getNroDoc() + "_DH_" + respDH.getApellido() + "_"
							+ respDH.getNombre() + tipoArc;
					respDH.setNombreArchivo(nombreArchivoMG);
					service.registrar(respDH);
					Path rutaArchivo = Paths.get(rutaAlmacenamientoMG).resolve(nombreArchivoMG).toAbsolutePath();
					try {
						Files.copy(file.getInputStream(), rutaArchivo);
					} catch (IOException e) {
						throw e;
					}
				}
				response.setEstado(1);
				response.setMsg("Archivo registrado");
				return response;

			} else {
				response.setEstado(2);
				response.setMsg("Ya hay un archivo registrado");
				return response;
			}
		} catch (Exception e) {
			System.out.println(this.getClass().getSimpleName() + " subirArchivo. ERROR : " + e.getMessage());
			throw new ExceptionResponse(new Date(), this.getClass().getSimpleName() + "/subirArchivo/"+id,
					e.getStackTrace()[0].getFileName() + " => " + e.getStackTrace()[0].getMethodName() + " => "
							+ e.getClass() + " => message: " + e.getMessage() + "=> linea nro: "
							+ e.getStackTrace()[0].getLineNumber(),
					id);
		}
	}

}

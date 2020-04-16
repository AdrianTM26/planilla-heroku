package com.mitocode.controller;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.mitocode.dto.PlanillaDTO;
import com.mitocode.dto.ResponseWrapper;
import com.mitocode.exception.ExceptionResponse;
import com.mitocode.model.PdoAno;
import com.mitocode.model.PdoMes;
import com.mitocode.model.Rhe;
import com.mitocode.model.Trabajador;
import com.mitocode.service.AnoMesService;
import com.mitocode.service.RheService;
import com.mitocode.service.TrabajadorService;
import com.mitocode.util.Constantes;

@RestController
@RequestMapping("/api/rhe")
public class RheController {

	@Autowired
	RheService service;

	@Autowired
	TrabajadorService service_trab;

	@Autowired
	AnoMesService service_am;

	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	@PostMapping("/listarUltimos")
	public ResponseWrapper listarUlt(@RequestBody Trabajador trabajador) throws Exception {
		
		if (trabajador.getIdTrabajador() == null) {
			throw new ExceptionResponse(new Date(), this.getClass().getSimpleName() + "/listarUltimos",
					Constantes.msgListarAdeSueldoError + " no se ha especificado un trabajador valido", trabajador);
		}
		
		try {
			ResponseWrapper response = new ResponseWrapper();
			List resp = service.listarUlt(trabajador.getIdTrabajador());
			if (resp.size() > 0) {
				response.setEstado(Constantes.valTransaccionOk);
				response.setMsg(Constantes.msgListarRHEOk);
			} else if (resp.size() == 0) {
				response.setEstado(Constantes.valTransaccionOk);
				response.setMsg(Constantes.msgListarRHEOkVacio);
			} else {
				response.setEstado(Constantes.valTransaccionError);
				response.setMsg(Constantes.msgListarRHEError);
			}
			response.setAaData(resp);
			return response;
		} catch (Exception e) {
			System.out.println(this.getClass().getSimpleName() + " listarUltimos. ERROR : " + e.getMessage());
			throw new ExceptionResponse(new Date(), this.getClass().getSimpleName() + "/listarUltimos",
					e.getStackTrace()[0].getFileName() + " => " + e.getStackTrace()[0].getMethodName() + " => "
							+ e.getClass() + " => message: " + e.getMessage() + "=> linea nro: "
							+ e.getStackTrace()[0].getLineNumber(),
					trabajador);
		}
	}

	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	@PostMapping("/registrar/{idTrab}/{idAno}/{idMes}")
	public ResponseWrapper registrar(@RequestParam("file") MultipartFile file, @PathVariable("idTrab") Integer id,
			@PathVariable("idAno") Integer idAno, @PathVariable("idMes") Integer idMes) throws Exception {
		try {
			ResponseWrapper response = new ResponseWrapper();
			Rhe rhe = new Rhe();

			Date fechaHoy = new Date();
			Timestamp fechaRegistro = new Timestamp(fechaHoy.getTime());

			Trabajador trab = service_trab.encontrarTrab(id);
			PdoAno pdoAno = service_am.encontrarAno(idAno);
			PdoMes pdoMes = service_am.encontrarMes(idMes);

			rhe.setFechaReg(fechaRegistro);
			rhe.setTrabajador(trab);
			rhe.setPdoAno(pdoAno);
			rhe.setPdoMes(pdoMes);

			String rutaAlmacenamiento = "src/main/resources/DocumentosRHE/RHE";
			String fileRuc = file.getOriginalFilename().substring(0, 11);
			String fileCorrelativo = (file.getOriginalFilename().substring(16)).replace(".pdf", "");

			if (fileRuc.equals(trab.getNroDoc())) {

				String nombreArchivo = "HRE_" + fileCorrelativo + "_" + fileRuc + "_" + pdoMes.getAbrev() + "_"
						+ pdoAno.getDescripcion() + ".pdf";

				Path rutaArchivo = Paths.get(rutaAlmacenamiento).resolve(nombreArchivo).toAbsolutePath();

				int digCorrel = fileCorrelativo.length();
				boolean existeArchivo = false;

				List<Rhe> lsRhe = service.encontrarXTrab(trab);
				for (int i = 0; i < lsRhe.size(); i++) {
					if (lsRhe.get(i).getNombreArchivo().substring(4, 4 + digCorrel).equals(fileCorrelativo)) {
						existeArchivo = true;
					}
				}
				if (existeArchivo) {
					response.setEstado(2);
					response.setMsg("Este recibo por honorario ya ha sido registrado anteriormente");
				} else {
					rhe.setNombreArchivo(nombreArchivo);
					Rhe resp = service.registrar(rhe);
					if (resp != null) {
						Files.copy(file.getInputStream(), rutaArchivo);
						response.setEstado(Constantes.valTransaccionOk);
						response.setMsg(Constantes.msgRegistrarRHEOk);
						response.setDefaultObj(resp);
					} else {
						response.setEstado(Constantes.valTransaccionOk);
						response.setMsg(Constantes.msgRegistrarRHEError);
					}
				}

			} else {
				response.setEstado(2);
				response.setMsg("Este recibo por honorario no pertenece al trabajador");
			}
			return response;
		} catch (Exception e) {
			System.out.println(this.getClass().getSimpleName() + " registrarRHE. ERROR : " + e.getMessage());
			throw new ExceptionResponse(new Date(), this.getClass().getSimpleName() + "/registrar",
					e.getStackTrace()[0].getFileName() + " => " + e.getStackTrace()[0].getMethodName() + " => "
							+ e.getClass() + " => message: " + e.getMessage() + "=> linea nro: "
							+ e.getStackTrace()[0].getLineNumber(),
					null);
		}
	}

	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	@DeleteMapping("/{idRhe}")
	public ResponseWrapper eliminar(@PathVariable("idRhe") Integer id) throws Exception {
		try {
			ResponseWrapper response = new ResponseWrapper();

			Rhe respRhe = service.encontrarRhe(id);
			String nombreArchivo = respRhe.getNombreArchivo();
			Boolean resp = service.eliminar(id);

			String rutaAlmacenamiento = "src/main/resources/DocumentosRHE/RHE";
			Path rutaArchivo = Paths.get(rutaAlmacenamiento).resolve(nombreArchivo).toAbsolutePath();
			File archivoAnterior = rutaArchivo.toFile();

			if (resp) {
				response.setEstado(Constantes.valTransaccionOk);
				response.setMsg(Constantes.msgEliminarRHEOk);
				response.setDefaultObj(resp);
				archivoAnterior.delete();
			} else {
				response.setEstado(Constantes.valTransaccionError);
				response.setMsg(Constantes.msgEliminarRHEError);
			}
			return response;
		} catch (Exception e) {
			System.out.println(this.getClass().getSimpleName() + " eliminarRHE. ERROR : " + e.getMessage());
			throw new ExceptionResponse(new Date(), this.getClass().getSimpleName() + "/"+id,
					e.getStackTrace()[0].getFileName() + " => " + e.getStackTrace()[0].getMethodName() + " => "
							+ e.getClass() + " => message: " + e.getMessage() + "=> linea nro: "
							+ e.getStackTrace()[0].getLineNumber(),
					id);
		}
	}

	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	@PostMapping("/listarRHEs")
	public ResponseWrapper listarRHEs(@Valid @RequestBody PlanillaDTO planDTO, BindingResult result) throws Exception {
		
		if (result.hasErrors()) {
			List<String> errors = result.getFieldErrors().stream().map(err -> {
				return err.getDefaultMessage();
			}).collect(Collectors.toList());
			throw new ExceptionResponse(new Date(), this.getClass().getSimpleName() + "/listarRHEs",
					"Error en la validacion: Lista de Errores:" + errors.toString(), planDTO);
		}

		try {
			ResponseWrapper response = new ResponseWrapper();
			List resp = service.encontrarRhes(planDTO.getTrabajador(), planDTO.getPdoAno(), planDTO.getPdoMes());
			if (resp.size() > 0) {
				response.setEstado(Constantes.valTransaccionOk);
				response.setMsg(Constantes.msgListarRHEOk);
				response.setAaData(resp);
			} else if (resp.size() == 0) {
				response.setEstado(2);
				response.setMsg("El trabajador no cuenta con recibos por honorarios en esta fecha");
			} else {
				response.setEstado(Constantes.valTransaccionOk);
				response.setMsg(Constantes.msgListarRHEError);
			}
			return response;
		} catch (Exception e) {
			System.out.println(this.getClass().getSimpleName() + " listarRHEs. ERROR : " + e.getMessage());
			throw new ExceptionResponse(new Date(), this.getClass().getSimpleName() + "/listarRHEs",
					e.getStackTrace()[0].getFileName() + " => " + e.getStackTrace()[0].getMethodName() + " => "
							+ e.getClass() + " => message: " + e.getMessage() + "=> linea nro: "
							+ e.getStackTrace()[0].getLineNumber(),
					planDTO);
		}
	}

	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	@GetMapping("/descargar/{nombreDoc:.+}")
	public ResponseEntity<Resource> descargarRhe(@PathVariable("nombreDoc") String nombreDoc) throws Exception {
		try {
			String rutaDescarga = "src/main/resources/DocumentosRHE/RHE";
			Path rutaArchivo = Paths.get(rutaDescarga).resolve(nombreDoc).toAbsolutePath();
			Resource recurso = null;
			recurso = new UrlResource(rutaArchivo.toUri());
			HttpHeaders cabecera = new HttpHeaders();
			cabecera.add(HttpHeaders.CONTENT_DISPOSITION, "attachement; filename=\"" + recurso.getFilename() + "\"");
			return new ResponseEntity<Resource>(recurso, cabecera, HttpStatus.OK);

		} catch (Exception e) {
			System.out.println(this.getClass().getSimpleName() + " descargarRhe. ERROR : " + e.getMessage());
			throw new ExceptionResponse(new Date(), this.getClass().getSimpleName() + "/descargar/"+nombreDoc,
					e.getStackTrace()[0].getFileName() + " => " + e.getStackTrace()[0].getMethodName() + " => "
							+ e.getClass() + " => message: " + e.getMessage() + "=> linea nro: "
							+ e.getStackTrace()[0].getLineNumber(),
					nombreDoc);
		}
	}

}

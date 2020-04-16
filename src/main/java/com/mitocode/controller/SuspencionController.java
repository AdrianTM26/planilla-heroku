package com.mitocode.controller;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.mitocode.dto.ResponseWrapper;
import com.mitocode.exception.ExceptionResponse;
import com.mitocode.model.Suspencion;
import com.mitocode.model.Trabajador;
import com.mitocode.service.SuspencionService;
import com.mitocode.service.TrabajadorService;
import com.mitocode.util.Constantes;

@RestController
@RequestMapping("/api/suspencion")
public class SuspencionController {

	@Autowired
	SuspencionService service;

	@Autowired
	TrabajadorService service_trab;

	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	@PostMapping("/subirArchivo/{idTrabajador}")
	public ResponseWrapper subirArchivo(@RequestParam("file") MultipartFile file,
			@PathVariable("idTrabajador") Integer id) throws Exception {
		try {
			ResponseWrapper response = new ResponseWrapper();
			Suspencion susp = new Suspencion();

			Date fechaHoy = new Date();
			Timestamp fechaRegistro = new Timestamp(fechaHoy.getTime());

			SimpleDateFormat formatear = new SimpleDateFormat("dd_MM_yyyy");
			String fechaSEntr = formatear.format(fechaRegistro);
			int anoEnt = Integer.parseInt(fechaSEntr.substring(6));

			Trabajador respTrab = service_trab.encontrarTrab(id);
			Suspencion respSusp = service.encontrarSusp(respTrab);

			String rutaAlmacenamiento = "src/main/resources/DocumentosRHE/Suspenciones";
			String nombreArchivo = "SUSP_" + respTrab.getNroDoc() + "_" + fechaSEntr + ".pdf";

			Path ruta = Paths.get(rutaAlmacenamiento).resolve(nombreArchivo).toAbsolutePath();
			File archivoAnterior = ruta.toFile();
			int anoAnt = 0;

			if (respSusp != null) {
				String fechaSAnt = formatear.format(respSusp.getFechaRegistro());
				anoAnt = Integer.parseInt(fechaSAnt.substring(6));
			}
			if (!archivoAnterior.exists()) {
				Path rutaArchivo = Paths.get(rutaAlmacenamiento).resolve(nombreArchivo).toAbsolutePath();
				susp.setNombreArchivo(nombreArchivo);
				susp.setTrabajador(respTrab);
				susp.setFechaRegistro(fechaRegistro);
				service.registrar(susp);
				response.setEstado(Constantes.ConsActivo);
				response.setMsg("Guardado correctamente");
				try {
					Files.copy(file.getInputStream(), rutaArchivo);
				} catch (IOException e) {
					throw e;
				}

			} else if (anoEnt > anoAnt) {
				archivoAnterior.delete();
				Path rutaArchivo = Paths.get(rutaAlmacenamiento).resolve(nombreArchivo).toAbsolutePath();
				try {
					Files.copy(file.getInputStream(), rutaArchivo);
				} catch (IOException e) {
					throw e;
				}
				respSusp.setNombreArchivo(nombreArchivo);
				respSusp.setFechaRegistro(fechaRegistro);
				service.registrar(respSusp);
				response.setEstado(Constantes.ConsActivo);
				response.setMsg("Guardado correctamente");
			} else {
				response.setEstado(2);
				response.setMsg("La suspención aún esta vigente para el año " + anoEnt);
			}
			return response;
		} catch (Exception e) {
			System.out.println(this.getClass().getSimpleName() + "subirArchivoSuspencion. ERROR : " + e.getMessage());
			throw new ExceptionResponse(new Date(), this.getClass().getSimpleName() + "/subirArchivo/"+id,
					e.getStackTrace()[0].getFileName() + " => " + e.getStackTrace()[0].getMethodName() + " => "
							+ e.getClass() + " => message: " + e.getMessage() + "=> linea nro: "
							+ e.getStackTrace()[0].getLineNumber(),
					id);
		}
	}
}

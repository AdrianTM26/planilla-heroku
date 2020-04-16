package com.mitocode.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
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

import com.mitocode.dto.AdelantoSueldoDTO;
import com.mitocode.dto.ResponseWrapper;
import com.mitocode.exception.ExceptionResponse;
import com.mitocode.model.AdelantoSueldo;
import com.mitocode.model.CuotaAdelanto;
import com.mitocode.model.PdoAno;
import com.mitocode.model.PdoMes;
import com.mitocode.model.Trabajador;
import com.mitocode.service.AdelantoSueldoService;
import com.mitocode.service.AnoMesService;
import com.mitocode.service.CuotaAdelantoService;
import com.mitocode.service.TrabajadorService;
import com.mitocode.util.Constantes;

@RestController
@RequestMapping("/api/adelantoSueldo")
public class AdelantoSueldoController {

	@Autowired
	AdelantoSueldoService service_as;

	@Autowired
	CuotaAdelantoService service_ca;

	@Autowired
	AnoMesService service_am;

	@Autowired
	TrabajadorService service_trab;

	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	@PostMapping("/registrarSolicitud")
	public ResponseWrapper registarAdeSue(@Valid @RequestBody AdelantoSueldoDTO adeSueDTO, BindingResult result)
			throws Exception {

		if (result.hasErrors()) {
			List<String> errors = result.getFieldErrors().stream().map(err -> {
				return err.getDefaultMessage();
			}).collect(Collectors.toList());
			throw new ExceptionResponse(new Date(), this.getClass().getSimpleName() + "/registrarSolicitud",
					"Error en la validacion: Lista de Errores:" + errors.toString(), adeSueDTO);
		}

		try {

			ResponseWrapper response = new ResponseWrapper();
			PdoAno pdoAno = service_am.encontrarAno(adeSueDTO.getPdoAno().getIdPdoAno());
			PdoMes pdoMes = service_am.encontrarMes(adeSueDTO.getPdoMes().getIdPdoMes());

			Date hoy = new Date();
			Timestamp fechaHoy = new Timestamp(hoy.getTime());

			SimpleDateFormat formatear = new SimpleDateFormat("dd_MM_yyyy");
			String fechaRegistro = formatear.format(fechaHoy);

			int anoHoy = Integer.parseInt(fechaRegistro.substring(6));
			int mesHoy = Integer.parseInt(fechaRegistro.substring(3, 5));

			if (pdoAno.getDescripcion() < anoHoy) {
				response.setEstado(2);
				response.setMsg("Seleccione un periodo actual o posterior");

			} else if (pdoAno.getDescripcion() == anoHoy && pdoMes.getIdPdoMes() < mesHoy) {
				response.setEstado(2);
				response.setMsg("Seleccione un periodo actual o posterior");

			} else {
				AdelantoSueldo adeSue = adeSueDTO.getAdelantoSueldo();
				adeSue.setTrabajador(adeSueDTO.getTrabajador());
				adeSue.setFechaSol(fechaHoy);
				adeSue.setEstado(Constantes.ConsInActivo);

				AdelantoSueldo respAdeSue = service_as.registrar(adeSue);

				ResponseWrapper respCuoAde = registarCuoAde(respAdeSue, pdoAno, pdoMes);

				if (respAdeSue != null && respCuoAde != null) {
					response.setEstado(Constantes.valTransaccionOk);
					response.setMsg(Constantes.msgRegistrarAdeSueldoOk);
					response.setDefaultObj(respAdeSue);
				} else {
					response.setEstado(Constantes.valTransaccionError);
					response.setMsg(Constantes.msgRegistrarAdeSueldoError);
				}
			}
			return response;
		} catch (Exception e) {
			System.out.println(this.getClass().getSimpleName() + " registrarAdelantoSueldo. ERROR : " + e.getMessage());
			throw new ExceptionResponse(new Date(), this.getClass().getSimpleName() + "/registrarSolicitud",
					e.getStackTrace()[0].getFileName() + " => " + e.getStackTrace()[0].getMethodName() + " => "
							+ e.getClass() + " => message: " + e.getMessage() + "=> linea nro: "
							+ e.getStackTrace()[0].getLineNumber(),
					adeSueDTO);

		}
	}

	public ResponseWrapper registarCuoAde(AdelantoSueldo adelantoSueldo, PdoAno pdoAno, PdoMes pdoMes) {
		ResponseWrapper response = new ResponseWrapper();

		AdelantoSueldo adeSue = adelantoSueldo;

		double cuotaMes = adeSue.getMontoTotal() / adeSue.getNroCuotas();

		int idMes = 0;
		int idAno = 0;
		int proxAno = 1;
		boolean salto = false;

		for (int i = 0; i < adeSue.getNroCuotas(); i++) {
			CuotaAdelanto cuoAde = new CuotaAdelanto();
			PdoMes respPdoMes = new PdoMes();
			PdoAno respPdoAno = new PdoAno();

			if (salto == false) {
				respPdoMes = service_am.encontrarMes(pdoMes.getIdPdoMes() + idMes);
				respPdoAno = service_am.encontrarAno(pdoAno.getIdPdoAno() + idAno);
				idMes = idMes + 1;
				if (respPdoMes.getIdPdoMes() == 12) {
					idMes = 0;
					idAno = idAno + 1;
					salto = true;
				}
			} else {
				idMes = idMes + 1;
				respPdoMes = service_am.encontrarMes(idMes);
				respPdoAno = service_am.encontrarAno(pdoAno.getIdPdoAno() + idAno);
				if (idMes == 12) {
					idMes = 0;
					idAno = idAno + 1;
				} else if (respPdoAno == null) {
					PdoAno anoSig = new PdoAno();
					anoSig.setDescripcion(pdoAno.getDescripcion() + proxAno);
					proxAno = proxAno + 1;
					anoSig.setEmpresa(pdoAno.getEmpresa());
					service_am.registrar(anoSig);
					respPdoAno = service_am.encontrarAno(pdoAno.getIdPdoAno() + idAno);
				}
			}
			cuoAde.setPdoMes(respPdoMes);
			cuoAde.setPdoAno(respPdoAno);
			cuoAde.setEstado(Constantes.ConsInActivo);
			cuoAde.setMontoCuota(cuotaMes);
			cuoAde.setAdelantoSueldo(adelantoSueldo);

			CuotaAdelanto respCuoAde = service_ca.registrar(cuoAde);
			response.setDefaultObj(respCuoAde);
		}
		return response;
	}

	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	@PostMapping("/listarAdeSueldo")
	public ResponseWrapper listarAdelantoSueldo(@RequestBody Trabajador trab) throws Exception {

		if (trab.getIdTrabajador() == null) {
			throw new ExceptionResponse(new Date(), this.getClass().getSimpleName() + "/listarAdeSueldo",
					Constantes.msgListarAdeSueldoError + " no se ha especificado un trabajador valido", trab);
		}

		try {

			ResponseWrapper response = new ResponseWrapper();
			List lsadeSue = service_as.listarXTrab(trab);

			if (lsadeSue != null) {
				response.setEstado(Constantes.valTransaccionOk);
				response.setMsg(Constantes.msgListarAdeSueldoOk);
				response.setAaData(lsadeSue);
			} else {
				response.setEstado(Constantes.valTransaccionError);
				response.setMsg(Constantes.msgListarAdeSueldoError);
			}

			return response;
		} catch (Exception e) {
			System.out.println(this.getClass().getSimpleName() + " listarAdelantoSueldo. ERROR : " + e.getMessage());
			throw new ExceptionResponse(new Date(), this.getClass().getSimpleName() + "/listarAdeSueldo",
					e.getStackTrace()[0].getFileName() + " => " + e.getStackTrace()[0].getMethodName() + " => "
							+ e.getClass() + " => message: " + e.getMessage() + "=> linea nro: "
							+ e.getStackTrace()[0].getLineNumber(),
					trab);
		}
	}

	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	@PostMapping("/listarDeuda")
	public ResponseWrapper listarDeuda(@RequestBody Trabajador trab) throws Exception {

		if (trab.getIdTrabajador() == null) {
			throw new ExceptionResponse(new Date(), this.getClass().getSimpleName() + "/listarDeuda",
					Constantes.msgListarDeudasError + " no se ha especificado un trabajador valido", trab);
		}

		try {
			ResponseWrapper response = new ResponseWrapper();
			List lsDeuda = service_as.listarDeuda(trab);

			if (lsDeuda.size() >= 2) {
				response.setEstado(3);
				response.setMsg(Constantes.msgListarDeudasOk);
				response.setAaData(lsDeuda);
			} else if (lsDeuda.size() == 1) {
				response.setEstado(Constantes.valTransaccionOk);
				response.setMsg(Constantes.msgListarDeudasOk);
				response.setAaData(lsDeuda);
			} else {
				response.setEstado(Constantes.valTransaccionNoEncontro);
				response.setMsg(Constantes.msgListarDeudasVacioOk);
				response.setAaData(lsDeuda);
			}

			return response;
		} catch (Exception e) {
			System.out.println(this.getClass().getSimpleName() + " listarDeuda. ERROR : " + e.getMessage());
			throw new ExceptionResponse(new Date(), this.getClass().getSimpleName() + "/listarDeuda",
					e.getStackTrace()[0].getFileName() + " => " + e.getStackTrace()[0].getMethodName() + " => "
							+ e.getClass() + " => message: " + e.getMessage() + "=> linea nro: "
							+ e.getStackTrace()[0].getLineNumber(),
					trab);
		}
	}

	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	@PostMapping("/listarCuotas")
	public ResponseWrapper listarCuotas(@RequestBody AdelantoSueldo adesue) throws Exception {

		if (adesue.getIdAdelantoSueldo() == null) {
			throw new ExceptionResponse(new Date(), this.getClass().getSimpleName() + "/listarCuotas",
					Constantes.msgListarNroCuotasError + " no se ha especificado un adelanto de sueldo valido", adesue);
		}

		try {

			ResponseWrapper response = new ResponseWrapper();
			List lscuotas = service_ca.listarXAdeSue(adesue);
			if (lscuotas != null) {
				response.setEstado(Constantes.valTransaccionOk);
				response.setMsg(Constantes.msgListarNroCuotasOk);
				response.setAaData(lscuotas);
			} else {
				response.setEstado(Constantes.valTransaccionError);
				response.setMsg(Constantes.msgListarNroCuotasError);
			}

			return response;
		} catch (Exception e) {
			System.out.println(this.getClass().getSimpleName() + " listarCuotas. ERROR : " + e.getMessage());
			throw new ExceptionResponse(new Date(), this.getClass().getSimpleName() + "/listarCuotas",
					e.getStackTrace()[0].getFileName() + " => " + e.getStackTrace()[0].getMethodName() + " => "
							+ e.getClass() + " => message: " + e.getMessage() + "=> linea nro: "
							+ e.getStackTrace()[0].getLineNumber(),
					adesue);
		}
	}

	@PostMapping("/subirArchivo/{idAdeSue}")
	public ResponseWrapper subirArchivo(@RequestParam("file") MultipartFile file, @PathVariable("idAdeSue") Integer id)
			throws Exception {

		try {
			ResponseWrapper response = new ResponseWrapper();
			AdelantoSueldo adeSue = service_as.econtrarAdeSueldo(id);
			Trabajador trab = adeSue.getTrabajador();
			String nombreArchivo = RutearArchivo(adeSue, trab, file);
			adeSue.setNombreArchivo(nombreArchivo);
			AdelantoSueldo resp = service_as.modificar(adeSue);

			if (resp != null) {
				response.setEstado(Constantes.valTransaccionOk);
				response.setMsg(Constantes.msgGuardarArchivoAdelantoOk);
				response.setDefaultObj(resp);
			} else {
				response.setEstado(Constantes.valTransaccionError);
				response.setMsg(Constantes.msgGuardarArchivoAdelantoError);
			}

			return response;

		} catch (Exception e) {
			System.out.println(this.getClass().getSimpleName() + " subirArchivo. ERROR : " + e.getMessage());
			throw new ExceptionResponse(new Date(), this.getClass().getSimpleName() + "/subirArchivo/" + id,
					e.getStackTrace()[0].getFileName() + " => " + e.getStackTrace()[0].getMethodName() + " => "
							+ e.getClass() + " => message: " + e.getMessage() + "=> linea nro: "
							+ e.getStackTrace()[0].getLineNumber(),
					file);
		}
	}
	
	public String RutearArchivo(AdelantoSueldo adeSue, Trabajador trab, MultipartFile file) throws IOException{
		String rutaAlmacenamiento = "src/main/resources/Adelanto";

		SimpleDateFormat formatear = new SimpleDateFormat("dd_MM_yyyy");
		String fechaRegistro = formatear.format(adeSue.getFechaSol());

		String nombreArchivo = "ACU_ADEL_" + adeSue.getIdAdelantoSueldo() + "_" + trab.getNroDoc() + "_"
				+ fechaRegistro + ".docx";

		Path rutaArchivo = Paths.get(rutaAlmacenamiento).resolve(nombreArchivo).toAbsolutePath();
		Files.copy(file.getInputStream(), rutaArchivo);

		return nombreArchivo;
	}

}

package com.mitocode.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.apache.poi.xwpf.usermodel.ParagraphAlignment;
import org.apache.poi.xwpf.usermodel.TextAlignment;
import org.apache.poi.xwpf.usermodel.UnderlinePatterns;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.mitocode.dto.EmpresaDTO;
import com.mitocode.dto.ResponseWrapper;
import com.mitocode.exception.ExceptionResponse;
import com.mitocode.model.Categoria;
import com.mitocode.model.Contrato;
import com.mitocode.model.Empresa;
import com.mitocode.model.EncargadoPlanilla;
import com.mitocode.model.Parametro;
import com.mitocode.model.Trabajador;
import com.mitocode.service.ContratoService;
import com.mitocode.service.EncargadoPlanillaService;
import com.mitocode.service.TrabajadorService;
import com.mitocode.util.Constantes;
import com.mitocode.util.WordConstante;

@RestController
@RequestMapping("/api/contrato")
public class ContratoController {

	@Autowired
	private ContratoService service;

	@Autowired
	private TrabajadorService service_trab;

	@Autowired
	private EncargadoPlanillaService service_enPlan;

	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	@PostMapping("/nulearCategoria")
	public ResponseWrapper eliminarCategoriadeContrato(@RequestBody Categoria categoria) throws Exception {

		if (categoria.getIdCategoria() == null) {
			throw new ExceptionResponse(new Date(), this.getClass().getSimpleName() + "/nulearCategoria",
					Constantes.msgActualizarCargoError + " no se ha especificado una categoria valida", categoria);
		}

		try {
			ResponseWrapper response = new ResponseWrapper();
			List listContratos = service.eliminarCategoriaPorContrato(categoria);

			if (listContratos != null) {
				response.setEstado(Constantes.valTransaccionOk);
				response.setMsg(Constantes.msgActualizarCategoriaOK);
				response.setAaData(listContratos);
			} else {
				response.setEstado(Constantes.valTransaccionError);
				response.setMsg(Constantes.msgActualizarCategoriaError);
			}
			return response;
		} catch (Exception e) {
			System.out.println(
					this.getClass().getSimpleName() + " eliminarCategoriaDeContrato. ERROR : " + e.getMessage());
			throw new ExceptionResponse(new Date(), this.getClass().getSimpleName() + "/nulearCategoria",
					e.getStackTrace()[0].getFileName() + " => " + e.getStackTrace()[0].getMethodName() + " => "
							+ e.getClass() + " => message: " + e.getMessage() + "=> linea nro: "
							+ e.getStackTrace()[0].getLineNumber(),
					categoria);
		}
	}

	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	@PostMapping("/generarContrato")
	public ResponseWrapper generarContrato(@Valid @RequestBody Contrato contrato, BindingResult result)
			throws Exception {

		if (result.hasErrors()) {
			List<String> errors = result.getFieldErrors().stream().map(err -> {
				return err.getDefaultMessage();
			}).collect(Collectors.toList());
			throw new ExceptionResponse(new Date(), this.getClass().getSimpleName() + "/generarContrato",
					"Error en la validacion: Lista de Errores:" + errors.toString(), contrato);
		}
		try {
			ResponseWrapper response = new ResponseWrapper();

			Trabajador trab = contrato.getTrabajador();
			Empresa emp = contrato.getTrabajador().getEmpresa();

			EmpresaDTO empDTO = new EmpresaDTO();
			Parametro tmp_para = new Parametro();
			tmp_para.setCodigo(Constantes.CODNOMDNIREPRE);
			empDTO.setParametro(tmp_para);
			empDTO.setEmpresa(emp);

			// Dato duro por el momento
			EncargadoPlanilla encargadoPlan = service_enPlan.encontrar(1);

			// **************Vereficar existencia de
			// documento**********************************************************************************
			/*
			 * String rutaVerificar ="src/main/resources/Contrato/Modelo";
			 * String nomContVerificar = "Contrato" + "_"+ trab.getNroDoc() +
			 * "_" + trab.getApePater() + "_" + trab.getNombres() + ".docx";
			 * 
			 * Path rutaExistente =
			 * Paths.get(rutaVerificar).resolve(nomContVerificar).toAbsolutePath
			 * (); File archivoExistente = rutaExistente.toFile();
			 * 
			 * if(archivoExistente.exists()) { archivoExhistente.delete(); }
			 */
			this.crearDocumento(contrato, trab, emp, encargadoPlan);

			response.setMsg("Documento creado");
			System.out.println("documento creado");
			return response;
		} catch (Exception e) {
			System.out.println(this.getClass().getSimpleName() + " generarContrato. ERROR : " + e.getMessage());
			throw new ExceptionResponse(new Date(), this.getClass().getSimpleName() + "/generarContrato",
					e.getStackTrace()[0].getFileName() + " => " + e.getStackTrace()[0].getMethodName() + " => "
							+ e.getClass() + " => message: " + e.getMessage() + "=> linea nro: "
							+ e.getStackTrace()[0].getLineNumber(),
					contrato);
		}
	}

	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	@PostMapping("/subirWord/{idtrabajador}")
	public ResponseWrapper subirWord(@RequestParam("file") MultipartFile file, @PathVariable("idtrabajador") Integer id)
			throws Exception {
		try {
			ResponseWrapper response = new ResponseWrapper();

			Trabajador trab = service_trab.encontrarTrab(id);
			String nrodc = trab.getNroDoc();
			String nombreFile = file.getOriginalFilename().substring(9, 9 + nrodc.length());

			if (nrodc.equals(nombreFile)) {

				Date fechHoy = new Date();
				Timestamp fechaHhoy = new Timestamp(fechHoy.getTime());
				String dia = String.valueOf(fechaHhoy).substring(8, 10);
				String mes = String.valueOf(fechaHhoy).substring(5, 7);
				String ano = String.valueOf(fechaHhoy).substring(0, 4);

				String rutaAlmacenamiento = "src/main/resources/Contrato/ContratoActual";
				String rutAlmContrAntiguo = "src/main/resources/Contrato/ContratoAntiguo";

				String nombreEntrante = "";
				for (int i = 0; i < 20; i++) {
					if (file.getOriginalFilename().contains(" (" + i + ")")) {
						nombreEntrante = file.getOriginalFilename().replace(" (" + i + ")", "");
						break;
					}
				}
				String nombreAnterior = "";
				if (nombreEntrante.equals("")) {
					nombreAnterior = file.getOriginalFilename();
				} else {
					nombreAnterior = nombreEntrante;
				}

				Path rutaArchivo = Paths.get(rutaAlmacenamiento).resolve(nombreAnterior).toAbsolutePath();
				File archivoAnterior = rutaArchivo.toFile();

				if (archivoAnterior.exists()) {

					XWPFDocument doc = new XWPFDocument(
							new FileInputStream(new File(rutaAlmacenamiento + "/" + nombreAnterior)));
					FileOutputStream out = new FileOutputStream(
							new File(rutAlmContrAntiguo + "/" + dia + mes + ano + "_" + nombreAnterior));
					doc.write(out);
					out.close();
					doc.close();
					archivoAnterior.delete();

					if (!archivoAnterior.exists()) {
						String nombreWord = nombreAnterior;
						Path rutaArchivoNuevo = Paths.get(rutaAlmacenamiento).resolve(nombreWord).toAbsolutePath();
						try {
							Files.copy(file.getInputStream(), rutaArchivoNuevo);
						} catch (IOException e) {
							throw e;
						}
						response.setEstado(Constantes.valTransaccionOk);
						response.setMsg(Constantes.msgSubirWordOk);
					} else {
						System.out.println(this.getClass().getSimpleName() + " Error al subir Contrato.");
						throw new Exception(Constantes.msgSubirWordError);
					}

				} else {
					Path rutaArchivoActual = Paths.get(rutaAlmacenamiento).resolve(nombreAnterior).toAbsolutePath();
					try {
						Files.copy(file.getInputStream(), rutaArchivoActual);
					} catch (IOException e) {
						throw e;
					}
					response.setEstado(Constantes.valTransaccionOk);
					response.setMsg(Constantes.msgSubirWordOk);
				}
				return response;
			} else {
				response.setEstado(2);
				response.setMsg("El contrato no pertenece al trabajador");
				return response;
			}
		} catch (Exception e) {
			System.out.println(this.getClass().getSimpleName() + "subirWord. ERROR : " + e.getMessage());
			throw new ExceptionResponse(new Date(), this.getClass().getSimpleName() + "/subirWord/" + id,
					e.getStackTrace()[0].getFileName() + " => " + e.getStackTrace()[0].getMethodName() + " => "
							+ e.getClass() + " => message: " + e.getMessage() + "=> linea nro: "
							+ e.getStackTrace()[0].getLineNumber(),
					file);
		}
	}

	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	@GetMapping("/descargarWord/{nombreDoc:.+}")
	public ResponseEntity<Resource> descargarWord(@PathVariable("nombreDoc") String nombreDoc) throws Exception {
		try {
			String rutaDescarga = "src/main/resources/Contrato/Modelo";
			Path rutaArchivo = Paths.get(rutaDescarga).resolve(nombreDoc).toAbsolutePath();
			Resource recurso = null;
			recurso = new UrlResource(rutaArchivo.toUri());
			HttpHeaders cabecera = new HttpHeaders();
			cabecera.add(HttpHeaders.CONTENT_DISPOSITION, "attachement; filename=\"" + recurso.getFilename() + "\"");
			return new ResponseEntity<Resource>(recurso, cabecera, HttpStatus.OK);

		} catch (Exception e) {
			System.out.println(this.getClass().getSimpleName() + "bajarrWord. ERROR : " + e.getMessage());
			throw new ExceptionResponse(new Date(), this.getClass().getSimpleName() + "/descargarWord/" + nombreDoc,
					e.getStackTrace()[0].getFileName() + " => " + e.getStackTrace()[0].getMethodName() + " => "
							+ e.getClass() + " => message: " + e.getMessage() + "=> linea nro: "
							+ e.getStackTrace()[0].getLineNumber(),
					nombreDoc);
		}
	}

	public void crearDocumento(Contrato contrato, Trabajador trab, Empresa emp, EncargadoPlanilla encargadoPlan)
			throws IOException {
		String iniAct = "";
		String nomEmp = emp.getRazonSocial();
		String nomReprEmp = encargadoPlan.getApellido() + " " + encargadoPlan.getNombre();
		String nomTrab = trab.getApePater().toUpperCase() + " " + trab.getApeMater().toUpperCase() + " "
				+ trab.getNombres().toUpperCase();
		String objSocEmp = "DESARROLLO DE APLICACIONES WEB" + " NULL";
		String motivCont = "PROYECTO PLANILLA" + " NULL";
		String modalidad = "MOVILIDAD INCREMENTO DE ACTIVIDAD" + " NULL";
		String cargTrab = contrato.getCargo().getDescripcion();

		String rucEmp = emp.getRuc();
		String direcEmp = emp.getUbicacion();
		String dniReprEmp = encargadoPlan.getNroDni();
		String numPartReg = "100" + " NULL";
		String regPersJur = "SUNAP" + " NULL";
		String dniTrab = trab.getNroDoc();
		String direTrab = trab.getDireccion() + " en el distrito de " + trab.getDistrito().getDescripcion()
				+ " ubicado en la provicia de " + trab.getDepartamento().getDescripcion();

		String durAnoCont = "2" + " NULLOOO";
		String diaIniCont = String.valueOf(contrato.getFecInicio()).substring(8, 10);
		String mesIniNumero = String.valueOf(contrato.getFecInicio()).substring(5, 7);
		String mesIniCont = "";
		switch (mesIniNumero) {
		case "01":
			mesIniCont = "Enero";
			break;
		case "02":
			mesIniCont = "Ferebro";
			break;
		case "03":
			mesIniCont = "Marzo";
			break;
		case "04":
			mesIniCont = "Abril";
			break;
		case "05":
			mesIniCont = "Mayo";
			break;
		case "06":
			mesIniCont = "Junio";
			break;
		case "07":
			mesIniCont = "Julio";
			break;
		case "08":
			mesIniCont = "Agosto";
			break;
		case "09":
			mesIniCont = "Septiembre";
			break;
		case "10":
			mesIniCont = "Octubre";
			break;
		case "11":
			mesIniCont = "Noviembre";
			break;
		default:
			mesIniCont = "Diciembre";
			break;
		}

		String anoIniCont = String.valueOf(contrato.getFecInicio()).substring(0, 4);
		String diaFinCont = diaIniCont;
		String mesFinCont = mesIniCont;
		int tmpContrato = 3; // El tiempo de contrato es maximo 3 años, debe
								// llegar desde el front
		int numeroAno = tmpContrato + Integer.parseInt(String.valueOf(contrato.getFecInicio()).substring(0, 4));
		String anoFinCont = String.valueOf(numeroAno);

		String diaIniPerPru = "2" + " NULL";
		String mesIniPerPru = "1" + " NULL";
		String anoIniPerPru = "2020" + " NULL";
		String diaFinPerPru = "31" + " NULL";
		String mesFinPerPru = "3" + " NULL";
		String anoFinPerPru = "2020" + " NULL";

		String diaLabIni = "LUNES" + " NULL";
		String diaLabFin = "VIERNES" + " NULL";
		String horLabIni = "8" + " NULL";
		String horLabFin = "6" + " NULL";

		String remMens = String.valueOf(contrato.getSueldoBase());

		String diaFirma = String.valueOf(contrato.getFechaFirma()).substring(8, 10);
		String mesFirmaNumero = String.valueOf(contrato.getFechaFirma()).substring(5, 7);
		String mesFirma = "";

		switch (mesFirmaNumero) {
		case "01":
			mesFirma = "Enero";
			break;
		case "02":
			mesFirma = "Ferebro";
			break;
		case "03":
			mesFirma = "Marzo";
			break;
		case "04":
			mesFirma = "Abril";
			break;
		case "05":
			mesFirma = "Mayo";
			break;
		case "06":
			mesFirma = "Junio";
			break;
		case "07":
			mesFirma = "Julio";
			break;
		case "08":
			mesFirma = "Agosto";
			break;
		case "09":
			mesFirma = "Septiembre";
			break;
		case "10":
			mesFirma = "Octubre";
			break;
		case "11":
			mesFirma = "Noviembre";
			break;
		default:
			mesFirma = "Diciembre";
			break;
		}
		String anoFirma = String.valueOf(contrato.getFechaFirma()).substring(0, 4);

		// *******ENCONTRAR Y MODIFICAR
		// ANOTACIONES*************************************************************************

		WordConstante constante = new WordConstante();

		String titul = constante.titulo().getText1();

		String prfA1 = constante.parrafoA().getText1();
		String prfA2 = constante.parrafoA().getText2().replace("$iniAct$", iniAct);
		String prfA3 = constante.parrafoA().getText3().replace("$nomEmp$", nomEmp).replace("$rucEmp$", rucEmp)
				.replace("$direcEmp$", direcEmp).replace("$nomReprEmp$", nomReprEmp).replace("$dniReprEmp$", dniReprEmp)
				.replace("$numPartReg$", numPartReg).replace("$regPersJur$", regPersJur);
		String prfA4 = constante.parrafoA().getText4();
		String prfA5 = constante.parrafoA().getText5().replace("$nomTrab$", nomTrab).replace("$dniTrab$", dniTrab)
				.replace("$direTrab$", direTrab);
		String prfA6 = constante.parrafoA().getText6();
		String prfA7 = constante.parrafoA().getText7();

		String prfB1 = constante.parrafoB().getText1();
		String prfB2 = constante.parrafoB().getText2().replace("$objSocEmp$", objSocEmp);
		String prfB3 = constante.parrafoB().getText3().replace("$motivCont$", motivCont);

		String prfC1 = constante.parrafoC().getText1();
		String prfC2 = constante.parrafoC().getText2();
		String prfC3 = constante.parrafoC().getText3();
		String prfC4 = constante.parrafoC().getText4().replace("$modalidad$", modalidad);
		String prfC5 = constante.parrafoC().getText5();
		String prfC6 = constante.parrafoC().getText6().replace("$cargTrab$", cargTrab);

		String prfD1 = constante.parrafoD().getText1();
		String prfD2 = constante.parrafoD().getText2().replace("$durAnoCont$", durAnoCont)
				.replace("$diaIniCont$", diaIniCont).replace("$mesIniCont$", mesIniCont)
				.replace("$anoIniCont$", anoIniCont);
		String prfD3 = constante.parrafoD().getText3();
		String prfD4 = constante.parrafoD().getText4().replace("$diaFinCont$", diaFinCont)
				.replace("$mesFinCont$", mesFinCont).replace("$anoFinCont$", anoFinCont);

		String prfE1 = constante.parrafoE().getText1();
		String prfE2 = constante.parrafoE().getText2().replace("$diaIniPerPru$", diaIniPerPru)
				.replace("$mesIniPerPru$", mesIniPerPru).replace("$anoIniPerPru$", anoIniPerPru)
				.replace("$diaFinPerPru$", diaFinPerPru).replace("$mesFinPerPru$", mesFinPerPru)
				.replace("$anoFinPerPru$", anoFinPerPru);
		String prfE3 = constante.parrafoE().getText3();
		String prfE4 = constante.parrafoE().getText4();
		String prfE5 = constante.parrafoE().getText5();

		String prfF1 = constante.parrafoF().getText1();
		String prfF2 = constante.parrafoF().getText2().replace("$diaLabIni$", diaLabIni)
				.replace("$diaLabFin$", diaLabFin).replace("$horLabIni$", horLabIni).replace("$horLabFin$", horLabFin);

		String prfH1 = constante.parrafoH().getText1();
		String prfH2 = constante.parrafoH().getText2();
		String prfH3 = constante.parrafoH().getText3();
		String prfH4 = constante.parrafoH().getText4().replace("$remMens$", remMens);

		String prfL1 = constante.parrafoL().getText1().replace("$diaFirma$", diaFirma).replace("$mesFirma$", mesFirma)
				.replace("$anoFirma$", anoFirma);

		// *********ASIGNAR
		// ESTILOS*************************************************************************************************

		String rutaModelo = "src/main/resources/Contrato/Modelo/";
		XWPFDocument documento = new XWPFDocument();
		FileOutputStream out = new FileOutputStream(new File(rutaModelo + "Contrato" + "_" + trab.getNroDoc() + "_"
				+ trab.getApePater() + "_" + trab.getNombres() + ".docx"));

		XWPFParagraph titulo = documento.createParagraph();
		titulo.setAlignment(ParagraphAlignment.CENTER);
		titulo.setVerticalAlignment(TextAlignment.TOP);
		XWPFRun run1 = titulo.createRun();
		run1.setBold(true);
		run1.setText(titul);
		run1.setFontFamily("Arial");
		run1.setFontSize(12);
		run1.setUnderline(UnderlinePatterns.SINGLE);
		run1.addBreak();

		XWPFParagraph parrafoA = documento.createParagraph();
		parrafoA.setAlignment(ParagraphAlignment.BOTH);

		XWPFRun aA = parrafoA.createRun();
		aA.setText(prfA1);
		aA.setFontFamily("Arial");
		aA.setFontSize(12);
		XWPFRun bA = parrafoA.createRun();
		bA.setText(prfA2);
		bA.setBold(true);
		bA.setFontFamily("Arial");
		bA.setFontSize(12);
		XWPFRun cA = parrafoA.createRun();
		cA.setText(prfA3);
		cA.setFontFamily("Arial");
		cA.setFontSize(12);
		XWPFRun dA = parrafoA.createRun();
		dA.setText(prfA4);
		dA.setBold(true);
		dA.setFontFamily("Arial");
		dA.setFontSize(12);
		XWPFRun eA = parrafoA.createRun();
		eA.setText(prfA5);
		eA.setFontFamily("Arial");
		eA.setFontSize(12);
		XWPFRun fA = parrafoA.createRun();
		fA.setText(prfA6);
		fA.setBold(true);
		fA.setFontFamily("Arial");
		fA.setFontSize(12);
		XWPFRun gA = parrafoA.createRun();
		gA.setText(prfA7);
		gA.setFontFamily("Arial");
		gA.setFontSize(12);

		XWPFParagraph parrafoB = documento.createParagraph();
		parrafoB.setAlignment(ParagraphAlignment.BOTH);

		XWPFRun aB = parrafoB.createRun();
		aB.setBold(true);
		aB.setText(prfB1);
		aB.setFontFamily("Arial");
		aB.setFontSize(12);
		XWPFRun bB = parrafoB.createRun();
		bB.setText(prfB2);
		bB.setFontFamily("Arial");
		bB.setFontSize(12);
		XWPFRun cB = parrafoB.createRun();
		cB.setText(prfB3);
		cB.setFontFamily("Arial");
		cB.setFontSize(12);
		cB.setBold(true);
		cB.setItalic(true);
		cB.setUnderline(UnderlinePatterns.SINGLE);

		XWPFParagraph parrafoC = documento.createParagraph();
		parrafoC.setAlignment(ParagraphAlignment.BOTH);

		XWPFRun aC = parrafoC.createRun();
		aC.setText(prfC1);
		aC.setBold(true);
		aC.setFontFamily("Arial");
		aC.setFontSize(12);
		XWPFRun bC = parrafoC.createRun();
		bC.setText(prfC2);
		bC.setFontFamily("Arial");
		bC.setFontSize(12);
		XWPFRun cC = parrafoC.createRun();
		cC.setText(prfC3);
		cC.setBold(true);
		cC.setFontFamily("Arial");
		cC.setFontSize(12);
		XWPFRun dC = parrafoC.createRun();
		dC.setText(prfC4);
		dC.setFontFamily("Arial");
		dC.setFontSize(12);
		XWPFRun eC = parrafoC.createRun();
		eC.setText(prfC5);
		eC.setBold(true);
		eC.setFontFamily("Arial");
		eC.setFontSize(12);
		XWPFRun fC = parrafoC.createRun();
		fC.setText(prfC6);
		fC.setFontFamily("Arial");
		fC.setFontSize(12);

		XWPFParagraph parrafoD = documento.createParagraph();
		parrafoD.setAlignment(ParagraphAlignment.BOTH);

		XWPFRun aD = parrafoD.createRun();
		aD.setText(prfD1);
		aD.setBold(true);
		aD.setFontFamily("Arial");
		aD.setFontSize(12);
		XWPFRun bD = parrafoD.createRun();
		bD.setText(prfD2);
		bD.setFontFamily("Arial");
		bD.setFontSize(12);
		XWPFRun cD = parrafoD.createRun();
		cD.setText(prfD3);
		cD.setBold(true);
		cD.setFontFamily("Arial");
		cD.setFontSize(12);
		XWPFRun dD = parrafoD.createRun();
		dD.setText(prfD4);
		dD.setFontFamily("Arial");
		dD.setFontSize(12);

		XWPFParagraph parrafoE = documento.createParagraph();
		parrafoE.setAlignment(ParagraphAlignment.BOTH);

		XWPFRun aE = parrafoE.createRun();
		aE.setText(prfE1);
		aE.setBold(true);
		aE.setFontFamily("Arial");
		aE.setFontSize(12);
		XWPFRun bE = parrafoE.createRun();
		bE.setText(prfE2);
		bE.setFontFamily("Arial");
		bE.setFontSize(12);
		bE.addBreak();
		XWPFRun cE = parrafoE.createRun();
		cE.setText(prfE3);
		cE.setFontFamily("Arial");
		cE.setFontSize(12);
		XWPFRun dE = parrafoE.createRun();
		dE.setText(prfE4);
		dE.setBold(true);
		dE.setFontFamily("Arial");
		dE.setFontSize(12);
		XWPFRun eE = parrafoE.createRun();
		eE.setText(prfE5);
		eE.setFontFamily("Arial");
		eE.setFontSize(12);

		XWPFParagraph parrafoF = documento.createParagraph();
		parrafoF.setAlignment(ParagraphAlignment.BOTH);

		XWPFRun aF = parrafoF.createRun();
		aF.setText(prfF1);
		aF.setBold(true);
		aF.setFontFamily("Arial");
		aF.setFontSize(12);
		XWPFRun bF = parrafoF.createRun();
		bF.setText(prfF2);
		bF.setFontFamily("Arial");
		bF.setFontSize(12);

		XWPFParagraph parrafoG = documento.createParagraph();
		parrafoG.setAlignment(ParagraphAlignment.BOTH);

		XWPFRun aG = parrafoG.createRun();
		aG.setText(constante.parrafoG().getText1());
		aG.setBold(true);
		aG.setFontFamily("Arial");
		aG.setFontSize(12);
		XWPFRun bG = parrafoG.createRun();
		bG.setText(constante.parrafoG().getText2());
		bG.setFontFamily("Arial");
		bG.setFontSize(12);

		XWPFParagraph parrafoH = documento.createParagraph();
		parrafoH.setAlignment(ParagraphAlignment.BOTH);

		XWPFRun aH = parrafoH.createRun();
		aH.setText(prfH1);
		aH.setBold(true);
		aH.setFontFamily("Arial");
		aH.setFontSize(12);
		XWPFRun bH = parrafoH.createRun();
		bH.setText(prfH2);
		bH.setFontFamily("Arial");
		bH.setFontSize(12);
		XWPFRun cH = parrafoH.createRun();
		cH.setText(prfH3);
		cH.setBold(true);
		cH.setFontFamily("Arial");
		cH.setFontSize(12);
		XWPFRun dH = parrafoH.createRun();
		dH.setText(prfH4);
		dH.setFontFamily("Arial");
		dH.setFontSize(12);

		XWPFParagraph parrafoI = documento.createParagraph();
		parrafoI.setAlignment(ParagraphAlignment.BOTH);

		XWPFRun aI = parrafoI.createRun();
		aI.setText(constante.parrafoI().getText1());
		aI.setBold(true);
		aI.setFontFamily("Arial");
		aI.setFontSize(12);
		XWPFRun bI = parrafoI.createRun();
		bI.setText(constante.parrafoI().getText2());
		bI.setFontFamily("Arial");
		bI.setFontSize(12);
		XWPFRun cI = parrafoI.createRun();
		cI.setText(constante.parrafoI().getText3());
		cI.setBold(true);
		cI.setFontFamily("Arial");
		cI.setFontSize(12);
		XWPFRun dI = parrafoI.createRun();
		dI.setText(constante.parrafoI().getText4());
		dI.setFontFamily("Arial");
		dI.setFontSize(12);

		XWPFParagraph parrafoJ = documento.createParagraph();
		parrafoI.setAlignment(ParagraphAlignment.BOTH);

		XWPFRun aJ = parrafoJ.createRun();
		aJ.setText(constante.parrafoJ().getText1());
		aJ.setBold(true);
		aJ.setFontFamily("Arial");
		aJ.setFontSize(12);
		XWPFRun bJ = parrafoJ.createRun();
		bJ.setText(constante.parrafoJ().getText2());
		bJ.setFontFamily("Arial");
		bJ.setFontSize(12);
		XWPFRun cJ = parrafoJ.createRun();
		cJ.setText(constante.parrafoJ().getText3());
		cJ.setBold(true);
		cJ.setFontFamily("Arial");
		cJ.setFontSize(12);
		XWPFRun dJ = parrafoJ.createRun();
		dJ.setText(constante.parrafoJ().getText4());
		dJ.setFontFamily("Arial");
		dJ.setFontSize(12);

		XWPFParagraph parrafoK = documento.createParagraph();
		parrafoK.setAlignment(ParagraphAlignment.BOTH);

		XWPFRun aK = parrafoK.createRun();
		aK.setText(constante.parrafoK().getText1());
		aK.setBold(true);
		aK.setFontFamily("Arial");
		aK.setFontSize(12);
		XWPFRun bK = parrafoK.createRun();
		bK.setText(constante.parrafoK().getText2());
		bK.setFontFamily("Arial");
		bK.setFontSize(12);

		XWPFParagraph parrafoL = documento.createParagraph();
		parrafoL.setAlignment(ParagraphAlignment.BOTH);

		XWPFRun aL = parrafoL.createRun();
		aL.setText(prfL1);
		aL.setFontFamily("Arial");
		aL.setFontSize(12);
		aL.addBreak();
		aL.addBreak();

		// ******FIRMAS***************************************************************************************

		XWPFParagraph parrafoM = documento.createParagraph();

		XWPFRun aM = parrafoM.createRun();
		aM.setText(constante.parrafoM().getText1());
		for (int i = 0; i < 7; i++) {
			aM.addTab();
		}
		aM.setText(constante.parrafoM().getText3());
		aM.addBreak();
		aM.setText(constante.parrafoM().getText2());
		for (int i = 0; i < 7; i++) {
			aM.addTab();
		}
		aM.setText(constante.parrafoM().getText4());
		aM.setBold(true);
		aM.setFontFamily("Arial");
		aM.setFontSize(12);
		aM.addBreak();

		documento.write(out);
		out.close();
	}

}

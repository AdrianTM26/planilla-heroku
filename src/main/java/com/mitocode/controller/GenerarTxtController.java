package com.mitocode.controller;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
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
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mitocode.dto.CuentaCargoDTO;
import com.mitocode.dto.ResponseWrapper;
import com.mitocode.exception.ExceptionResponse;
import com.mitocode.model.Contrato;
import com.mitocode.model.CuentaCargo;
import com.mitocode.model.Trabajador;
import com.mitocode.service.ContratoService;
import com.mitocode.service.CuentaCargoService;
import com.mitocode.service.TrabajadorService;
import com.mitocode.util.Constantes;

@RestController
@RequestMapping("/api/generarTxt")
public class GenerarTxtController {

	@Autowired
	ContratoService service_contra;

	@Autowired
	TrabajadorService service_trab;

	@Autowired
	CuentaCargoService service_cueCargo;

	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	@PostMapping("/general")
	public ResponseWrapper generarGeneral(@Valid @RequestBody CuentaCargoDTO cuentaCargoDTO, BindingResult result)
			throws Exception {

		if (result.hasErrors()) {
			List<String> errors = result.getFieldErrors().stream().map(err -> {
				return err.getDefaultMessage();
			}).collect(Collectors.toList());
			throw new ExceptionResponse(new Date(), this.getClass().getSimpleName() + "/general",
					"Error en la validacion: Lista de Errores:" + errors.toString(), cuentaCargoDTO);
		}

		try {
			ResponseWrapper response = new ResponseWrapper();

			List<Contrato> lsContrato = service_contra.listarPorEmpresayCuartaCat(cuentaCargoDTO.getEmpresa());
			CuentaCargo cueCargo = service_cueCargo.encontrarCueCargo(cuentaCargoDTO.getCuentaCargo());
			// List<Trabajador> lsTrabajador = service_trab.listar();
			File file = this.crearTxtGeneral(cuentaCargoDTO, cueCargo, lsContrato);
			response.setEstado(Constantes.valTransaccionOk);
			response.setMsg("Generado con exito");
			response.setDefaultObj(file.getName());
			return response;
		} catch (Exception e) {
			System.out.println(this.getClass().getSimpleName() + " generarGeneral. ERROR : " + e.getMessage());
			throw new ExceptionResponse(new Date(), this.getClass().getSimpleName() + "/general",
					e.getStackTrace()[0].getFileName() + " => " + e.getStackTrace()[0].getMethodName() + " => "
							+ e.getClass() + " => message: " + e.getMessage() + "=> linea nro: "
							+ e.getStackTrace()[0].getLineNumber(),
					cuentaCargoDTO);
		}
	}

	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	@GetMapping("/descargar/{nombreArchivo:.+}")
	public ResponseEntity<Resource> descargarTxt(@PathVariable("nombreArchivo") String nombreArchivo) throws Exception {
		try {
			String rutaDescarga = "src/main/resources/TxtGenerado";
			Path rutaArchivo = Paths.get(rutaDescarga).resolve(nombreArchivo).toAbsolutePath();
			Resource recurso = null;
			recurso = new UrlResource(rutaArchivo.toUri());
			HttpHeaders cabecera = new HttpHeaders();
			cabecera.add(HttpHeaders.CONTENT_DISPOSITION, "attachement; filename=\"" + recurso.getFilename() + "\"");
			return new ResponseEntity<Resource>(recurso, cabecera, HttpStatus.OK);
		} catch (Exception e) {
			System.out.println(this.getClass().getSimpleName() + " descargarTxt. ERROR : " + e.getMessage());
			throw new ExceptionResponse(new Date(), this.getClass().getSimpleName() + "/descargar/" + nombreArchivo,
					e.getStackTrace()[0].getFileName() + " => " + e.getStackTrace()[0].getMethodName() + " => "
							+ e.getClass() + " => message: " + e.getMessage() + "=> linea nro: "
							+ e.getStackTrace()[0].getLineNumber(),
					nombreArchivo);
		}
	}

	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	@PostMapping("/personal")
	public ResponseWrapper generarPersonal(@Valid @RequestBody CuentaCargoDTO cuentaCargoDTO, BindingResult result)
			throws Exception {

		if (result.hasErrors()) {
			List<String> errors = result.getFieldErrors().stream().map(err -> {
				return err.getDefaultMessage();
			}).collect(Collectors.toList());
			throw new ExceptionResponse(new Date(), this.getClass().getSimpleName() + "/general",
					"Error en la validacion: Lista de Errores:" + errors.toString(), cuentaCargoDTO);
		}

		try {
			ResponseWrapper response = new ResponseWrapper();

			List<Contrato> lsContrato = service_contra.listarPorEmpresayCuartaCat(cuentaCargoDTO.getEmpresa());
			CuentaCargo cueCargo = service_cueCargo.encontrarCueCargo(cuentaCargoDTO.getCuentaCargo());
			Contrato cont = cuentaCargoDTO.getContrato();
			Trabajador trab = cont.getTrabajador();

			File file = this.crearTxtPersonal(cuentaCargoDTO, cueCargo, lsContrato, trab, cont);
			response.setEstado(Constantes.valTransaccionOk);
			response.setMsg("Generado con exito");
			response.setDefaultObj(file.getName());
			return response;
		} catch (Exception e) {
			System.out.println(this.getClass().getSimpleName() + " generarPersonal. ERROR : " + e.getMessage());
			throw new ExceptionResponse(new Date(), this.getClass().getSimpleName() + "/personal",
					e.getStackTrace()[0].getFileName() + " => " + e.getStackTrace()[0].getMethodName() + " => "
							+ e.getClass() + " => message: " + e.getMessage() + "=> linea nro: "
							+ e.getStackTrace()[0].getLineNumber(),
					cuentaCargoDTO);
		}
	}

	public File crearTxtGeneral(CuentaCargoDTO cuentaCargoDTO, CuentaCargo cueCargo, List<Contrato> lsContrato)
			throws IOException {
		File file = new File(
				"src/main/resources/TxtGenerado/" + cuentaCargoDTO.getDescripcion().replace(" ", "_") + ".txt");

		if (file.exists()) {
			file.delete();
		}

		FileWriter flWriter = new FileWriter(file);
		BufferedWriter bfWriter = new BufferedWriter(flWriter);

		Long NroCuentaEmp = Long.parseLong(cueCargo.getNroCuenta());
		Long nroCuentaTrab = 0L;

		for (int i = 0; i < lsContrato.size(); i++) {
			nroCuentaTrab = nroCuentaTrab + Long.parseLong(lsContrato.get(i).getNroCta());
		}

		Long sumaCuentasTl = NroCuentaEmp + nroCuentaTrab;
		String sumaCuentasTotal = String.valueOf(sumaCuentasTl);
		int cantDigSumaCuentasTotal = sumaCuentasTotal.length();
		String ceroSumaCuentasTotal = "";
		if (cantDigSumaCuentasTotal < 15) {
			for (int i = cantDigSumaCuentasTotal; i < 15; i++) {
				ceroSumaCuentasTotal += "0";
			}
		}
		String sumaCuentasTotalFnl = ceroSumaCuentasTotal + sumaCuentasTotal;

		String cantTrab = String.valueOf(lsContrato.size());
		int cantDig = cantTrab.length();
		String cero = "";
		if (cantTrab.length() < 6) {
			for (int i = cantDig; i < 6; i++) {
				cero += "0";
			}
		}
		String cantTrabFnl = cero + cantTrab;

		Date hoy = new Date();
		Timestamp fechaHoy = new Timestamp(hoy.getTime());
		SimpleDateFormat formatear = new SimpleDateFormat("yyyyMMdd");
		String fechaEntr = formatear.format(fechaHoy);

		String nroCargoEmp = cueCargo.getNroCuenta(); // Número cargo 13
		String espacioNroCargoEmp = "";
		int catntDigNroCargoEmp = nroCargoEmp.length();
		if (catntDigNroCargoEmp < 13) {
			for (int i = catntDigNroCargoEmp; i < 13; i++) {
				espacioNroCargoEmp += " ";
			}
		}

		String nroCargoEmpFnl = nroCargoEmp + espacioNroCargoEmp;

		String espacio7 = "       ";

		double sueldoTotal = 0.01;
		for (int i = 0; i < lsContrato.size(); i++) {
			sueldoTotal = sueldoTotal + lsContrato.get(i).getSueldoBase();
		}
		String sueldTotal = String.valueOf(sueldoTotal);
		int cantDigSueTot = sueldTotal.length();
		String ceroSueTot = "";
		if (cantDigSueTot < 17) {
			for (int i = cantDigSueTot; i < 17; i++) {
				ceroSueTot += "0";
			}
		}
		// si hay un cero al ultimo falla
		String sueldoTotalFnl = ceroSueTot + sueldTotal;

		String sueldoEntero = sueldoTotalFnl.substring(0, 14);
		String sueldoDecimal = "00";
		// String sueldoDecimal = sueldoTotalFnl.substring(15,17);

		String referencia = cuentaCargoDTO.getDescripcion();
		String espacioRef = "";
		int cantDigRef = referencia.length();
		if (cantDigRef < 40) {
			for (int i = cantDigRef; i < 40; i++) {
				espacioRef += " ";
			}
		}
		String referenciaFnl = referencia + espacioRef;

		flWriter.write("1" + cantTrabFnl + fechaEntr + "4" + "C" + "0001" + nroCargoEmpFnl + espacio7 + sueldoEntero
				+ "." + sueldoDecimal + referenciaFnl + sumaCuentasTotalFnl + "\n\n");

		for (Contrato cont : lsContrato) {

			String tipoCuenta = "";
			if (cont.getTipoCuenta() == 1) {
				tipoCuenta = "A";
			} else if (cont.getTipoCuenta() == 2) {
				tipoCuenta = "C";
			} else {
				tipoCuenta = "B";
			}

			String nroCuenta = cont.getNroCta();
			int cantDigNroCuenta = nroCuenta.length();
			String espacioNroCuenta = "";
			if (cantDigNroCuenta < 20) {
				for (int i = cantDigNroCuenta; i < 20; i++) {
					espacioNroCuenta += " ";
				}
			}
			String nroCuentaFnl = nroCuenta + espacioNroCuenta;

			String tipoDoc = "";
			if (cont.getTrabajador().getTipoDoc().getIdTipoDoc() == 1) {
				tipoDoc = "1";
			} else if (cont.getTrabajador().getTipoDoc().getIdTipoDoc() == 3) {
				tipoDoc = "4";
			} else if (cont.getTrabajador().getTipoDoc().getIdTipoDoc() == 2) {
				tipoDoc = "1";
			} else {
				tipoDoc = "3";
			}

			String nroDoc = cont.getTrabajador().getNroDoc();
			int cantDigNroDoc = nroDoc.length();
			String espacioNroDoc = "";
			if (cantDigNroDoc < 12) {
				for (int i = cantDigNroDoc; i < 12; i++) {
					espacioNroDoc += " ";
				}
			}
			String nroDocFnl = nroDoc + espacioNroDoc;

			String nomTrab = cont.getTrabajador().getNombres() + " " + cont.getTrabajador().getApePater() + " "
					+ cont.getTrabajador().getApeMater();
			int cantDigNomTrab = nomTrab.length();
			String espacioNomTrab = "";
			if (cantDigNomTrab < 75) {
				for (int i = cantDigNomTrab; i < 75; i++) {
					espacioNomTrab += " ";
				}
			}
			String nomTrabFnl = nomTrab + espacioNomTrab;

			String tipoMoneda = String.valueOf(cont.getTipoMoneda());
			String ceroTipoMoneda = "";
			for (int i = tipoMoneda.length(); i < 4; i++) {
				ceroTipoMoneda += "0";
			}

			String tipoMonedaFnl = ceroTipoMoneda + tipoMoneda;

			String sueldoBase = String.valueOf(cont.getSueldoBase());
			int cantDigSueBase = sueldoBase.length();
			String ceroSueBase = "";
			if (cantDigSueBase < 14) {
				for (int i = cantDigSueBase; i < 14; i++) {
					ceroSueBase += "0";
				}
			}
			String sueldoBaseFnl = ceroSueBase + sueldoBase;
			String sueldoBaseEntero = sueldoBaseFnl.substring(0, 14);
			String sueldoBaseDecimal = "00";

			bfWriter.write("2" + tipoCuenta + nroCuentaFnl + tipoDoc + nroDocFnl + "   " + nomTrabFnl
					+ "Referencia Beneficiario" + " " + nroDocFnl + "    " + "Ref Emp" + " " + nroDocFnl + tipoMonedaFnl
					+ sueldoBaseEntero + "." + sueldoBaseDecimal + "N" + "\n");
		}
		bfWriter.close();
		flWriter.close();
		return file;
	}

	public File crearTxtPersonal(CuentaCargoDTO cuentaCargoDTO, CuentaCargo cueCargo, List<Contrato> lsContrato,
			Trabajador trab, Contrato cont) throws IOException {
		File file = new File("src/main/resources/TxtGenerado/" + cuentaCargoDTO.getDescripcion().replace(" ", "_") + "_"
				+ trab.getApePater() + "_" + trab.getApeMater() + "_" + trab.getNombres().replace(" ", "_") + ".txt");

		if (file.exists()) {
			file.delete();
		}

		FileWriter flWriter = new FileWriter(file);
		BufferedWriter bfWriter = new BufferedWriter(flWriter);

		Long NroCuentaEmp = Long.parseLong(cueCargo.getNroCuenta());
		Long nroCuentaTrab = 0L;

		for (int i = 0; i < lsContrato.size(); i++) {
			nroCuentaTrab = nroCuentaTrab + Long.parseLong(lsContrato.get(i).getNroCta());
		}

		Long sumaCuentasTl = NroCuentaEmp + nroCuentaTrab;
		String sumaCuentasTotal = String.valueOf(sumaCuentasTl);
		int cantDigSumaCuentasTotal = sumaCuentasTotal.length();
		String ceroSumaCuentasTotal = "";
		if (cantDigSumaCuentasTotal < 15) {
			for (int i = cantDigSumaCuentasTotal; i < 15; i++) {
				ceroSumaCuentasTotal += "0";
			}
		}

		String sumaCuentasTotalFnl = ceroSumaCuentasTotal + sumaCuentasTotal;

		String cantTrab = String.valueOf(lsContrato.size());
		int cantDig = cantTrab.length();
		String cero = "";
		if (cantTrab.length() < 6) {
			for (int i = cantDig; i < 6; i++) {
				cero += "0";
			}
		}
		String cantTrabFnl = cero + cantTrab;

		Date hoy = new Date();
		Timestamp fechaHoy = new Timestamp(hoy.getTime());
		SimpleDateFormat formatear = new SimpleDateFormat("yyyyMMdd");
		String fechaEntr = formatear.format(fechaHoy);

		String nroCargoEmp = cueCargo.getNroCuenta(); // Número cargo 13
		String espacioNroCargoEmp = "";
		int catntDigNroCargoEmp = nroCargoEmp.length();
		if (catntDigNroCargoEmp < 13) {
			for (int i = catntDigNroCargoEmp; i < 13; i++) {
				espacioNroCargoEmp += " ";
			}
		}

		String nroCargoEmpFnl = nroCargoEmp + espacioNroCargoEmp;

		String espacio7 = "       ";

		double sueldoTotal = 0.01;
		for (int i = 0; i < lsContrato.size(); i++) {
			sueldoTotal = sueldoTotal + lsContrato.get(i).getSueldoBase();
		}
		String sueldTotal = String.valueOf(sueldoTotal);
		int cantDigSueTot = sueldTotal.length();
		String ceroSueTot = "";
		if (cantDigSueTot < 17) {
			for (int i = cantDigSueTot; i < 17; i++) {
				ceroSueTot += "0";
			}
		}

		String sueldoTotalFnl = ceroSueTot + sueldTotal;

		String sueldoEntero = sueldoTotalFnl.substring(0, 14);
		String sueldoDecimal = "00";
		// String sueldoDecimal = sueldoTotalFnl.substring(15,17);

		String referencia = cuentaCargoDTO.getDescripcion();
		String espacioRef = "";
		int cantDigRef = referencia.length();
		if (cantDigRef < 40) {
			for (int i = cantDigRef; i < 40; i++) {
				espacioRef += " ";
			}
		}
		String referenciaFnl = referencia + espacioRef;

		flWriter.write("1" + cantTrabFnl + fechaEntr + "4" + "C" + "0001" + nroCargoEmpFnl + espacio7 + sueldoEntero
				+ "." + sueldoDecimal + referenciaFnl + sumaCuentasTotalFnl + "\n\n");

		// for (Contrato cont : lsContrato) {

		String tipoCuenta = "";
		if (cont.getTipoCuenta() == 1) {
			tipoCuenta = "A";
		} else if (cont.getTipoCuenta() == 2) {
			tipoCuenta = "C";
		} else {
			tipoCuenta = "B";
		}

		String nroCuenta = cont.getNroCta();
		int cantDigNroCuenta = nroCuenta.length();
		String espacioNroCuenta = "";
		if (cantDigNroCuenta < 20) {
			for (int i = cantDigNroCuenta; i < 20; i++) {
				espacioNroCuenta += " ";
			}
		}
		String nroCuentaFnl = nroCuenta + espacioNroCuenta;

		String tipoDoc = "";
		if (cont.getTrabajador().getTipoDoc().getIdTipoDoc() == 1) {
			tipoDoc = "1";
		} else if (cont.getTrabajador().getTipoDoc().getIdTipoDoc() == 3) {
			tipoDoc = "4";
		} else if (cont.getTrabajador().getTipoDoc().getIdTipoDoc() == 2) {
			tipoDoc = "1";
		} else {
			tipoDoc = "3";
		}

		String nroDoc = cont.getTrabajador().getNroDoc();
		int cantDigNroDoc = nroDoc.length();
		String espacioNroDoc = "";
		if (cantDigNroDoc < 12) {
			for (int i = cantDigNroDoc; i < 12; i++) {
				espacioNroDoc += " ";
			}
		}
		String nroDocFnl = nroDoc + espacioNroDoc;

		String nomTrab = cont.getTrabajador().getNombres() + " " + cont.getTrabajador().getApePater() + " "
				+ cont.getTrabajador().getApeMater();
		int cantDigNomTrab = nomTrab.length();
		String espacioNomTrab = "";
		if (cantDigNomTrab < 75) {
			for (int i = cantDigNomTrab; i < 75; i++) {
				espacioNomTrab += " ";
			}
		}
		String nomTrabFnl = nomTrab + espacioNomTrab;

		String tipoMoneda = String.valueOf(cont.getTipoMoneda());
		String ceroTipoMoneda = "";
		for (int i = tipoMoneda.length(); i < 4; i++) {
			ceroTipoMoneda += "0";
		}

		String tipoMonedaFnl = ceroTipoMoneda + tipoMoneda;

		String sueldoBase = String.valueOf(cont.getSueldoBase());
		int cantDigSueBase = sueldoBase.length();
		String ceroSueBase = "";
		if (cantDigSueBase < 14) {
			for (int i = cantDigSueBase; i < 14; i++) {
				ceroSueBase += "0";
			}
		}
		String sueldoBaseFnl = ceroSueBase + sueldoBase;
		String sueldoBaseEntero = sueldoBaseFnl.substring(0, 14);
		String sueldoBaseDecimal = "00";

		bfWriter.write("2" + tipoCuenta + nroCuentaFnl + tipoDoc + nroDocFnl + "   " + nomTrabFnl
				+ "Referencia Beneficiario" + " " + nroDocFnl + "    " + "Ref Emp" + " " + nroDocFnl + tipoMonedaFnl
				+ sueldoBaseEntero + "." + sueldoBaseDecimal + "N" + "\n");
		// }
		bfWriter.close();
		flWriter.close();
		return file;
	}

}

package com.mitocode.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.annotation.Resource;
import javax.sql.DataSource;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mitocode.dto.Reporte;
import com.mitocode.exception.ExceptionResponse;
import com.mitocode.model.Parametro;
import com.mitocode.repo.ParametroRepo;
import com.mitocode.util.Constantes;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;

@RestController
@RequestMapping("/api/reporte")
public class ReporteController {
	
	@Resource(name="dataSource")
	DataSource dataSource;
	
	@Autowired
	ParametroRepo repoParametro;
	
	@Transactional(propagation = Propagation.REQUIRED,rollbackFor=Exception.class)
	@PostMapping("/pdf")
	public byte[] ReportePDF(@Valid @RequestBody Reporte reporte, BindingResult result) throws Exception{
		
		byte[] file=null;
		
		if (result.hasErrors()) {
			List<String> errors = result.getFieldErrors().stream().map(err -> {
				return err.getDefaultMessage();
			}).collect(Collectors.toList());
			throw new ExceptionResponse(new Date(), this.getClass().getSimpleName() + "/pdf",
					"Error en la validacion: Lista de Errores:" + errors.toString(), reporte);
		}

	
		try{			
			Parametro par=repoParametro.findByCodigoAndGrupo(Constantes.CODREPO, Constantes.GRPREPO);
			String ruta = par.getValor();
			JasperPrint print=null;
			Map<String, Object> parametor=new HashMap<String,Object>();
			parametor.put("id_trabajador",reporte.getIdTrabajador());
			parametor.put("id_pdo_mes",reporte.getIdPdoMeS());
			parametor.put("id_pdo_ano",reporte.getIdPdoAno());
			parametor.put("SUBREPORT_DIR",ruta);
			Connection cn= dataSource.getConnection();
			file = this.crearReporte(print, ruta, parametor, cn);
			return file;	
		}catch(Exception e){
			System.out.println(this.getClass().getSimpleName() + " generarReportepdf. ERROR : " +e.getClass().getName()+ e.getMessage());
			throw new ExceptionResponse(new Date(), this.getClass().getSimpleName() + "/pdf",
					e.getStackTrace()[0].getFileName() + " => " + e.getStackTrace()[0].getMethodName() + " => "
							+ e.getClass() + " => message: " + e.getMessage() + "=> linea nro: "
							+ e.getStackTrace()[0].getLineNumber(),
					reporte);
		}
	}
	
	public byte[] crearReporte(JasperPrint print, String ruta, Map<String,Object>parametor, Connection cn) throws FileNotFoundException, JRException{
		byte[] file = null;
		File fileroot = new File(ruta+"Boleta.jasper");
		FileInputStream input = new FileInputStream(fileroot);
		print = JasperFillManager.fillReport(input,parametor,cn);			
		file=JasperExportManager.exportReportToPdf(print);
		return file;
	}

	

}

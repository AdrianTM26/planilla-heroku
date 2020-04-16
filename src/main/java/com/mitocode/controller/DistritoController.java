package com.mitocode.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mitocode.dto.ResponseWrapper;
import com.mitocode.exception.ExceptionResponse;
import com.mitocode.model.Provincia;
import com.mitocode.service.DistritoService;
import com.mitocode.util.Constantes;

@RestController
@RequestMapping("/api/distrito")
public class DistritoController {

	@Autowired
	DistritoService service;
	
	@Transactional(propagation = Propagation.REQUIRED,rollbackFor=Exception.class)
	@PostMapping("/porProvincia")
	public ResponseWrapper listarPorProvincia(@RequestBody Provincia prov) throws Exception {
		
		if (prov.getIdProvincia() == null) {
			throw new ExceptionResponse(new Date(), this.getClass().getSimpleName() + "/porProvincia",
					Constantes.msgListarAdeSueldoError + " no se ha especificado una provincia valida",prov);
		}
		
		try {
			ResponseWrapper response = new ResponseWrapper();
			List lsdist = service.listarPorProvincia(prov);
			if (lsdist != null) {
				response.setEstado(Constantes.valTransaccionOk);
				response.setMsg(Constantes.msgListarDistritoOK);
				response.setAaData(lsdist);
			} else {
				response.setEstado(Constantes.valTransaccionError);
				response.setMsg(Constantes.msgListarDistritoError);
			}
			return response;
		} catch (Exception e) {
			System.out.println(this.getClass().getSimpleName() + " listarDistritos. ERROR : " + e.getMessage());
			throw new ExceptionResponse(new Date(), this.getClass().getSimpleName() + "/porProvincia",
					e.getStackTrace()[0].getFileName() + " => " + e.getStackTrace()[0].getMethodName() + " => "
							+ e.getClass() + " => message: " + e.getMessage() + "=> linea nro: "
							+ e.getStackTrace()[0].getLineNumber(),
					null);
		}
	}
}

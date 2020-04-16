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
import com.mitocode.model.Departamento;
import com.mitocode.service.ProvinciaService;
import com.mitocode.util.Constantes;

@RestController
@RequestMapping("/api/provincia")
public class ProvinciaController {

	@Autowired
	ProvinciaService service;
	
	@Transactional(propagation = Propagation.REQUIRED,rollbackFor=Exception.class)
	@PostMapping("/porDepartamento")
	public ResponseWrapper listarPorDepartamento(@RequestBody Departamento depa) throws Exception {
		
		if (depa.getIdDepartamento() == null) {
			throw new ExceptionResponse(new Date(), this.getClass().getSimpleName() + "/porDepartamento",
					Constantes.msgListarAdeSueldoError + " no se ha especificado un departamento valida", depa);
		}
		
		try {
			ResponseWrapper response = new ResponseWrapper();
			List lsprov = service.listarPorDepartamento(depa);
			if (lsprov != null) {
				response.setEstado(Constantes.valTransaccionOk);
				response.setMsg(Constantes.msgListarProvinciaOK);
				response.setAaData(lsprov);
			} else {
				response.setEstado(Constantes.valTransaccionError);
				response.setMsg(Constantes.msgListarProvinciaError);
			}
			return response;
		} catch (Exception e) {
			System.out.println(this.getClass().getSimpleName() + " listarProvinciaPorDepa. ERROR : " + e.getMessage());
			throw new ExceptionResponse(new Date(), this.getClass().getSimpleName() + "/porDepartamento",
					e.getStackTrace()[0].getFileName() + " => " + e.getStackTrace()[0].getMethodName() + " => "
							+ e.getClass() + " => message: " + e.getMessage() + "=> linea nro: "
							+ e.getStackTrace()[0].getLineNumber(),
					depa);
		}
	}	
}

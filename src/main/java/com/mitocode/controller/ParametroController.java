package com.mitocode.controller;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mitocode.dto.EmpresaDTO;
import com.mitocode.dto.ResponseWrapper;
import com.mitocode.exception.ExceptionResponse;
import com.mitocode.model.Empresa;
import com.mitocode.model.Parametro;
import com.mitocode.service.ParametroService;
import com.mitocode.util.Constantes;

@RestController
@RequestMapping("/api/parametro")
public class ParametroController {

	@Autowired
	private ParametroService service;


	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	@PostMapping("/actualizar")
	public ResponseWrapper modficar(@Valid @RequestBody EmpresaDTO empresadto, BindingResult result) throws Exception {
		

		if (result.hasErrors()) {
			List<String> errors = result.getFieldErrors().stream().map(err -> {
				return err.getDefaultMessage();
			}).collect(Collectors.toList());
			throw new ExceptionResponse(new Date(), this.getClass().getSimpleName() + "/actualizar",
					"Error en la validacion: Lista de Errores:" + errors.toString(), empresadto);
		}
		
		try {
			ResponseWrapper response = new ResponseWrapper();
			Parametro temp = empresadto.getParametro();
			temp.setEmpresa(empresadto.getEmpresa());
			Parametro res_param = service.modificar(temp);
			if (res_param != null) {
				response.setEstado(Constantes.valTransaccionOk);
				response.setMsg(Constantes.msgActualizarParametroOK);
				response.setDefaultObj(res_param);
			} else {
				response.setEstado(Constantes.valTransaccionError);
				response.setMsg(Constantes.msgActualizarParametroError);
			}
			return response;
		} catch (Exception e) {
			System.out.println(this.getClass().getSimpleName() + " listarActualizar. ERROR : " + e.getMessage());
			throw new ExceptionResponse(new Date(), this.getClass().getSimpleName() + "/actualizar",
					e.getStackTrace()[0].getFileName() + " => " + e.getStackTrace()[0].getMethodName() + " => "
							+ e.getClass() + " => message: " + e.getMessage() + "=> linea nro: "
							+ e.getStackTrace()[0].getLineNumber(),
					null);
		}
	}

	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	@PostMapping("/porempresa")
	public ResponseWrapper listarPorEmpresa(@RequestBody Empresa empresa) throws Exception {
		
		if (empresa.getIdEmpresa() == null) {
			throw new ExceptionResponse(new Date(), this.getClass().getSimpleName() + "/porempresa",
					Constantes.msgListarParametroPorEmpresaError + " no se ha especificado una empresa valida", empresa);
		}
		
		try {
			ResponseWrapper response = new ResponseWrapper();
			List lsres = service.listarPorEmpresaActivo(empresa);
			if (lsres != null) {
				response.setEstado(Constantes.valTransaccionOk);
				response.setMsg(Constantes.msgListarParametroPorEmpresaOK);
			} else {
				response.setEstado(Constantes.valTransaccionError);
				response.setMsg(Constantes.msgListarParametroPorEmpresaError);
			}
			response.setAaData(lsres);
			return response;

		} catch (Exception e) {
			System.out.println(this.getClass().getSimpleName() + " listarParametrosPorEmpresa. ERROR : " + e.getMessage());
			throw new ExceptionResponse(new Date(), this.getClass().getSimpleName() + "/porempresa",
					e.getStackTrace()[0].getFileName() + " => " + e.getStackTrace()[0].getMethodName() + " => "
							+ e.getClass() + " => message: " + e.getMessage() + "=> linea nro: "
							+ e.getStackTrace()[0].getLineNumber(),
					null);
		}
	}


	@PostMapping("/obtenerTipoTard")
	public ResponseWrapper obtenerTardanzaPorEmpresa(@RequestBody Empresa empresa) throws Exception {
		
		if (empresa.getIdEmpresa() == null) {
			throw new ExceptionResponse(new Date(), this.getClass().getSimpleName() + "/obtenerTipoTard",
					Constantes.msgBuscarParametroPorCodigoYEmpresaError + " no se ha especificado una empresa valida", empresa);
		}
		
		try {
			ResponseWrapper response = new ResponseWrapper();
			Parametro res_param = service.buscarTardanzaPorEmpresa(empresa);
			if (res_param != null) {
				response.setEstado(Constantes.valTransaccionOk);
				response.setMsg(Constantes.msgBuscarParametroPorCodigoYEmpresaOK);
				response.setDefaultObj(res_param);
			} else {
				response.setEstado(Constantes.valTransaccionError);
				response.setMsg(Constantes.msgBuscarParametroPorCodigoYEmpresaError);
			}
			return response;

		} catch (Exception e) {
			System.out.println(this.getClass().getSimpleName() + " obtenerTardanzaPorEmpresa. ERROR : " + e.getMessage());
			throw new ExceptionResponse(new Date(), this.getClass().getSimpleName() + "/obtenerTipoTard",
					e.getStackTrace()[0].getFileName() + " => " + e.getStackTrace()[0].getMethodName() + " => "
							+ e.getClass() + " => message: " + e.getMessage() + "=> linea nro: "
							+ e.getStackTrace()[0].getLineNumber(),
					null);
		}
	}

	@PostMapping("/obtenerTipoTardRango")
	public ResponseWrapper obtenerTipoTardanzaPorEmpresas(@RequestBody Empresa empresa) throws Exception{
		
		if (empresa.getIdEmpresa() == null) {
			throw new ExceptionResponse(new Date(), this.getClass().getSimpleName() + "/obtenerTipoTardRango",
					Constantes.msgBuscarParametroPorCodigoYEmpresaError + " no se ha especificado una empresa valida", empresa);
		}
		
		try {

			ResponseWrapper response = new ResponseWrapper();
			Parametro res_param = service.buscarRangoPorEmpresa(empresa);
			if (res_param != null) {
				response.setEstado(Constantes.valTransaccionOk);
				response.setMsg(Constantes.msgBuscarParametroPorCodigoYEmpresaOK);
				response.setDefaultObj(res_param);
			} else {
				response.setEstado(Constantes.valTransaccionError);
				response.setMsg(Constantes.msgBuscarParametroPorCodigoYEmpresaError);
			}
			return response;

		} catch (Exception e) {
			System.out.println(this.getClass().getSimpleName() + " obtenerTipoTardanzaPorEmpresa. ERROR : " + e.getMessage());
			throw new ExceptionResponse(new Date(), this.getClass().getSimpleName() + "/obtenerTipoTardRango",
					e.getStackTrace()[0].getFileName() + " => " + e.getStackTrace()[0].getMethodName() + " => "
							+ e.getClass() + " => message: " + e.getMessage() + "=> linea nro: "
							+ e.getStackTrace()[0].getLineNumber(),
					null);
		}
	}

}

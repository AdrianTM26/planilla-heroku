package com.mitocode.controller;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mitocode.dto.CategoriaDTO;
import com.mitocode.dto.ResponseWrapper;
import com.mitocode.exception.ExceptionResponse;
import com.mitocode.model.Cargo;
import com.mitocode.model.Categoria;
import com.mitocode.model.Empresa;
import com.mitocode.service.CargoService;
import com.mitocode.util.Constantes;

@RestController
@RequestMapping("/api/cargo")
public class CargoController {

	@Autowired
	private CargoService service;

	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	@PostMapping("/insertar")
	public ResponseWrapper registrar(@Valid @RequestBody CategoriaDTO categoria, BindingResult result)
			throws Exception {

		if (result.hasErrors()) {
			List<String> errors = result.getFieldErrors().stream().map(err -> {
				return err.getDefaultMessage();
			}).collect(Collectors.toList());
			throw new ExceptionResponse(new Date(), this.getClass().getSimpleName() + "/insertar",
					"Error en la validacion: Lista de Errores:" + errors.toString(), categoria);
		}

		try {
			ResponseWrapper response = new ResponseWrapper();
			Cargo res = new Cargo();
			Cargo tmp = categoria.getCargo();
			tmp.setCategoria(categoria.getCategoria());
			res = service.registrar(tmp);
			if (res != null) {
				response.setEstado(Constantes.valTransaccionOk);
				response.setMsg(Constantes.msgRegistrarCargoOK);
				response.setDefaultObj(res);
			} else {
				response.setEstado(Constantes.valTransaccionError);
				response.setMsg(Constantes.msgRegistrarCargoError);
			}
			return response;
		} catch (Exception e) {
			System.out.println(this.getClass().getSimpleName() + " registrarCargo. ERROR : " + e.getMessage());
			throw new ExceptionResponse(new Date(), this.getClass().getSimpleName() + "/insertar",
					e.getStackTrace()[0].getFileName() + " => " + e.getStackTrace()[0].getMethodName() + " => "
							+ e.getClass() + " => message: " + e.getMessage() + "=> linea nro: "
							+ e.getStackTrace()[0].getLineNumber(),
					categoria);
		}
	}

	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	@PostMapping("/actualizar")
	public ResponseWrapper modifcar(@Valid @RequestBody Cargo cargo, BindingResult result) throws Exception {

		if (result.hasErrors()) {
			List<String> errors = result.getFieldErrors().stream().map(err -> {
				return err.getDefaultMessage();
			}).collect(Collectors.toList());
			throw new ExceptionResponse(new Date(), this.getClass().getSimpleName() + "/actualizar",
					"Error en la validacion: Lista de Errores:" + errors.toString(), cargo);
		}

		try {
			ResponseWrapper response = new ResponseWrapper();
			Cargo res_cargo = service.modificar(cargo);
			if (res_cargo != null) {
				response.setEstado(Constantes.valTransaccionOk);
				response.setMsg(Constantes.msgActualizarCargoOK);
				response.setDefaultObj(res_cargo);
			} else {
				response.setEstado(Constantes.valTransaccionError);
				response.setMsg(Constantes.msgActualizarCargoError);
			}
			return response;
		} catch (Exception e) {
			System.out.println(this.getClass().getSimpleName() + " modificarCargo. ERROR : " + e.getMessage());
			throw new ExceptionResponse(new Date(), this.getClass().getSimpleName() + "/actualizar",
					e.getStackTrace()[0].getFileName() + " => " + e.getStackTrace()[0].getMethodName() + " => "
							+ e.getClass() + " => message: " + e.getMessage() + "=> linea nro: "
							+ e.getStackTrace()[0].getLineNumber(),
					cargo);
		}
	}

	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	@PostMapping("/listarPorCategoria")
	public ResponseWrapper listarPorCategoria(@RequestBody Categoria categoria) throws Exception {

		if (categoria.getIdCategoria() == null) {
			throw new ExceptionResponse(new Date(), this.getClass().getSimpleName() + "/listarPorCategoria",
					Constantes.msgListarCargoError + " no se ha especificado una categoria valida", categoria);
		}

		try {
			ResponseWrapper response = new ResponseWrapper();
			List lsres = service.listarPorCategoria(categoria);
			if (lsres.size() > 0) {
				response.setEstado(Constantes.valTransaccionOk);
				response.setMsg(Constantes.msgListarCargoOK);
				response.setAaData(lsres);
			} else {
				response.setEstado(Constantes.valTransaccionOk);
				response.setMsg(Constantes.msgListarCargoVacio);
			}
			return response;
		} catch (Exception e) {
			System.out.println(this.getClass().getSimpleName() + " listarPorCategoria. ERROR : " + e.getMessage());
			throw new ExceptionResponse(new Date(), this.getClass().getSimpleName() + "/listarPorCategoria",
					e.getStackTrace()[0].getFileName() + " => " + e.getStackTrace()[0].getMethodName() + " => "
							+ e.getClass() + " => message: " + e.getMessage() + "=> linea nro: "
							+ e.getStackTrace()[0].getLineNumber(),
					categoria);
		}
	}

	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	@PostMapping("/buscarPorDescripcion")
	public ResponseWrapper listarPorDescripcion(@RequestBody Cargo cargo) throws Exception {

		if (cargo.getDescripcion() == null) {
			throw new ExceptionResponse(new Date(), this.getClass().getSimpleName() + "/buscarPorDescripcion",
					Constantes.msgListarCargoError + " no se ha especificado un cargo valido", cargo);
		}

		try {
			ResponseWrapper response = new ResponseWrapper();
			Cargo res = service.listarPorDescripcion(cargo);
			if (res != null) {
				response.setEstado(Constantes.valTransaccionOk);
				response.setMsg(Constantes.msgListarPorDescripcionCargoOK);
				response.setDefaultObj(res);
			} else {
				response.setEstado(Constantes.valTransaccionOk);
				response.setMsg(Constantes.msgListarPorDescripcionCargoVACIO);
			}
			return response;

		} catch (Exception e) {
			System.out.println(this.getClass().getSimpleName() + " listarPorDescripcion. ERROR : " + e.getMessage());
			throw new ExceptionResponse(new Date(), this.getClass().getSimpleName() + "/buscarPorDescripcion",
					e.getStackTrace()[0].getFileName() + " => " + e.getStackTrace()[0].getMethodName() + " => "
							+ e.getClass() + " => message: " + e.getMessage() + "=> linea nro: "
							+ e.getStackTrace()[0].getLineNumber(),
					cargo);
		}
	}

	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	@DeleteMapping("/{idCargo}")
	public ResponseWrapper eliminar(@PathVariable("idCargo") Integer id) throws Exception {
		try {
			ResponseWrapper response = new ResponseWrapper();

			Boolean resp = service.eliminar(id);

			if (!resp) {
				response.setEstado(Constantes.valTransaccionOk);
				response.setMsg(Constantes.msgEliminarCargoOK);
				response.setDefaultObj(resp);
			} else {
				response.setEstado(Constantes.valTransaccionError);
				response.setMsg(Constantes.msgEliminarCargoError);
			}
			return response;
		} catch (Exception e) {
			System.out.println(this.getClass().getSimpleName() + " eliminarCargo. ERROR : " + e.getMessage());
			throw new ExceptionResponse(new Date(), this.getClass().getSimpleName() + "/" + id,
					e.getStackTrace()[0].getFileName() + " => " + e.getStackTrace()[0].getMethodName() + " => "
							+ e.getClass() + " => message: " + e.getMessage() + "=> linea nro: "
							+ e.getStackTrace()[0].getLineNumber(),
					id);
		}
	}

	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	@PostMapping("/listarCargoXEmpresa")
	public ResponseWrapper listarXEmpresa(@RequestBody Empresa empresa) throws Exception {
		
		if (empresa.getIdEmpresa() == null) {
			throw new ExceptionResponse(new Date(), this.getClass().getSimpleName() + "/listarCargoXEmpresa",
					Constantes.msgListarCargoError + " no se ha especificado una empresa valida", empresa);
		}
		
		try {
			ResponseWrapper response = new ResponseWrapper();
			List res_cargo = service.listarCargoXEmpresa(empresa);
			if (res_cargo != null) {
				response.setEstado(Constantes.valTransaccionOk);
				response.setMsg(Constantes.msgListarCargoOK);
				response.setAaData(res_cargo);
			} else {
				response.setEstado(Constantes.valTransaccionError);
				response.setMsg(Constantes.msgListarCargoError);
			}
			return response;
		} catch (Exception e) {
			System.out.println(this.getClass().getSimpleName() + " listarPorEmpresa. ERROR : " + e.getMessage());
			throw new ExceptionResponse(new Date(), this.getClass().getSimpleName() + "/listarCargoXEmpresa",
					e.getStackTrace()[0].getFileName() + " => " + e.getStackTrace()[0].getMethodName() + " => "
							+ e.getClass() + " => message: " + e.getMessage() + "=> linea nro: "
							+ e.getStackTrace()[0].getLineNumber(),
					empresa);
		}
	}

}

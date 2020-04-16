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
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mitocode.dto.EmpresaDTO;
import com.mitocode.dto.ResponseWrapper;
import com.mitocode.exception.ExceptionResponse;
import com.mitocode.model.Categoria;
import com.mitocode.model.Empresa;
import com.mitocode.service.CategoriaService;
import com.mitocode.util.Constantes;

@RestController
@RequestMapping("/api/categoria")
public class CategoriaController {

	@Autowired
	private CategoriaService service;

	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	@PostMapping("/insertar")
	public ResponseWrapper insertar(@Valid @RequestBody EmpresaDTO empdto, BindingResult result) throws Exception {

		if (result.hasErrors()) {
			List<String> errors = result.getFieldErrors().stream().map(err -> {
				return err.getDefaultMessage();
			}).collect(Collectors.toList());
			throw new ExceptionResponse(new Date(), this.getClass().getSimpleName() + "/insertar",
					"Error en la validacion: Lista de Errores:" + errors.toString(), empdto);
		}

		try {
			ResponseWrapper response = new ResponseWrapper();
			Categoria cat = empdto.getCategoria();
			cat.setEmpresa(empdto.getEmpresa());

			Categoria cat_resp = service.registrar(cat);

			if (cat_resp != null) {
				response.setEstado(Constantes.valTransaccionOk);
				response.setMsg(Constantes.msgRegistrarCategoriaOK);
				response.setDefaultObj(cat_resp);
			} else {
				response.setEstado(Constantes.valTransaccionError);
				response.setMsg(Constantes.msgRegistrarCategoriaError);
			}
			return response;
		} catch (Exception e) {
			System.out.println(this.getClass().getSimpleName() + " insertarCategoria. ERROR : " + e.getMessage());
			throw new ExceptionResponse(new Date(), this.getClass().getSimpleName() + "/insertar",
					e.getStackTrace()[0].getFileName() + " => " + e.getStackTrace()[0].getMethodName() + " => "
							+ e.getClass() + " => message: " + e.getMessage() + "=> linea nro: "
							+ e.getStackTrace()[0].getLineNumber(),
					empdto);
		}
	}

	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	@PostMapping("/listar")
	public ResponseWrapper listar(@RequestBody Empresa empresa) throws Exception {

		if (empresa.getIdEmpresa() == null) {
			throw new ExceptionResponse(new Date(), this.getClass().getSimpleName() + "/listar",
					Constantes.msgListarXEmpCategoriaError + " no se ha especificado una empresa valida", empresa);
		}

		try {
			ResponseWrapper response = new ResponseWrapper();

			List lscat = service.listarXEmpresa(empresa);

			if (lscat != null) {
				response.setEstado(Constantes.valTransaccionOk);
				response.setMsg(Constantes.msgListarxEmpCategoriaOK);
				response.setAaData(lscat);
			} else {
				response.setEstado(Constantes.valTransaccionError);
				response.setMsg(Constantes.msgListarXEmpCategoriaError);
			}
			return response;
		} catch (Exception e) {
			System.out.println(this.getClass().getSimpleName() + " listarPorEmpresa. ERROR : " + e.getMessage());
			throw new ExceptionResponse(new Date(), this.getClass().getSimpleName() + "/listar",
					e.getStackTrace()[0].getFileName() + " => " + e.getStackTrace()[0].getMethodName() + " => "
							+ e.getClass() + " => message: " + e.getMessage() + "=> linea nro: "
							+ e.getStackTrace()[0].getLineNumber(),
					empresa);
		}
	}

	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	@PostMapping("/actualizar")
	public ResponseWrapper actualizar(@Valid @RequestBody Categoria categoria, BindingResult result) throws Exception {

		if (result.hasErrors()) {
			List<String> errors = result.getFieldErrors().stream().map(err -> {
				return err.getDefaultMessage();
			}).collect(Collectors.toList());
			throw new ExceptionResponse(new Date(), this.getClass().getSimpleName() + "/actualizar",
					"Error en la validacion: Lista de Errores:" + errors.toString(), categoria);
		}

		try {
			ResponseWrapper response = new ResponseWrapper();
			// Categoria cat = empresadto.getCategoria();
			// cat.setEmpresa(empresadto.getEmpresa());
			Categoria res_cat = service.modificar(categoria);

			if (res_cat != null) {
				response.setEstado(Constantes.valTransaccionOk);
				response.setMsg(Constantes.msgActualizarCategoriaOK);
				response.setDefaultObj(res_cat);
			} else {
				response.setEstado(Constantes.valTransaccionError);
				response.setMsg(Constantes.msgActualizarCategoriaError);
			}
			return response;
		} catch (Exception e) {
			System.out.println(this.getClass().getSimpleName() + " actualizarCategoria. ERROR : " + e.getMessage());
			throw new ExceptionResponse(new Date(), this.getClass().getSimpleName() + "/actualizar",
					e.getStackTrace()[0].getFileName() + " => " + e.getStackTrace()[0].getMethodName() + " => "
							+ e.getClass() + " => message: " + e.getMessage() + "=> linea nro: "
							+ e.getStackTrace()[0].getLineNumber(),
					categoria);
		}
	}

	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	@DeleteMapping("/{idCategoria}")
	public ResponseWrapper eliminar(@PathVariable("idCategoria") Integer id) throws Exception {
		try {
			ResponseWrapper response = new ResponseWrapper();

			Boolean resp = service.eliminar(id);

			if (!resp) {
				response.setEstado(Constantes.valTransaccionOk);
				response.setMsg(Constantes.msgEliminarCategoriaOK);
				response.setDefaultObj(resp);
			} else {
				response.setEstado(Constantes.valTransaccionError);
				response.setMsg(Constantes.msgEliminarCategoriaError);
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
	@GetMapping("/buscarpordesc")
	public ResponseWrapper buscar(@RequestBody Categoria categoria) throws Exception {
		
		if (categoria.getDescripcion() == null) {
			throw new ExceptionResponse(new Date(), this.getClass().getSimpleName() + "/buscarpordesc",
					Constantes.msgBuscarCategoriaXDescripcionError + " no se ha especificado una categoria valida", categoria);
		}
		
		try {
			ResponseWrapper response = new ResponseWrapper();
			Categoria cat = service.buscarCatXDes(categoria.getDescripcion());

			if (cat != null) {
				response.setEstado(Constantes.valTransaccionOk);
				response.setMsg(Constantes.msgBuscarCategoriaXDescripcionOK);
				response.setDefaultObj(cat);
			} else {
				response.setEstado(Constantes.valTransaccionError);
				response.setMsg(Constantes.msgBuscarCategoriaXDescripcionError);
			}
			return response;
		} catch (Exception e) {
			System.out.println(this.getClass().getSimpleName() + " buscarPorDescripcion. ERROR : " + e.getMessage());
			throw new ExceptionResponse(new Date(), this.getClass().getSimpleName() + "/buscarpordesc",
					e.getStackTrace()[0].getFileName() + " => " + e.getStackTrace()[0].getMethodName() + " => "
							+ e.getClass() + " => message: " + e.getMessage() + "=> linea nro: "
							+ e.getStackTrace()[0].getLineNumber(),
					categoria);
		}
	}

}

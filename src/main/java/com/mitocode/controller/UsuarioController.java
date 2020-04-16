package com.mitocode.controller;

import java.io.File;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.mitocode.dto.ResponseWrapper;
import com.mitocode.dto.UsuarioDTO;
import com.mitocode.exception.ExceptionResponse;
import com.mitocode.model.Usuario;
import com.mitocode.service.IUsuarioService;
import com.mitocode.util.Constantes;

@RequestMapping("/api/usuario")
@RestController
public class UsuarioController {

	@Autowired
	IUsuarioService service;

	@Autowired
	private BCryptPasswordEncoder passEncoder;

	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	@GetMapping("/listar")
	public ResponseWrapper listar() throws Exception {
		try {
			ResponseWrapper response = new ResponseWrapper();
			List lsuser = service.listar();
			if (lsuser != null) {
				response.setEstado(Constantes.valTransaccionOk);
				response.setMsg(Constantes.msgListarUsuariosOk);
				response.setAaData(lsuser);
			} else {
				response.setEstado(Constantes.valTransaccionOk);
				response.setMsg(Constantes.msgListarUsuariosOk);
			}
			return response;
		} catch (Exception e) {
			System.out.println(this.getClass().getSimpleName() + " listarUsuarios. ERROR : " + e.getMessage());
			throw new ExceptionResponse(new Date(), this.getClass().getSimpleName() + "/listar",
					e.getStackTrace()[0].getFileName() + " => " + e.getStackTrace()[0].getMethodName() + " => "
							+ e.getClass() + " => message: " + e.getMessage() + "=> linea nro: "
							+ e.getStackTrace()[0].getLineNumber(),
					null);
		}
	}
	
	@Transactional(propagation=Propagation.REQUIRED, rollbackFor=Exception.class)
	@PostMapping("/uploadImage")
	public ResponseEntity<?> subirImagen(@RequestParam("archivo") MultipartFile archivo, @RequestParam("id") Integer id)
			throws Exception {

		try {
			Map<String, Object> response = new HashMap<>();
			Usuario usuario = service.leer(id);
			if (!archivo.isEmpty()) {
				String nombreArchivo = UUID.randomUUID().toString()+"_"+ archivo.getOriginalFilename().replace(" ","");
				Path rutaArchivo = Paths.get("src/main/resources/Uploads").resolve(nombreArchivo).toAbsolutePath();
				Files.copy(archivo.getInputStream(), rutaArchivo);
				
				String nombreFotoAnterior = usuario.getFoto();
				if(nombreFotoAnterior!=null && nombreFotoAnterior.length()>0){
					Path rutaFotoAnterior = Paths.get("src/main/resources/Uploads").resolve(nombreFotoAnterior).toAbsolutePath();
					File archivoFotoAnterior = rutaFotoAnterior.toFile();
					if(archivoFotoAnterior.exists() && archivoFotoAnterior.canRead()){
						archivoFotoAnterior.delete();
					}
				}
				usuario.setFoto(nombreArchivo);
				Usuario resp = service.modificar(usuario);
				response.put("usuario",resp);
			}else {
				response.put("usuario",usuario);
			}
			response.put("estado", Constantes.valTransaccionOk);
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
		} catch (Exception e) {
			System.out.println(this.getClass().getSimpleName() + " listarUsuarios. ERROR : " + e.getMessage());
			throw new ExceptionResponse(new Date(), this.getClass().getSimpleName() + "/listar",
					e.getStackTrace()[0].getFileName() + " => " + e.getStackTrace()[0].getMethodName() + " => "
							+ e.getClass() + " => message: " + e.getMessage() + "=> linea nro: "
							+ e.getStackTrace()[0].getLineNumber(),
					null);
		}
	}

	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	@PostMapping("/registrar")
	public ResponseWrapper registrar(@Valid @RequestBody UsuarioDTO usuarioDTO, BindingResult result) throws Exception {

		if (result.hasErrors()) {
			List<String> errors = result.getFieldErrors().stream().map(err -> {
				return err.getDefaultMessage();
			}).collect(Collectors.toList());
			throw new ExceptionResponse(new Date(), this.getClass().getSimpleName() + "/registrar",
					"Error en la validacion: Lista de Errores:" + errors.toString(), usuarioDTO);
		}

		try {
			ResponseWrapper response = new ResponseWrapper();
			Usuario usuario = usuarioDTO.getUsuario();
			usuario.setPerfil(usuarioDTO.getPerfil());
			String encrip_pass = passEncoder.encode(usuario.getPassword());
			usuario.setPassword(encrip_pass);
			Usuario buscar_repetido = service.findbyUsername(usuario.getUsername());
			if (buscar_repetido != null) {
				response.setEstado(Constantes.valTransaccionError);
				response.setMsg(Constantes.msgRegistrarUsuarioRepetido);
			} else {
				Usuario resp_user = service.registrar(usuario);
				if (resp_user != null) {
					response.setEstado(Constantes.valTransaccionOk);
					response.setMsg(Constantes.msgRegistrarUsuarioOk);
					response.setDefaultObj(resp_user);
				} else {
					response.setEstado(Constantes.valTransaccionError);
					response.setMsg(Constantes.msgRegistrarUsuarioError);
				}
			}
			return response;
		} catch (Exception e) {
			System.out.println(this.getClass().getSimpleName() + " registrarUsuario. ERROR : " + e.getMessage());
			throw new ExceptionResponse(new Date(), this.getClass().getSimpleName() + "/registrar",
					e.getStackTrace()[0].getFileName() + " => " + e.getStackTrace()[0].getMethodName() + " => "
							+ e.getClass() + " => message: " + e.getMessage() + "=> linea nro: "
							+ e.getStackTrace()[0].getLineNumber(),
					usuarioDTO);
		}
	}

	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	@PutMapping("/modificar")
	public ResponseWrapper modificar(@Valid @RequestBody Usuario usuario, BindingResult result) throws Exception {

		if (result.hasErrors()) {
			List<String> errors = result.getFieldErrors().stream().map(err -> {
				return err.getDefaultMessage();
			}).collect(Collectors.toList());
			throw new ExceptionResponse(new Date(), this.getClass().getSimpleName() + "/registrar",
					"Error en la validacion: Lista de Errores:" + errors.toString(), usuario);
		}

		try {
			ResponseWrapper response = new ResponseWrapper();
			Usuario comparar_user = service.findbyUsername(usuario.getUsername());

			if (!usuario.getPassword().equals(comparar_user.getPassword())) {
				String encrip_pass = passEncoder.encode(usuario.getPassword());
				usuario.setPassword(encrip_pass);
			}

			Usuario resp_user = service.modificar(usuario);
			if (resp_user != null) {
				response.setEstado(Constantes.valTransaccionOk);
				response.setMsg(Constantes.msgActualizarUsuarioOk);
				response.setDefaultObj(resp_user);
			} else {
				response.setEstado(Constantes.valTransaccionError);
				response.setMsg(Constantes.msgActualizarUsuarioError);
			}
			return response;
		} catch (Exception e) {
			System.out.println(this.getClass().getSimpleName() + " modificarUsuario. ERROR : " + e.getMessage());
			throw new ExceptionResponse(new Date(), this.getClass().getSimpleName() + "/modificar",
					e.getStackTrace()[0].getFileName() + " => " + e.getStackTrace()[0].getMethodName() + " => "
							+ e.getClass() + " => message: " + e.getMessage() + "=> linea nro: "
							+ e.getStackTrace()[0].getLineNumber(),
					usuario);
		}
	}
	
	@GetMapping("/uploadImage/img/{nombreFoto:.+}")
	public ResponseEntity<Resource> verFoto(@PathVariable String nombreFoto) throws Exception{
		Path rutaArchivo = Paths.get("src/main/resources/Uploads").resolve(nombreFoto).toAbsolutePath();
		Resource recurso = null;
		try {
			recurso = new UrlResource(rutaArchivo.toUri());
			if(!recurso.exists() && !recurso.isReadable()){
				throw new RuntimeException("Error no se pudo cargar la imagen "+nombreFoto);
			}
			
			HttpHeaders cabecera = new HttpHeaders();
			cabecera.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\""+recurso.getFilename()+"\"");
			return new ResponseEntity<Resource>(recurso,cabecera,HttpStatus.OK);

		} catch (MalformedURLException e) {
			System.out.println(this.getClass().getSimpleName() + " mostrarFoto. ERROR : " + e.getMessage());
			throw new ExceptionResponse(new Date(), this.getClass().getSimpleName() + "/uploadImage/img/"+nombreFoto,
					e.getStackTrace()[0].getFileName() + " => " + e.getStackTrace()[0].getMethodName() + " => "
							+ e.getClass() + " => message: " + e.getMessage() + "=> linea nro: "
							+ e.getStackTrace()[0].getLineNumber(),
					nombreFoto);
		}
	}

}

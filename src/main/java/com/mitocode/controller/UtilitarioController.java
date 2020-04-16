package com.mitocode.controller;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mitocode.exception.ExceptionResponse;
import com.mitocode.model.Modulo;
import com.mitocode.model.Pagina;
import com.mitocode.model.Parametro;
import com.mitocode.model.Perfil;
import com.mitocode.model.Sctr;
import com.mitocode.model.Usuario;
import com.mitocode.service.UtilitarioService;

@RestController
@RequestMapping("/api/utilitario")
public class UtilitarioController {

	@Autowired
	private UtilitarioService service;

	Map<String, List<String>> resp_BD1 = new HashMap<>();

	Map<String, List<String>> resp_BD2 = new HashMap<>();

	@PostMapping("/llenarBD")
	public ResponseEntity<?> insertarDatos1() throws Exception {
		try {
			List<String> messages = new ArrayList<>();
			List<Modulo> tmp_modulo = new ArrayList<>();
			Modulo modTrabajador = this.CrearModulo("Trabajador", 1, "mdi mdi-worker", 2, "app.uitrab");
			Modulo modUsuario = this.CrearModulo("Administracion", 1, "mdi mdi-account", 1, "app.uiadm");
			Modulo modPlanillas = this.CrearModulo("Planillas", 1, "mdi mdi-clipboard-text", 3, "app.uiplan");
			Modulo modConfiguracion = this.CrearModulo("Configuracion", 1, "mdi mdi-settings", 4, "app.uiconf");
			tmp_modulo.add(modUsuario);
			tmp_modulo.add(modTrabajador);
			tmp_modulo.add(modPlanillas);
			tmp_modulo.add(modConfiguracion);
			messages.add(service.insertarDatosModulo(tmp_modulo));

			List<Pagina> tmp_pagina = new ArrayList<>();
			Pagina gu = this.CrearPagina("Gestion Usuarios", 1, "mdi mdi-shield", 0, "-", "/gestionusuarios",
					modUsuario);
			Pagina gh = this.CrearPagina("Horarios", 1, "mdi mdi-calendar-clock", 0, "-", "/horarios",
					modConfiguracion);
			Pagina gt = this.CrearPagina("Gestion Trabajador", 1, "mdi mdi-worker", 0, "-", "/gestiontrabajador",
					modTrabajador);
			Pagina dh = this.CrearPagina("Derecho Habientes", 1, "mdi mdi-heart-box", 0, "-", "/derechohabientes",
					modTrabajador);
			Pagina gp = this.CrearPagina("Generar Planillas", 1, "mdi mdi-newspaper", 0, "-", "/generarplanillas",
					modPlanillas);
			Pagina as = this.CrearPagina("Adelanto Sueldo", 1, "mdi mdi-cash-multiple", 0, "-", "/adelantosueldo",
					modPlanillas);
			Pagina p = this.CrearPagina("Parametros", 1, "mdi mdi-wrench", 0, "-", "/parametros", modConfiguracion);
			Pagina afp = this.CrearPagina("AFP", 1, "mdi mdi-hospital", 0, "-", "/afp", modConfiguracion);
			Pagina cat = this.CrearPagina("Categoria", 1, "mdi mdi-seal", 0, "-", "/categoria", modConfiguracion);
			Pagina car = this.CrearPagina("Cargo", 1, "mdi mdi-trophy-award", 0, "-", "/cargo", modConfiguracion);
			Pagina emp = this.CrearPagina("Empresa", 1, "mdi mdi-factory", 0, "-", "/empresa", modConfiguracion);
			Pagina aym = this.CrearPagina("Año y Mes", 1, "mdi mdi-calendar-text", 0, "-", "/anual", modConfiguracion);
			Pagina cc = this.CrearPagina("Centro Costo", 1, "mdi mdi-archive", 0, "-", "/centrocostos",
					modConfiguracion);
			Pagina sctr = this.CrearPagina("S.C.T.R.", 1, "mdi mdi-bell-plus", 0, "-", "/sctr", modConfiguracion);
			Pagina eps_pag = this.CrearPagina("E.P.S.", 1, "mdi mdi-hospital-building", 0, "-", "/eps",
					modConfiguracion);
			Pagina permi = this.CrearPagina("Permisos", 1, "mdi mdi-wheelchair-accessibility", 0, "-", "/permisos",
					modConfiguracion);
			Pagina remu = this.CrearPagina("Remuneraciones", 1, "mdi mdi-coin", 0, "-", "/remuneraciones",
					modConfiguracion);
			Pagina dsct = this.CrearPagina("Descuentos", 1, "mdi mdi-square-inc-cash", 0, "-", "/descuentos",
					modConfiguracion);
			Pagina tipplan = this.CrearPagina("Tipo Planilla", 1, "mdi mdi-clipboard-alert", 0, "-", "/tipoplanilla",
					modConfiguracion);
			Pagina asist = this.CrearPagina("Control Asistencia", 1, "mdi mdi-clock-fast", 0, "-", "/controlasistencia",
					modTrabajador);
			Pagina vacas = this.CrearPagina("Gestion Vacaciones", 1, "mdi mdi-airplane", 0, "-", "/vacaciones",
					modPlanillas);
			tmp_pagina.add(gu);
			tmp_pagina.add(gh);
			tmp_pagina.add(gt);
			tmp_pagina.add(dh);
			tmp_pagina.add(gp);
			tmp_pagina.add(as);
			tmp_pagina.add(p);
			tmp_pagina.add(afp);
			tmp_pagina.add(cat);
			tmp_pagina.add(car);
			tmp_pagina.add(emp);
			tmp_pagina.add(aym);
			tmp_pagina.add(cc);
			tmp_pagina.add(sctr);
			tmp_pagina.add(eps_pag);
			tmp_pagina.add(permi);
			tmp_pagina.add(remu);
			tmp_pagina.add(dsct);
			tmp_pagina.add(tipplan);
			tmp_pagina.add(asist);
			tmp_pagina.add(vacas);
			messages.add(service.insertarDatosPagina(tmp_pagina));

			List<Perfil> tmp_perfil = new ArrayList<>();
			Perfil admi = this.CrearPerfil(1, true, "ROLE_ADMIN");
			tmp_perfil.add(admi);
			messages.add(service.insertarDatosPerfil(tmp_perfil));

			List<Sctr> tmp_sctr = new ArrayList<>();
			Sctr nin = this.crearSctr("Ninguno", 0);
			Sctr ess = this.crearSctr("ESSALUD", 1);
			Sctr eps = this.crearSctr("EPS", 1);
			Sctr onp = this.crearSctr("ONP", 2);
			Sctr sp = this.crearSctr("Seguro Privado", 2);
			tmp_sctr.add(nin);
			tmp_sctr.add(ess);
			tmp_sctr.add(eps);
			tmp_sctr.add(onp);
			tmp_sctr.add(sp);
			messages.add(service.insertarDatosSctr(tmp_sctr));

			List<Parametro> tmp_param = new ArrayList<>();
			Parametro param1 = this.crearParametro("DIASCOMPTBASE", "Dias Computables Base", 1, "GLOBAL",
					"Dias Computables Base", "30");
			Parametro param2 = this.crearParametro("PERIODOGRATI1INI", "Primero de Enero", 1, "GLOBAL",
					"Primero de Enero", "01-01");
			Parametro param3 = this.crearParametro("PERIODOGRATI1FIN", "Treinta de  Junio", 1, "GLOBAL",
					"Treinta de  Junio", "06-30");
			Parametro param4 = this.crearParametro("PERIODOGRATI2INI", "Primero de Julio", 1, "GLOBAL",
					"Primero de Julio", "07-01");
			Parametro param5 = this.crearParametro("PERIODOGRATI2FIN", "Treinta y uno de Diciembre", 1, "GLOBAL",
					"Treinta y uno de Diciembre", "12-31");
			Parametro param6 = this.crearParametro("PERIODOCTS1INI", "Primero de Mayo", 1, "GLOBAL", "Primero de Mayo",
					"05-01");
			Parametro param7 = this.crearParametro("PERIODOCTS1FIN", "Treinta y uno de Octubre", 1, "GLOBAL",
					"Treinta y uno de Octubre", "10-31");
			Parametro param8 = this.crearParametro("PERIODOCTS2INI", "Primero de Noviembre", 1, "GLOBAL",
					"Primero de Noviembre", "11-01");
			Parametro param9 = this.crearParametro("PERIODOCTS2FIN", "Treinta de Abril", 1, "GLOBAL",
					"Treinta de Abril", "04-30");
			Parametro param10 = this.crearParametro("UIT", "Unidad Impositiva Tributaria", 1, "GLOBAL",
					"Unidad Impositiva Tributaria", "4200");
			Parametro param11 = this.crearParametro("CTSAGRARIO", "Valor del CTS para Regimen Agrario", 1, "GLOBAL",
					"Valor del CTS para Regimen Agrario", "36.69");
			Parametro param12 = this.crearParametro("CTSPESQUERO", "Valor del CTS para Regimen Pesquero", 1, "GLOBAL",
					"Valor del CTS para Regimen Pesquero", "0.0833");
			String ruta_app = System.getProperty("user.dir");
			String separador = System.getProperty("file.separator");
			Parametro param13 = this.crearParametro("RUTRZREPO", "Ruta Reportes", 0, "REPORTES", "Ruta Raiz",
					ruta_app + separador + "src" + separador + "main" + separador + "resources" + separador + "Reportes"
							+ separador);
			tmp_param.add(param1);
			tmp_param.add(param2);
			tmp_param.add(param3);
			tmp_param.add(param4);
			tmp_param.add(param5);
			tmp_param.add(param6);
			tmp_param.add(param7);
			tmp_param.add(param8);
			tmp_param.add(param9);
			tmp_param.add(param10);
			tmp_param.add(param11);
			tmp_param.add(param12);
			tmp_param.add(param13);
			messages.add(service.insertarDatosParametros(tmp_param));

			List<Usuario> tmp_usuarios = new ArrayList<>();
			Usuario user1 = this.crearUsuario("angel_96vir@hotmail.com", true,
					"$2a$10$5lQfLdWrdOiZudh3cCNmbOz2TcU3DtgfjqCeFHvGS1HDBHSvlNdu6", "junior", admi);
			tmp_usuarios.add(user1);
			messages.add(service.insertarDatosUsuarios(tmp_usuarios));

			messages.add(service.insertarDatosPerfilesPaginas());
			messages.add(service.insertarDatosEstadoCivil());
			messages.add(service.insertarDatosSituacion());
			messages.add(service.insertarDatosTipoDoc());
			messages.add(service.insertarDatosTipoZona());
			messages.add(service.insertarDatosTipoPago());
			messages.add(service.insertarDatosBanco());
			messages.add(service.insertarDatosDepartamento());
			messages.add(service.insertarDatosProvincia());
			messages.add(service.insertarDatosDistrito());
			messages.add(service.insertarDatosPais());
			messages.add(service.insertarDatosRegLaboral());
			messages.add(service.insertarDatosNivelEduca());
			messages.add(service.insertarDatosOcupacion1());
			messages.add(service.insertarDatosOcupacion2());
			messages.add(service.insertarDatosOcupacion3());
			messages.add(service.insertarDatosOcupacion4());
			messages.add(service.insertarDatosRegSalud());
			messages.add(service.insertarDatosTipoContrato());
			service.insertarDatosPdoMes();
			messages.add(service.insertarDatosPdoMesSinFeriado());
			messages.add(service.insertarTipoEmpresa());
			messages.add(service.insertarRegimenTributario());

			resp_BD1.put("mensaje", messages);
			crearFolders();

		} catch (Exception e) {

		}
		return new ResponseEntity<Map<String, List<String>>>(resp_BD1, HttpStatus.OK);

	}

	private Modulo CrearModulo(String des, int estado, String icono, int orden, String raiz) {
		Modulo modulo = new Modulo();
		modulo.setDescripcion(des);
		modulo.setEstado(estado);
		modulo.setIcono(icono);
		modulo.setOrden(orden);
		modulo.setRaiz(raiz);

		return modulo;
	}

	private Pagina CrearPagina(String desc, int estado, String icono, int orden, String param, String url,
			Modulo modulo) {
		Pagina pagina = new Pagina();
		pagina.setDescripcion(desc);
		pagina.setEstado(estado);
		pagina.setIcono(icono);
		pagina.setOrden(orden);
		pagina.setParametros(param);
		pagina.setUrl(url);
		pagina.setModulo(modulo);

		return pagina;
	}

	private Perfil CrearPerfil(int ambito, boolean estado, String nombres) {
		Perfil p = new Perfil();
		p.setAmbito(ambito);
		p.setEstado(estado);
		p.setNombres(nombres);
		return p;
	}

	private Sctr crearSctr(String descripcion, Integer tipo) {
		Sctr s = new Sctr();
		s.setDescripcion(descripcion);
		s.setTipo(tipo);

		return s;
	}

	private Parametro crearParametro(String codigo, String descripcion, int estado, String grupo, String nombre,
			String valor) {
		Parametro p = new Parametro();
		p.setDescripcion(descripcion);
		p.setCodigo(codigo);
		p.setEstado(estado);
		p.setGrupo(grupo);
		p.setNombre(nombre);
		p.setValor(valor);
		return p;
	}

	private Usuario crearUsuario(String email, Boolean estado, String pass, String username, Perfil perfil) {
		Usuario u = new Usuario();
		u.setEmail(email);
		u.setEstado(estado);
		u.setUsername(username);
		u.setPassword(pass);
		u.setPerfil(perfil);
		return u;
	}

	@PostMapping("/crearCarpetas")
	private void crearFolders() {
		File adelanto = new File("src/main/resources/Adelanto");
		if (!adelanto.exists()) {
			adelanto.mkdir();
		}

		File contrato = new File("src/main/resources/Contrato");
		File contratoActual = new File("src/main/resources/Contrato/ContratoActual");
		File contratoAntiguo = new File("src/main/resources/Contrato/ContratoAntiguo");
		File modelo = new File("src/main/resources/Contrato/Modelo");
		if (!contrato.exists()) {
			contrato.mkdir();
			contratoActual.mkdir();
			contratoAntiguo.mkdir();
			modelo.mkdir();
		} else {
			if (!contratoActual.exists()) {
				contratoActual.mkdir();
			}
			if (!contratoAntiguo.exists()) {
				contratoAntiguo.mkdir();
			}
			if (!modelo.exists()) {
				modelo.mkdir();
			}
		}

		File derechoHabiente = new File("src/main/resources/DerechoHabiente");
		File cy = new File("src/main/resources/DerechoHabiente/CY");
		File hic = new File("src/main/resources/DerechoHabiente/HIC");
		File mg = new File("src/main/resources/DerechoHabiente/MG");
		if (!derechoHabiente.exists()) {
			derechoHabiente.mkdir();
			cy.mkdir();
			hic.mkdir();
			mg.mkdir();
		} else {
			if (!cy.exists()) {
				cy.mkdir();
			}
			if (!hic.exists()) {
				hic.mkdir();
			}
			if (!mg.exists()) {
				mg.mkdir();
			}
		}

		File documentosRHE = new File("src/main/resources/DocumentosRHE");
		File rhe = new File("src/main/resources/DocumentosRHE/RHE");
		File suspenciones = new File("src/main/resources/DocumentosRHE/Suspenciones");
		if (!documentosRHE.exists()) {
			documentosRHE.mkdir();
			rhe.mkdir();
			suspenciones.mkdir();
		} else {
			if (!rhe.exists()) {
				rhe.mkdir();
			}
			if (!suspenciones.exists()) {
				suspenciones.mkdir();
			}
		}

		File txtGenerado = new File("src/main/resources/TxtGenerado");
		if (!txtGenerado.exists()) {
			txtGenerado.mkdir();
		}

		File Uploads = new File("src/main/resources/Uploads");
		if (!Uploads.exists()) {
			Uploads.mkdir();
		}
	}
}

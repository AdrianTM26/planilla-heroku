package com.mitocode.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mitocode.model.Modulo;
import com.mitocode.model.Pagina;
import com.mitocode.model.Parametro;
import com.mitocode.model.Perfil;
import com.mitocode.model.Sctr;
import com.mitocode.model.TipoPermiso;
import com.mitocode.model.Usuario;
import com.mitocode.repo.EstadoCivilRepo;
import com.mitocode.repo.ModuloRepo;
import com.mitocode.repo.PaginaRepo;
import com.mitocode.repo.ParametroRepo;
import com.mitocode.repo.PerfilRepo;
import com.mitocode.repo.SctrRepo;
import com.mitocode.repo.TipoEmpresaRepo;
import com.mitocode.repo.TipoPermisoRepo;
import com.mitocode.repo.UsuarioRepo;
import com.mitocode.repo.UtilitarioRepo;
import com.mitocode.service.UtilitarioService;

@Service
public class UtilitarioServiceImpl implements UtilitarioService {

	@Autowired
	TipoPermisoRepo repoTipoPermiso;

	@Autowired
	UtilitarioRepo repoUtilitario;

	@Autowired
	ModuloRepo repoModulo;

	@Autowired
	PaginaRepo repoPagina;

	@Autowired
	PerfilRepo repoPerfil;

	@Autowired
	SctrRepo repoSctr;

	@Autowired
	TipoEmpresaRepo repoTipoEmpresa;

	@Autowired
	ParametroRepo repoParametro;

	@Autowired
	UsuarioRepo repoUsuario;

	private static final Logger LOG = LoggerFactory.getLogger(Exception.class);

	public String insertarDatosModulo(List<Modulo> obj) {
		try {
			repoModulo.saveAll(obj);
			return "Se insertó correctamente los módulos";
		} catch (Exception e) {
			LOG.error(this.getClass().getSimpleName() + " insertarListaModulos. ERROR : " + e.getMessage());
			throw e;
		}
	}

	public String insertarDatosPagina(List<Pagina> obj) {
		try {
			repoPagina.saveAll(obj);
			return "Se insertó correctamente las Paginas";
		} catch (Exception e) {
			LOG.error(this.getClass().getSimpleName() + " insertarPaginas. ERROR : " + e.getMessage());
			throw e;
		}
	}

	public String insertarDatosPerfil(List<Perfil> obj) {
		try {
			repoPerfil.saveAll(obj);
			return "Se insertó correctamente los perfiles";
		} catch (Exception e) {
			LOG.error(this.getClass().getSimpleName() + " insertarPerfiles. ERROR : " + e.getMessage());
			throw e;
		}
	}

	public String insertarDatosSctr(List<Sctr> obj) {
		try {
			repoSctr.saveAll(obj);
			return "Se insertó correctamente los Sctr";
		} catch (Exception e) {
			LOG.error(this.getClass().getSimpleName() + " insertarSctr. ERROR : " + e.getMessage());
			throw e;
		}
	}

	public String insertarDatosParametros(List<Parametro> obj) {
		try {
			repoParametro.saveAll(obj);
			return "Se insertó correctamente los Parámetros";
		} catch (Exception e) {
			LOG.error(this.getClass().getSimpleName() + " insertarSctr. ERROR : " + e.getMessage());
			throw e;
		}
	}

	public String insertarDatosPerfilesPaginas() {

		try {
			repoUtilitario.insertarPerfilesPagina();
			return "Se insertó correctamente los Perfiles-Paginas";

		} catch (Exception e) {
			return "Se insertó correctamente los Perfiles-Paginas";
		}

	}

	public String insertarDatosEstadoCivil() {
		try {
			repoUtilitario.insertarEstadoCivil();
			return "Se insertó correctamente los Estados Civiles";
		} catch (Exception e) {
			return "Se insertó correctamente los Estados Civiles";
		}
	}

	public String insertarDatosSituacion() {
		try {
			repoUtilitario.insertarSituacion();
			return "Se insertó correctamente las Situaciones";
		} catch (Exception e) {
			return "Se insertó correctamente las Situaciones";
		}
	}

	public String insertarDatosTipoDoc() {
		try {
			repoUtilitario.insertarTipoDoc();
			return "Se insertó correctamente los Tipos de Documentos";
		} catch (Exception e) {
			return "Se insertó correctamente los Tipos de Documentos";
		}
	}

	public String insertarDatosTipoPago() {
		try {
			repoUtilitario.insertarTipoPago();
			return "Se insertó correctamente los Tipos de Pago";
		} catch (Exception e) {
			return "Se insertó correctamente los Tipos de Pago";
		}
	}

	public String insertarDatosTipoZona() {
		try {
			repoUtilitario.insertarTipoZona();
			return "Se insertó correctamente los Tipos de Zona";
		} catch (Exception e) {
			return "Se insertó correctamente los Tipos de Zona";

		}
	}

	public String insertarDatosBanco() {
		try {
			repoUtilitario.insertarBanco();
			return "Se insertó correctamente los Bancos";
		} catch (Exception e) {
			return "Se insertó correctamente los Bancos";

		}
	}

	public String insertarDatosDepartamento() {
		try {
			repoUtilitario.insertarDepartamento();
			return "Se insertó correctamente los Departamentos";
		} catch (Exception e) {
			return "Se insertó correctamente los Departamentos";

		}
	}

	public String insertarDatosProvincia() {
		try {
			repoUtilitario.insertarProvincia();
			return "Se insertó correctamente las Provincias";
		} catch (Exception e) {
			return "Se insertó correctamente las Provincias";

		}
	}

	public String insertarDatosDistrito() {
		try {
			repoUtilitario.insertarDistrito();
			return "Se insertó correctamente los Distritos";
		} catch (Exception e) {
			return "Se insertó correctamente los Distritos";
		}
	}

	public String insertarDatosPais() {
		try {
			repoUtilitario.insertarPais();
			return "Se insertó correctamente los Paises";
		} catch (Exception e) {
			return "Se insertó correctamente los Paises";

		}
	}

	public String insertarDatosRegLaboral() {
		try {
			repoUtilitario.insertarRegLaboral();
			return "Se insertó correctamente los Regimenes Laborales";
		} catch (Exception e) {
			return "Se insertó correctamente los Regimenes Laborales";

		}
	}

	public String insertarDatosRegSalud() {
		try {
			repoUtilitario.insertarRegSalud();
			return "Se insertó correctamente los Regimenes Salud";
		} catch (Exception e) {
			return "Se insertó correctamente los Regimenes Salud";

		}
	}

	public String insertarDatosNivelEduca() {
		try {
			repoUtilitario.insertarNivelEduca();
			return "Se insertó correctamente los Niveles Educacion";
		} catch (Exception e) {
			return "Se insertó correctamente los Niveles Educacion";
		}
	}

	public String insertarDatosOcupacion1() {
		try {
			repoUtilitario.insertarOcupacion1();
			return "Se insertó correctamente las Ocupaciones pt1";
		} catch (Exception e) {
			return "Se insertó correctamente las Ocupaciones pt1";

		}
	}

	public String insertarDatosOcupacion2() {
		try {
			repoUtilitario.insertarOcupacion2();
			return "Se insertó correctamente las Ocupaciones pt2";
		} catch (Exception e) {
			return "Se insertó correctamente las Ocupaciones pt2";

		}
	}

	public String insertarDatosOcupacion3() {
		try {
			repoUtilitario.insertarOcupacion3();
			return "Se insertó correctamente las Ocupaciones pt3";
		} catch (Exception e) {
			return "Se insertó correctamente las Ocupaciones pt3";

		}
	}

	public String insertarDatosOcupacion4() {
		try {
			repoUtilitario.insertarOcupacion4();
			return "Se insertó correctamente las Ocupaciones pt4";
		} catch (Exception e) {
			return "Se insertó correctamente las Ocupaciones pt4";

		}
	}

	public String insertarDatosTipoContrato() {
		try {
			repoUtilitario.insertarTipoContrato();
			return "Se insertó correctamente los Tipos de Contrato";
		} catch (Exception e) {
			return "Se insertó correctamente los Tipos de Contrato";
		}
	}

	public void insertarDatosPdoMes() {
		try {
			repoUtilitario.insertarPdoMes();
		} catch (Exception e) {
		}
	}
	
	public String insertarDatosPdoMesSinFeriado() {
		try {
			repoUtilitario.insertarPdoMesSinFeriado();
			return "Se insertó correctamente los periodos Meses";
		} catch (Exception e) {
			return "Se insertó correctamente los periodos Meses";
		}
	}

	public String insertarTipoEmpresa() {
		try {
			repoUtilitario.insertarTipoEmpresa();
			return "Se insertó correctamente los Tipos de Empresas";
		} catch (Exception e) {
			return "Se insertó correctamente los Tipos de Empresas";
		}
	}

	public String insertarRegimenTributario() {
		try {
			repoUtilitario.insertarRegimenTributario();
			return "Se insertó correctamente los Regimenes Tributarios";
		} catch (Exception e) {
			return "Se insertó correctamente los Regimenes Tributarios";
		}
	}

	@Override
	public String insertarDatosUsuarios(List<Usuario> usuarios) {
		try {
			repoUsuario.saveAll(usuarios);
			return "Se insertó correctamente los usuarios";
		} catch (Exception e) {
			LOG.error(this.getClass().getSimpleName() + " insertarDatosUsuarios. ERROR : " + e.getMessage());
			throw e;
		}

	}

	@Override
	public String insertarDatosTipoPermisos(List<TipoPermiso> permisos) {
		try {
			repoTipoPermiso.saveAll(permisos);
			return "Se insertó correctamente los Tipos de permisos";
		} catch (Exception e) {
			LOG.error(this.getClass().getSimpleName() + " insertarDatosTipoPermiso. ERROR : " + e.getMessage());
			throw e;
		}

	}

}

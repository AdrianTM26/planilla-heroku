package com.mitocode.service;

import java.util.List;

import com.mitocode.model.Modulo;
import com.mitocode.model.Pagina;
import com.mitocode.model.Parametro;
import com.mitocode.model.Perfil;
import com.mitocode.model.Sctr;
import com.mitocode.model.TipoPermiso;
import com.mitocode.model.Usuario;

public interface UtilitarioService {
	
	public String insertarDatosPerfilesPaginas();
	public String insertarDatosEstadoCivil();
	public String insertarDatosSituacion();
	public String insertarDatosTipoDoc();
	public String insertarDatosTipoPago();
	public String insertarDatosTipoZona();
	public String insertarDatosBanco();
	public String insertarDatosDepartamento();
	public String insertarDatosProvincia();
	public String insertarDatosDistrito();
	public String insertarDatosPais();
	public String insertarDatosRegLaboral();
	public String insertarDatosRegSalud();
	public String insertarDatosNivelEduca();
	public String insertarDatosOcupacion1();
	public String insertarDatosOcupacion2();
	public String insertarDatosOcupacion3();
	public String insertarDatosOcupacion4();
	public String insertarDatosTipoContrato();
	public void insertarDatosPdoMes();
	public String insertarDatosPdoMesSinFeriado();
	public String insertarTipoEmpresa();
	public String insertarRegimenTributario();
	
	public String insertarDatosModulo(List<Modulo> modulos);
	public String insertarDatosPagina(List<Pagina> paginas);
	public String insertarDatosPerfil(List<Perfil> perfiles);
	public String insertarDatosSctr(List <Sctr> sctr);
	public String insertarDatosParametros(List <Parametro> parametros);
	public String insertarDatosUsuarios(List<Usuario> usuarios);
	public String insertarDatosTipoPermisos(List<TipoPermiso> permisos);
	
}

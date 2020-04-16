package com.mitocode.service;

import java.util.Date;
import java.util.List;

import com.mitocode.model.Permiso;
import com.mitocode.model.Trabajador;

public interface PermisoService extends ICRUD<Permiso>{
	
	List<Permiso> listarPorTrabajadoryPeriodo(Permiso permiso);
	Boolean buscarPorFechaYTrabajador(Date fecha, Trabajador trabajador);
}

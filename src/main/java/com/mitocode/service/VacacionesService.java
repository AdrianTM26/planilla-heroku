package com.mitocode.service;

import java.util.List;

import com.mitocode.model.Trabajador;
import com.mitocode.model.Vacaciones;

public interface VacacionesService extends ICRUD<Vacaciones>{
	
	List<Vacaciones> buscarPorTrabajador(Trabajador trabajador);
	
	Vacaciones buscarUltimoPeriodoPorTrabajador(Trabajador trabajador);
	
}	

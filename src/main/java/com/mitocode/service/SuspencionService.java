package com.mitocode.service;

import com.mitocode.model.Suspencion;
import com.mitocode.model.Trabajador;

public interface SuspencionService extends ICRUD<Suspencion> {
	
	public Suspencion encontrarSusp(Trabajador trab);

}

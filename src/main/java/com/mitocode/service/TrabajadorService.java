package com.mitocode.service;

import com.mitocode.model.Trabajador;

public interface TrabajadorService extends ICRUD<Trabajador>{
	
	public Trabajador encontrarTrab(Integer id);

}

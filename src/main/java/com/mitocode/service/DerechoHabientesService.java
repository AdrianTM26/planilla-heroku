package com.mitocode.service;

import java.util.List;

import com.mitocode.model.DerechoHabientes;
import com.mitocode.model.Trabajador;

public interface DerechoHabientesService extends ICRUD<DerechoHabientes>{
	
	public List<DerechoHabientes> listarXTrab(Trabajador trab);
	public DerechoHabientes encontrarDH(Integer id);

}

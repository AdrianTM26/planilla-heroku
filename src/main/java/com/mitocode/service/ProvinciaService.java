package com.mitocode.service;

import java.util.List;

import com.mitocode.model.Departamento;
import com.mitocode.model.Provincia;

public interface ProvinciaService extends ICRUD<Provincia>{
	
	public List<Provincia> listarPorDepartamento(Departamento depa);

}

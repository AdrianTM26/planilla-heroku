package com.mitocode.service;

import java.util.List;

import com.mitocode.model.Distrito;
import com.mitocode.model.Provincia;

public interface DistritoService extends ICRUD<Distrito>{
	
	public List<Distrito> listarPorProvincia(Provincia prov); 

}

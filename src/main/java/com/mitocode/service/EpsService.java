package com.mitocode.service;

import java.util.List;

import com.mitocode.model.Empresa;
import com.mitocode.model.Eps;

public interface EpsService extends ICRUD<Eps>{
	
	List<Eps> buscarXEmpresa(Empresa empresa);
}

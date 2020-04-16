package com.mitocode.service;

import java.util.List;

import com.mitocode.model.Afp;
import com.mitocode.model.Empresa;




public interface AfpService extends ICRUD<Afp>{
	
	List<Afp> listarXEmpresa(Empresa empresa);
	public List<Afp> listarPorDescripcion(Afp afp);
}

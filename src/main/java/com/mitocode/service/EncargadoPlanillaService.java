package com.mitocode.service;

import java.util.List;

import com.mitocode.model.Empresa;
import com.mitocode.model.EncargadoPlanilla;

public interface EncargadoPlanillaService extends ICRUD<EncargadoPlanilla> {

	List<EncargadoPlanilla> listarXEmpresa(Empresa emp);

	EncargadoPlanilla darBaja(EncargadoPlanilla obj);

	List<EncargadoPlanilla> listarXEmpresaInac(Empresa emp);

	EncargadoPlanilla activar(EncargadoPlanilla obj);
	
	EncargadoPlanilla encontrar(Integer id);
}

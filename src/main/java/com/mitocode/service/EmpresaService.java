package com.mitocode.service;

import com.mitocode.model.Empresa;

public interface EmpresaService extends ICRUD<Empresa>{
	
	public Empresa buscarXRuc (String ruc);
	public Empresa buscarXRazonSocial (String razon_social);

 
}

package com.mitocode.service;

import java.util.List;

import com.mitocode.model.Empresa;
import com.mitocode.model.TipoPermiso;

public interface TipoPermisoService extends ICRUD<TipoPermiso>{
	
	public List<TipoPermiso> listarPorEmpresa(Empresa empresa);
}

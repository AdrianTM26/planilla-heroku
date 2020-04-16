package com.mitocode.service;

import java.util.List;

import com.mitocode.model.CentroCosto;
import com.mitocode.model.Empresa;

public interface CentroCostoService extends ICRUD<CentroCosto>{

	public List<CentroCosto> listarPorEmpresa(Empresa empresa);	
}

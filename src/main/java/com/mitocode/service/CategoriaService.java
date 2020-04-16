package com.mitocode.service;

import java.util.List;

import com.mitocode.model.Categoria;
import com.mitocode.model.Empresa;

public interface CategoriaService extends ICRUD<Categoria> {

	public List<Categoria> listarXEmpresa(Empresa empresa);
	public Categoria buscarCatXDes(String categoria);
}

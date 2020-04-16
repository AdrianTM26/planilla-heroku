package com.mitocode.service;

import java.util.List;

import com.mitocode.model.Cargo;
import com.mitocode.model.Categoria;
import com.mitocode.model.Empresa;


public interface CargoService extends ICRUD<Cargo> {

	List listarPorCategoria(Categoria categoria);
	Cargo listarPorDescripcion(Cargo cargo);
	List<Cargo> listarCargoXEmpresa(Empresa empresa);

}

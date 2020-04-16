package com.mitocode.service;

import java.util.List;

import com.mitocode.model.Descuentos;
import com.mitocode.model.Empresa;

public interface DescuentosService extends ICRUD<Descuentos> {

	List<Descuentos> listarXEmpresa(Empresa emp);

	Descuentos darBaja(Descuentos obj);

	List<Descuentos> listarXEmpresaInac(Empresa emp);

	Descuentos activar(Descuentos obj);

}

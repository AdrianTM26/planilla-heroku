package com.mitocode.service;

import java.util.List;

import com.mitocode.model.Empresa;
import com.mitocode.model.Remuneraciones;

public interface RemuneracionesService extends ICRUD<Remuneraciones> {

	List<Remuneraciones> listarXEmpresa(Empresa emp);

	Remuneraciones darBaja(Remuneraciones rem);

	List<Remuneraciones> listarXEmpresaInac(Empresa emp);

	Remuneraciones activar(Remuneraciones rem);

}

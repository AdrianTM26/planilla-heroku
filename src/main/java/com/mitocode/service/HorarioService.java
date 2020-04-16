package com.mitocode.service;

import java.util.List;

import com.mitocode.model.Empresa;
import com.mitocode.model.Horario;

public interface HorarioService extends ICRUD<Horario> {
	
	List<Horario> listarPorEmpresa(Empresa empresa);
	
}

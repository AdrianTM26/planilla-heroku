package com.mitocode.service;

import java.util.List;

import com.mitocode.model.Empresa;
import com.mitocode.model.PdoAno;
import com.mitocode.model.PdoMes;

public interface AnoMesService extends ICRUD<PdoAno>{
	
	List<PdoAno> listarPorEmpresa(Empresa empresa);

	Boolean registrarAnoDefecto(Empresa emp);
	
	PdoAno buscarSiExistePorDesc(Empresa emp, PdoAno ano);
	
	List<PdoMes> listarMeses();
	
	PdoMes ModificarMes(PdoMes pdomes);

	PdoMes encontrarMes(Integer id);

	PdoAno encontrarAno(Integer id);

}

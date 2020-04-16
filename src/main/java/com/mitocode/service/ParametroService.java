package com.mitocode.service;

import java.util.List;

import com.mitocode.dto.EmpresaDTO;
import com.mitocode.model.Empresa;
import com.mitocode.model.Parametro;


public interface ParametroService extends ICRUD<Parametro>{
	
	public List<Parametro> listarPorEmpresaActivo(Empresa empresa);
	
	public Parametro listarPorNombre(Parametro parametro);
	
	public Parametro buscarPorCodigoAndEmpresa(EmpresaDTO empresadto);
	
	public Parametro buscarTardanzaPorEmpresa(Empresa empresa);
	
	public Parametro buscarRangoPorEmpresa(Empresa empresa);

}

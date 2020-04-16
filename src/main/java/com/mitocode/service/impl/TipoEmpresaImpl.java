package com.mitocode.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mitocode.model.TipoEmpresa;
import com.mitocode.repo.TipoEmpresaRepo;
import com.mitocode.service.TipoEmpresaService;

@Service
public class TipoEmpresaImpl implements TipoEmpresaService{
	
	@Autowired
	TipoEmpresaRepo repo;
	
	private static final Logger LOG = LoggerFactory.getLogger(Exception.class);
	
	@Override
	public TipoEmpresa registrar(TipoEmpresa obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public TipoEmpresa modificar(TipoEmpresa obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public TipoEmpresa leer(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<TipoEmpresa> listar() {
		try {
			List<TipoEmpresa> list = repo.findAll();
			return list;
		}catch(Exception e) {
			LOG.error(this.getClass().getSimpleName()+" listarEmpresa. ERROR : "+e.getMessage());
			throw e;
		}
	}

	@Override
	public Boolean eliminar(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}


	
}

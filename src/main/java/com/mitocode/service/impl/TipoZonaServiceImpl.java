package com.mitocode.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mitocode.model.TipoZona;
import com.mitocode.repo.TipoZonaRepo;
import com.mitocode.service.TipoZonaService;

@Service
public class TipoZonaServiceImpl implements TipoZonaService{

	@Autowired
	TipoZonaRepo repo;
	
	private static final Logger LOG = LoggerFactory.getLogger(Exception.class);
	
	@Override
	public TipoZona registrar(TipoZona obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public TipoZona modificar(TipoZona obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public TipoZona leer(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<TipoZona> listar() {
		try {
			return repo.findAll();
		}catch(Exception e) {
			LOG.error(this.getClass().getSimpleName()+" listarTipoZona. ERROR : "+e.getMessage());
			throw e;
		}
	}

	@Override
	public Boolean eliminar(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

}

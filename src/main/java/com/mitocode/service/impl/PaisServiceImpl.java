package com.mitocode.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mitocode.model.Pais;
import com.mitocode.repo.PaisRepo;
import com.mitocode.service.PaisService;

@Service
public class PaisServiceImpl implements PaisService{

	@Autowired
	PaisRepo repo;
	
	private static final Logger LOG = LoggerFactory.getLogger(Exception.class);
	
	@Override
	public Pais registrar(Pais obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Pais modificar(Pais obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Pais leer(Integer id) {
		return null;
	}

	@Override
	public List<Pais> listar() {
		try {
			return repo.findAll();
		}catch(Exception e) {
			LOG.error(this.getClass().getSimpleName()+" listarPais. ERROR : "+e.getMessage());
			throw e;
		}
	}

	@Override
	public Boolean eliminar(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

}

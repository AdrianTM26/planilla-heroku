package com.mitocode.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mitocode.model.Situacion;
import com.mitocode.repo.SituacionRepo;
import com.mitocode.service.SituacionService;

@Service
public class SituacionServiceImpl implements SituacionService{

	@Autowired
	SituacionRepo repo;
	
	private static final Logger LOG = LoggerFactory.getLogger(Exception.class);
	
	@Override
	public Situacion registrar(Situacion obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Situacion modificar(Situacion obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Situacion leer(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Situacion> listar() {
		try {
			return repo.findAll();
		}catch(Exception e) {
			LOG.error(this.getClass().getSimpleName()+" listarSituacion. ERROR : "+e.getMessage());
			throw e;
		}
	}

	@Override
	public Boolean eliminar(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

}

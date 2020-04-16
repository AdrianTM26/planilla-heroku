package com.mitocode.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mitocode.model.EstadoCivil;
import com.mitocode.repo.EstadoCivilRepo;
import com.mitocode.service.EstadoCivilService;

@Service
public class EstadoCivilServiceImpl implements EstadoCivilService {

	@Autowired
	EstadoCivilRepo repo;
	
	private static final Logger LOG = LoggerFactory.getLogger(Exception.class);
	
	@Override
	public EstadoCivil registrar(EstadoCivil obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public EstadoCivil modificar(EstadoCivil obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public EstadoCivil leer(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<EstadoCivil> listar() {
		try {
			return repo.findAll();
		}catch(Exception e) {
			LOG.error(this.getClass().getSimpleName()+"listar estado civil. ERROR :" +e.getMessage());
			throw e;
		}
	}

	@Override
	public Boolean eliminar(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

}

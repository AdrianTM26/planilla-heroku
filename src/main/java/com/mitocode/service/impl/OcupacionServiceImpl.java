package com.mitocode.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mitocode.model.Ocupacion;
import com.mitocode.repo.OcupacionRepo;
import com.mitocode.service.OcupacionService;

@Service
public class OcupacionServiceImpl implements OcupacionService{

	@Autowired
	OcupacionRepo repo;
	
	private static final Logger LOG = LoggerFactory.getLogger(Exception.class);
	
	
	@Override
	public Ocupacion registrar(Ocupacion obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Ocupacion modificar(Ocupacion obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Ocupacion leer(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Ocupacion> listar() {
		try {
			return repo.findAll();
		}catch(Exception e) {
			LOG.error(this.getClass().getSimpleName()+" listarOcupacion. ERROR : "+e.getMessage());
			throw e;
		}
	}

	@Override
	public Boolean eliminar(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

}

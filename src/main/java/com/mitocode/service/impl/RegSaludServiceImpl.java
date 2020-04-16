package com.mitocode.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mitocode.model.RegSalud;
import com.mitocode.repo.RegSaludRepo;
import com.mitocode.service.RegSaludService;

@Service
public class RegSaludServiceImpl implements RegSaludService{

	@Autowired
	RegSaludRepo repo;
	
	private static final Logger LOG = LoggerFactory.getLogger(Exception.class);
	
	@Override
	public RegSalud registrar(RegSalud obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public RegSalud modificar(RegSalud obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public RegSalud leer(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<RegSalud> listar() {
		try {
			return repo.findAll();
		}catch(Exception e) {
			LOG.error(this.getClass().getSimpleName()+" listarRegSalud. ERROR : "+e.getMessage());
			throw e;
		}
	}

	@Override
	public Boolean eliminar(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

}

package com.mitocode.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mitocode.model.RegimenTributario;
import com.mitocode.repo.RegimenTributarioRepo;
import com.mitocode.service.RegimenTributarioService;

@Service
public class RegimenTributarioServiceImpl implements RegimenTributarioService {
	
	@Autowired
	RegimenTributarioRepo repo;
	
	private static final Logger LOG = LoggerFactory.getLogger(Exception.class);
	
	@Override
	public RegimenTributario registrar(RegimenTributario obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public RegimenTributario modificar(RegimenTributario obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public RegimenTributario leer(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<RegimenTributario> listar() {
		try {
			List<RegimenTributario> list = repo.findAll();
			return list;
		}catch(Exception e) {
			LOG.error(this.getClass().getSimpleName()+" listarRegimenTributario. ERROR : "+e.getMessage());
			throw e;
		}
	
	}

	@Override
	public Boolean eliminar(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}

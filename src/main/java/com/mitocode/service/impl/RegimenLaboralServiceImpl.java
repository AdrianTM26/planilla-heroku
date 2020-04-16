package com.mitocode.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mitocode.model.RegimenLaboral;
import com.mitocode.repo.RegimenLaboralRepo;
import com.mitocode.service.RegimenLaboralService;

@Service
public class RegimenLaboralServiceImpl implements RegimenLaboralService{

	@Autowired
	RegimenLaboralRepo repo;
	
	private static final Logger LOG = LoggerFactory.getLogger(Exception.class);
	
	@Override
	public RegimenLaboral registrar(RegimenLaboral obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public RegimenLaboral modificar(RegimenLaboral obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public RegimenLaboral leer(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<RegimenLaboral> listar() {
		try {
			return repo.findAll();
		}catch(Exception e) {
			LOG.error(this.getClass().getSimpleName()+" lsitarRegimenLaboral. ERROR : "+e.getMessage());
			throw e;
		}
	}

	@Override
	public Boolean eliminar(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

}

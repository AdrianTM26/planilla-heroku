package com.mitocode.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mitocode.model.Sctr;
import com.mitocode.repo.SctrRepo;
import com.mitocode.service.SctrService;

@Service
public class SctrServiceImpl implements SctrService{

	@Autowired
	SctrRepo repo;
	
	private static final Logger LOG = LoggerFactory.getLogger(Exception.class);
	
	@Override
	public Sctr registrar(Sctr obj) {
		try {
			return repo.save(obj);
		} catch (Exception e) {
			LOG.error(this.getClass().getSimpleName() + " registrarSctr. ERROR : " + e.getMessage());
			throw e;
		}
	}

	@Override
	public Sctr modificar(Sctr obj) {
		try {
			return repo.save(obj);
		} catch (Exception e) {
			LOG.error(this.getClass().getSimpleName() + " modificarSctr. ERROR : " + e.getMessage());
			throw e;
		}
	}

	@Override
	public Sctr leer(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Sctr> listar() {
		try {
			return repo.findAll();
		}catch(Exception e) {
			LOG.error(this.getClass().getSimpleName()+" listarSctr. ERROR : "+e.getMessage());
			throw e;
		}
	}

	@Override
	public Boolean eliminar(Integer id) {
		try {
			repo.deleteById(id);
			Boolean resp = repo.existsById(id);
			return resp;
		} catch (Exception e) {
			LOG.error(this.getClass().getSimpleName() + " eliminarSctr. ERROR : " + e.getMessage());
			throw e;
		}
	}

}

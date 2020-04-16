package com.mitocode.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mitocode.model.Empresa;
import com.mitocode.model.Eps;
import com.mitocode.repo.EpsRepo;
import com.mitocode.service.EpsService;

@Service
public class EpsServiceImpl implements EpsService{

	@Autowired
	EpsRepo repo;
	
	private static final Logger LOG = LoggerFactory.getLogger(Exception.class);
	
	@Override
	public Eps registrar(Eps obj) {
		try {
			return repo.save(obj);
		} catch (Exception e) {
			LOG.error(this.getClass().getSimpleName() + " registrarEps. ERROR : " + e.getMessage());
			throw e;
		}
	}

	@Override
	public Eps modificar(Eps obj) {
		try {
			return repo.save(obj);
		} catch (Exception e) {
			LOG.error(this.getClass().getSimpleName() + " modificarEps. ERROR : " + e.getMessage());
			throw e;
		}
	}

	@Override
	public Eps leer(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Eps> listar() {
		try {
			return repo.findAll();
		}catch(Exception e) {
			LOG.error(this.getClass().getSimpleName()+" listarEps. ERROR : "+e.getMessage());
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
			LOG.error(this.getClass().getSimpleName() + " eliminarEps. ERROR : " + e.getMessage());
			throw e;
		}
	}

	@Override
	public List<Eps> buscarXEmpresa(Empresa empresa) {
		try {
			
			return repo.findByEmpresa(empresa);
			
		}catch(Exception e) {
			LOG.error(this.getClass().getSimpleName() + " listarEps. ERROR : " + e.getMessage());
			throw e;
		}
	}

}

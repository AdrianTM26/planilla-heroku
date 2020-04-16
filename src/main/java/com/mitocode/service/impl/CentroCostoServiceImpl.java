package com.mitocode.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mitocode.model.CentroCosto;
import com.mitocode.model.Empresa;
import com.mitocode.repo.CentroCostoRepo;
import com.mitocode.service.CentroCostoService;

@Service
public class CentroCostoServiceImpl implements CentroCostoService{

	@Autowired
	CentroCostoRepo repo;
	
	private static final Logger LOG = LoggerFactory.getLogger(Exception.class);
	
	@Override
	public CentroCosto registrar(CentroCosto obj) {
		try {		
			return repo.save(obj);
		}catch(Exception e){
			LOG.error(this.getClass().getSimpleName()+" registrarCentroCosto. ERROR : "+e.getMessage());
			throw e;
		}
	}
	
	@Override
	public CentroCosto modificar(CentroCosto obj) {
		try {		
			return repo.save(obj);
		}catch(Exception e){
			LOG.error(this.getClass().getSimpleName()+" actualizarCentroCosto. ERROR : "+e.getMessage());
			throw e;
		}
	}


	@Override
	public CentroCosto leer(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CentroCosto> listar() {
		try {
			return repo.findAll();
		}catch(Exception e) {
			LOG.error(this.getClass().getSimpleName()+" listarCentroCosto. ERROR : "+e.getMessage());
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
			LOG.error(this.getClass().getSimpleName() + " eliminarCentroCostos. ERROR : " + e.getMessage());
			throw e;
		}
	}

	@Override
	public List<CentroCosto> listarPorEmpresa(Empresa empresa) {
		try {
			return repo.findByEmpresa(empresa);
		}catch(Exception e) {
			LOG.error(this.getClass().getSimpleName()+" listarPorEmpresa. ERROR : "+e.getMessage());
			throw e;
		}
	}

}

package com.mitocode.service.impl;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mitocode.model.Afp;
import com.mitocode.model.Empresa;
import com.mitocode.repo.AfpRepo;
import com.mitocode.service.AfpService;


@Service
public class AfpServiceImpl implements AfpService{
	
	@Autowired
	private AfpRepo repo;
	
	private static final Logger LOG = LoggerFactory.getLogger(Exception.class);
	
	@Override
	public Afp modificar(Afp obj) {
		try {
			return repo.save(obj);
		}catch(Exception e){
			LOG.error(this.getClass().getSimpleName()+" actualizarAFP. ERROR : "+e.getMessage());
			throw e;
		}
	}

	@Override
	public Afp registrar(Afp obj) {
		try {		
			return repo.save(obj);
		}
		catch(Exception e){
			LOG.error(this.getClass().getSimpleName()+" registrarAFP. ERROR : "+e.getMessage());
			throw e;
		}
	}

	@Override
	public Afp leer(Integer id) {
	
		Optional<Afp> op = repo.findById(id);
		return op.isPresent() ? op.get() : new Afp();
		
	}

	@Override
	public List<Afp> listar() {
		try {		
			return repo.findAll();
		}catch(Exception e){
			LOG.error(this.getClass().getSimpleName()+" listarAFP. ERROR : "+e.getMessage());
			throw e;
		}
	}
	
	@Override
	public List<Afp> listarXEmpresa(Empresa empresa) {
		try {		
			return repo.findByEmpresa(empresa);
		}catch(Exception e){
			LOG.error(this.getClass().getSimpleName()+" listarAFPXEmpresa. ERROR : "+e.getMessage());
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
			LOG.error(this.getClass().getSimpleName() + " eliminarAFP. ERROR : " + e.getMessage());
			throw e;
		}
	}

	@Override
	public List<Afp> listarPorDescripcion(Afp afp) {
		try {
			
		return repo.findByDescripcion(afp.getDescripcion());
		
		}catch(Exception e) {
			LOG.error(this.getClass().getSimpleName() + " listarAfpPorDescripcion. ERROR : " + e.getMessage());
			throw e;
		}
	}

}

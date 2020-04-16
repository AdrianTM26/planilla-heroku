package com.mitocode.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mitocode.model.DerechoHabientes;
import com.mitocode.model.Trabajador;
import com.mitocode.repo.DerechoHabientesRepo;
import com.mitocode.service.DerechoHabientesService;
import com.mitocode.util.Constantes;

@Service
public class DerechoHabientesServiceImpl implements DerechoHabientesService{
	
	@Autowired
	DerechoHabientesRepo repo;
	
	private static final Logger LOG = LoggerFactory.getLogger(Exception.class);

	@Override
	public DerechoHabientes registrar(DerechoHabientes obj) {
		try {
		return repo.save(obj);
		}catch(Exception e) {
			LOG.error(this.getClass().getSimpleName()+" registrarDerechoHabiente. ERROR : "+e.getMessage());
			throw e;
		}
	}

	@Override
	public DerechoHabientes modificar(DerechoHabientes obj) {
		try {
		return repo.save(obj);
		}catch(Exception e) {
			LOG.error(this.getClass().getSimpleName()+" modificarDerechoHabiente. ERROR : "+e.getMessage());
			throw e;
		}
	}

	@Override
	public DerechoHabientes leer(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<DerechoHabientes> listar() {
		try {
		return repo.findAll();
		}catch(Exception e) {
			LOG.error(this.getClass().getSimpleName()+" listarDerechosHabientes. ERROR : "+e.getMessage());
			throw e;
		}
	}

	@Override
	public Boolean eliminar(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<DerechoHabientes> listarXTrab(Trabajador trab) {
		try {
		return repo.findByEstadoAndTrabajador(Constantes.ConsActivo, trab);
		}catch(Exception e) {
			LOG.error(this.getClass().getSimpleName()+" listsarDerechoHabientePorTrabajador. ERROR : "+e.getMessage());
			throw e;
		}
	}

	@Override
	public DerechoHabientes encontrarDH(Integer id) {
		try {
		return repo.findByIdDerechoHabiente(id);
		}catch(Exception e) {
			LOG.error(this.getClass().getSimpleName()+" encontrarrDerechoHabiente. ERROR : "+e.getMessage());
			throw e;
		}
	}

}

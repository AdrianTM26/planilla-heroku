package com.mitocode.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mitocode.model.Trabajador;
import com.mitocode.repo.TrabajadorRepo;
import com.mitocode.service.TrabajadorService;

@Service
public class TrabajadorServiceImpl implements TrabajadorService {

	@Autowired
	TrabajadorRepo repo;

	private static final Logger LOG = LoggerFactory.getLogger(Exception.class);

	@Override
	public Trabajador registrar(Trabajador obj) {
		try {
			return repo.save(obj);
		} catch (Exception e) {
			LOG.error(this.getClass().getSimpleName() + " registrarTrabajador. ERROR : " + e.getMessage());
			throw e;
		}
	}

	@Override
	public Trabajador modificar(Trabajador obj) {
		try {
			return repo.save(obj);
		} catch (Exception e) {
			LOG.error(this.getClass().getSimpleName() + " modificarTrabajador. ERROR : " + e.getMessage());
			throw e;
		}
	}

	@Override
	public Trabajador leer(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Trabajador> listar() {
		try {
			return repo.findAll();
		} catch (Exception e) {
			LOG.error(this.getClass().getSimpleName() + " listarTrabajadores. ERROR : " + e.getMessage());
			throw e;
		}
	}

	@Override
	public Boolean eliminar(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Trabajador encontrarTrab(Integer id) {
		try {
			return repo.findByIdTrabajador(id);
		} catch (Exception e) {
			LOG.error(this.getClass().getSimpleName() + " encontrarTrabajador. ERROR : " + e.getMessage());
			throw e;
		}
	}
}

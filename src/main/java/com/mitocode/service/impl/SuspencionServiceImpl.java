package com.mitocode.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mitocode.model.Suspencion;
import com.mitocode.model.Trabajador;
import com.mitocode.repo.SuspencionRepo;
import com.mitocode.service.SuspencionService;

@Service
public class SuspencionServiceImpl implements SuspencionService {

	@Autowired
	SuspencionRepo repo;

	private static final Logger LOG = LoggerFactory.getLogger(Exception.class);

	@Override
	public Suspencion registrar(Suspencion obj) {
		try {
			return repo.save(obj);
		} catch (Exception e) {
			LOG.error(this.getClass().getSimpleName() + " registrarSuspencion. ERROR : " + e.getMessage());
			throw e;
		}
	}

	@Override
	public Suspencion modificar(Suspencion obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Suspencion leer(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Suspencion> listar() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean eliminar(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Suspencion encontrarSusp(Trabajador trab) {
		try {
			return repo.findByTrabajador(trab);
		} catch (Exception e) {
			LOG.error(this.getClass().getSimpleName() + " encontrarSuspencionPorTrabajador. ERROR : " + e.getMessage());
			throw e;
		}
	}

}

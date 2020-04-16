package com.mitocode.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mitocode.model.PdoAno;
import com.mitocode.model.PdoMes;
import com.mitocode.model.Rhe;
import com.mitocode.model.Trabajador;
import com.mitocode.repo.RheRepo;
import com.mitocode.service.RheService;

@Service
public class RheServiceImpl implements RheService{

	@Autowired
	RheRepo repo;
	
	private static final Logger LOG = LoggerFactory.getLogger(Exception.class);
	
	@Override
	public Rhe registrar(Rhe obj) {
		try {
		return repo.save(obj);
		} catch (Exception e) {
			LOG.error(this.getClass().getSimpleName() + " registrarRHE. ERROR : " + e.getMessage());
			throw e;
		}
	}

	@Override
	public Rhe modificar(Rhe obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Rhe leer(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Rhe> listar() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean eliminar(Integer id) {
		try {
		Boolean resp = repo.existsById(id);
		repo.deleteById(id);
		return resp;
		} catch (Exception e) {
			LOG.error(this.getClass().getSimpleName() + " eliminarRHE. ERROR : " + e.getMessage());
			throw e;
		}
	}
	
	@Override
	public List<Rhe> listarUlt(Integer id) {
		try {
		return repo.listarRhe(id);
		} catch (Exception e) {
			LOG.error(this.getClass().getSimpleName() + " listarUtimosRHE. ERROR : " + e.getMessage());
			throw e;
		}
	}
	
	@Override
	public Rhe encontrarRhe (Integer id) {
		try {
		return repo.findByIdRhe(id);
		} catch (Exception e) {
			LOG.error(this.getClass().getSimpleName() + " encontrarRHEId. ERROR : " + e.getMessage());
			throw e;
		}
	}
	
	@Override
	public List<Rhe> encontrarRhes (Trabajador trab, PdoAno pdoAno, PdoMes pdoMes) {
		try {
		return repo.findByTrabajadorAndPdoAnoAndPdoMes(trab, pdoAno, pdoMes);
		} catch (Exception e) {
			LOG.error(this.getClass().getSimpleName() + " encontrarRHE. ERROR : " + e.getMessage());
			throw e;
		}
	}
	
	@Override
	public List<Rhe> encontrarXTrab (Trabajador trab) {
		try {
		return repo.findByTrabajador(trab);
		} catch (Exception e) {
			LOG.error(this.getClass().getSimpleName() + " encontrarRHEPorTrabajador. ERROR : " + e.getMessage());
			throw e;
		}
	}

}

package com.mitocode.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mitocode.model.Modulo;
import com.mitocode.model.Perfil;
import com.mitocode.repo.ModuloRepo;
import com.mitocode.service.ModuloService;

@Service
public class ModuloServiceImpl implements ModuloService {

	@Autowired
	private ModuloRepo repo;
	
	private static final Logger LOG  = LoggerFactory.getLogger(Exception.class);
	
	@Override
	public Modulo registrar(Modulo obj) {
		// TODO Auto-generated method stub
		return null;
	}
	

	@Override
	public Modulo modificar(Modulo obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Modulo leer(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Modulo> listar() {
	
			return null;
			
	}

	@Override
	public Boolean eliminar(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public List<Modulo> listarModuloPorPerfil(Perfil perfil) {
		try {
			List<Modulo> lsres=repo.listarModuloPorPerfil(perfil.getIdPerfil());
			return lsres;
		}catch(Exception e) {
			LOG.error(this.getClass().getSimpleName() + " listarModuloPorPerfil. ERROR : " + e.getMessage());
			throw e;
		}
	}
}

package com.mitocode.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mitocode.model.TipoPlanilla;
import com.mitocode.model.TipoPlanillaPerfil;
import com.mitocode.repo.TipoPlanPerfilRepo;
import com.mitocode.service.TipoPlanPerfilService;

@Service
public class TipoPlanPerfilServiceImpl implements TipoPlanPerfilService{

	@Autowired
	TipoPlanPerfilRepo repo;
	
	@Override
	public TipoPlanillaPerfil registrar(TipoPlanillaPerfil obj) {
		return repo.save(obj);
	}

	@Override
	public TipoPlanillaPerfil modificar(TipoPlanillaPerfil obj) {
		try {
			return repo.save(obj);
		}catch(Exception e) {
			throw e;
		}
	}

	@Override
	public TipoPlanillaPerfil leer(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<TipoPlanillaPerfil> listar() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean eliminar(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<TipoPlanillaPerfil> listarPorTipoPlanilla(TipoPlanilla tipoPlanilla) {
		try {
			return repo.findByTipoPlanilla(tipoPlanilla);
		}catch(Exception e) {
			throw e;
		}
	}
}

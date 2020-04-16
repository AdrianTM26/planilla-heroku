package com.mitocode.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mitocode.model.Perfil;
import com.mitocode.repo.PerfilRepo;
import com.mitocode.service.PerfilService;

@Service
public class PerfilServiceImpl implements PerfilService{
	
	@Autowired
	PerfilRepo repo;
	
	@Override
	public Perfil registrar(Perfil obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Perfil modificar(Perfil obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Perfil leer(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Perfil> listar() {
		try {
			return repo.findAll();
		}catch(Exception e) {
			System.out.println(this.getClass().getSimpleName()+" listarPerfiles. ERROR : "+e.getMessage());
			return null;
		}
	}

	@Override
	public Boolean eliminar(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

}

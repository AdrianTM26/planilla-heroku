package com.mitocode.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mitocode.model.Remuneraciones;
import com.mitocode.model.TrabRemuneracion;
import com.mitocode.model.Trabajador;
import com.mitocode.repo.TrabRemuneracionRepo;
import com.mitocode.service.TrabRemuneracionService;
import com.mitocode.util.Constantes;

@Service
public class TrabRemuneracionServiceImpl implements TrabRemuneracionService {

	@Autowired
	TrabRemuneracionRepo repo;
	
	@Override
	public TrabRemuneracion registrar(TrabRemuneracion obj) {
		return repo.save(obj);
	}

	@Override
	public TrabRemuneracion modificar(TrabRemuneracion obj) {
		return repo.save(obj);
	}

	@Override
	public TrabRemuneracion leer(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<TrabRemuneracion> listar() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean eliminar(Integer id) {
		Boolean resp = repo.existsById(id);
		if(resp) {
			repo.deleteById(id);
		}
		return resp;
	}
	
	@Override
	public List<TrabRemuneracion> listarXTrab(Trabajador trab) {
		return repo.findByTrabajadorAndEstado(trab, Constantes.ConsActivo);
	}
	
	@Override
	public List<TrabRemuneracion> listarXTrabInac(Trabajador trab) {
		return repo.findByTrabajadorAndEstado(trab, Constantes.ConsInActivo);
	}
	
	@Override
	public Boolean existe(Remuneraciones rem) {
		TrabRemuneracion trabRemu = repo.findByRemuneraciones(rem);
		Boolean resp=false;
		if(trabRemu!=null) {
			resp=true;
		}
		return resp;
	}
	
	@Override
	public TrabRemuneracion darBaja(TrabRemuneracion trabRemu) {
		trabRemu.setEstado(Constantes.ConsInActivo);
		return repo.save(trabRemu);
	}

}

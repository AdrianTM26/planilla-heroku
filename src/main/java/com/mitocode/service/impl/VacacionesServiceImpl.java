package com.mitocode.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mitocode.model.Trabajador;
import com.mitocode.model.Vacaciones;
import com.mitocode.repo.VacacionesRepo;
import com.mitocode.service.VacacionesService;

@Service
public class VacacionesServiceImpl implements VacacionesService {
	
	@Autowired
	VacacionesRepo repo;
	
	@Override
	public Vacaciones registrar(Vacaciones obj) {
		try {
			return repo.save(obj);
		}catch(Exception e){
			System.out.println(this.getClass().getSimpleName()+" registrarVacacion. ERROR : "+e.getMessage());
			throw e;
		}
	}

	@Override
	public Vacaciones modificar(Vacaciones obj) {
		try {		
			return repo.save(obj);
		}catch(Exception e){
			System.out.println(this.getClass().getSimpleName()+" modificarVacacion. ERROR : "+e.getMessage());
			throw e;
		}
	}

	@Override
	public Vacaciones leer(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Vacaciones> listar() {
		try {		
			return repo.findAll();
		}catch(Exception e){
			System.out.println(this.getClass().getSimpleName()+" listarVacaciones. ERROR : "+e.getMessage());
			return null;
		}
	}

	@Override
	public Boolean eliminar(Integer id) {
		try {
			
			repo.deleteById(id);
			Boolean resp = repo.existsById(id);
			return resp;

		} catch (Exception e) {
			System.out.println(this.getClass().getSimpleName() + " eliminarVacacion. ERROR : " + e.getMessage());
			return null;
		}
	}

	@Override
	public List<Vacaciones> buscarPorTrabajador(Trabajador trabajador) {
		try {		
			return repo.findByTrabajador(trabajador);
		}catch(Exception e){
			System.out.println(this.getClass().getSimpleName()+" listarVacacionesPor trabajador. ERROR : "+e.getMessage());
			return null;
		}
	}

	@Override
	public Vacaciones buscarUltimoPeriodoPorTrabajador(Trabajador trabajador) {
		try {		
			return repo.findFirstByTrabajadorOrderByFechaFinDesc(trabajador);
		}catch(Exception e){
			System.out.println(this.getClass().getSimpleName()+" buscarVacacionPor trabajador. ERROR : "+e.getMessage());
			return null;
		}
	}

}

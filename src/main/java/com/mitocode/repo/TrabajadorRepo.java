package com.mitocode.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mitocode.model.Trabajador;

public interface TrabajadorRepo extends JpaRepository<Trabajador, Integer>{
	
	public Trabajador findByIdTrabajador(Integer id);
}

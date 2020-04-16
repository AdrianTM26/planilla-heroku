package com.mitocode.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mitocode.model.Suspencion;
import com.mitocode.model.Trabajador;

public interface SuspencionRepo extends JpaRepository<Suspencion, Integer> {
	
	public Suspencion findByTrabajador(Trabajador trab);

}

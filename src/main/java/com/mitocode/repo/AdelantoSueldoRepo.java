package com.mitocode.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mitocode.model.AdelantoSueldo;
import com.mitocode.model.Trabajador;

public interface AdelantoSueldoRepo extends JpaRepository<AdelantoSueldo, Integer>{
	
	public List<AdelantoSueldo> findByTrabajador (Trabajador trab);
	public List<AdelantoSueldo> findByTrabajadorAndEstado(Trabajador trab, Integer estado);
	public AdelantoSueldo findByIdAdelantoSueldo(Integer id);

}

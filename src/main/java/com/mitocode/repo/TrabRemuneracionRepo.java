package com.mitocode.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mitocode.model.Remuneraciones;
import com.mitocode.model.TrabRemuneracion;
import com.mitocode.model.Trabajador;

public interface TrabRemuneracionRepo extends JpaRepository<TrabRemuneracion, Integer> {

	List<TrabRemuneracion> findByTrabajadorAndEstado(Trabajador trab, Integer estado);
	
	TrabRemuneracion findByRemuneraciones (Remuneraciones rem);
}

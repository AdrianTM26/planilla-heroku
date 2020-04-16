package com.mitocode.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mitocode.model.Trabajador;
import com.mitocode.model.Vacaciones;

public interface VacacionesRepo extends JpaRepository<Vacaciones,Integer> {
	
	Boolean existsByTrabajador(Trabajador trabajador);
	
	List<Vacaciones> findByTrabajador(Trabajador trabajador);
	
	Vacaciones findFirstByTrabajadorOrderByFechaFinDesc(Trabajador trabajador);
}

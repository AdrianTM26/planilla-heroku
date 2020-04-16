package com.mitocode.repo;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.mitocode.model.DerechoHabientes;
import com.mitocode.model.Trabajador;


public interface DerechoHabientesRepo extends JpaRepository<DerechoHabientes, Integer>{
	
	public List<DerechoHabientes> findByEstadoAndTrabajador(Integer estado, Trabajador trabajador);
	public DerechoHabientes findByIdDerechoHabiente (Integer id);

}

package com.mitocode.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mitocode.model.Descuentos;
import com.mitocode.model.TrabDescuento;
import com.mitocode.model.Trabajador;

public interface TrabDescuentoRepo extends JpaRepository<TrabDescuento, Integer> {

	List<TrabDescuento> findByTrabajadorAndEstado(Trabajador trab, Integer estado);
	
	TrabDescuento findByDescuentos(Descuentos dsct);
}

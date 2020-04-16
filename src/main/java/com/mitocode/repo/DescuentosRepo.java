package com.mitocode.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mitocode.model.Descuentos;
import com.mitocode.model.Empresa;

public interface DescuentosRepo extends JpaRepository<Descuentos, Integer> {
	
	List<Descuentos> findByEmpresaAndEstado(Empresa emp, Integer estado);

}

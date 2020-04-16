package com.mitocode.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mitocode.model.Empresa;
import com.mitocode.model.Remuneraciones;

public interface RemuneracionesRepo extends JpaRepository<Remuneraciones, Integer> {

	List<Remuneraciones> findByEmpresaAndEstado(Empresa emp, Integer estado);
}

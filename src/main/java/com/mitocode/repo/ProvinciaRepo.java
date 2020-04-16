package com.mitocode.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mitocode.model.Departamento;
import com.mitocode.model.Provincia;

public interface ProvinciaRepo extends JpaRepository<Provincia, Integer>{

	List<Provincia> findByDepartamento(Departamento depa);

}

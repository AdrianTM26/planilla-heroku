package com.mitocode.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mitocode.model.Afp;
import com.mitocode.model.Empresa;


public interface AfpRepo extends JpaRepository<Afp, Integer> {
	
	List<Afp> findByEmpresa(Empresa empresa);
	List<Afp> findByDescripcion(String descripcion);
}

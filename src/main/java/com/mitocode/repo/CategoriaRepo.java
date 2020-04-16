package com.mitocode.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mitocode.model.Categoria;
import com.mitocode.model.Empresa;


public interface CategoriaRepo extends JpaRepository<Categoria, Integer> {

	List<Categoria> findByEmpresa(Empresa empresa);
	Categoria findCategoriaByDescripcion(String categoria);

}

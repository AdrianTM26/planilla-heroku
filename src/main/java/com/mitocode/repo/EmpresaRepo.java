package com.mitocode.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mitocode.model.Empresa;


public interface EmpresaRepo extends JpaRepository<Empresa, Integer> {

	Empresa findByRuc (String ruc);
	Empresa findByRazonSocial (String razonSocial);
}

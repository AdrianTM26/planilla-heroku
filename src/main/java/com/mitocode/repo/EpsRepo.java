package com.mitocode.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mitocode.model.Empresa;
import com.mitocode.model.Eps;

public interface EpsRepo extends JpaRepository<Eps, Integer>{
	
	List<Eps> findByEmpresa(Empresa empresa);
}

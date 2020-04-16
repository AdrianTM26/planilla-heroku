package com.mitocode.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mitocode.model.CentroCosto;
import com.mitocode.model.Empresa;

public interface CentroCostoRepo extends JpaRepository<CentroCosto, Integer>{

	List<CentroCosto> findByEmpresa(Empresa empresa);

}

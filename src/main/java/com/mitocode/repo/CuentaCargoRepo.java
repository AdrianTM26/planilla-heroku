package com.mitocode.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mitocode.model.CuentaCargo;
import com.mitocode.model.Empresa;

public interface CuentaCargoRepo extends JpaRepository<CuentaCargo, Integer>{

	List<CuentaCargo> findByEmpresa(Empresa empresa);
	
	CuentaCargo findByIdCuentaCargo(Integer id);
}

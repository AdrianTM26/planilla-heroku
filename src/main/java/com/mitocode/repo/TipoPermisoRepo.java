package com.mitocode.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mitocode.model.Empresa;
import com.mitocode.model.TipoPermiso;

public interface TipoPermisoRepo extends JpaRepository<TipoPermiso,Integer> {
	
	public List<TipoPermiso> findByEmpresa(Empresa empresa);
}

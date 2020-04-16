package com.mitocode.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mitocode.model.Empresa;
import com.mitocode.model.Horario;

public interface HorarioRepo extends JpaRepository<Horario,Integer>{
	
	List<Horario> findByEmpresa(Empresa empresa);
}

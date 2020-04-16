package com.mitocode.repo;


import org.springframework.data.jpa.repository.JpaRepository;

import com.mitocode.model.PdoMes;

public interface PdoMesRepo extends JpaRepository<PdoMes, Integer>{

	PdoMes findByIdPdoMes (Integer id);
		
}

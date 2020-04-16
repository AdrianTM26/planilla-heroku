package com.mitocode.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mitocode.model.Distrito;
import com.mitocode.model.Provincia;

public interface DistritoRepo extends JpaRepository<Distrito, Integer>{

	List<Distrito> findByProvincia(Provincia prov);

}

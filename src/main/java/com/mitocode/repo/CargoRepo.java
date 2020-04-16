package com.mitocode.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.mitocode.model.Cargo;
import com.mitocode.model.Categoria;

public interface CargoRepo extends JpaRepository<Cargo, Integer> {
	
	@Query(value="select car.id_cargo, car.descripcion, cat.id_categoria, cat.descripcion, emp.id_empresa, emp.razon_social  from categoria cat\r\n" + 
			"Inner Join cargo car On car.id_categoria = cat.id_categoria \r\n" + 
			"Inner Join empresa emp on emp.id_empresa = cat.id_empresa where emp.id_empresa = :idempresa", nativeQuery = true)
	List<Cargo> listarCargoXEmpresa(@Param("idempresa") Integer idEmpresa);

	List<Cargo> findByCategoria(Categoria categoria);
	Cargo findByDescripcion(String descripcion);
}

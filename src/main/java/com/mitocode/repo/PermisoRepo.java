package com.mitocode.repo;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mitocode.model.PdoAno;
import com.mitocode.model.PdoMes;
import com.mitocode.model.Permiso;
import com.mitocode.model.Trabajador;

public interface PermisoRepo extends JpaRepository<Permiso,Integer>{
	
	List<Permiso> findByTrabajadorAndPdoAnoAndPdoMesOrderByFechaIniAsc(Trabajador trabajador,PdoAno pdoAno, PdoMes pdoMes);
	Boolean existsByFechaIniAndTrabajador(Date fecha,Trabajador trabajador);
}

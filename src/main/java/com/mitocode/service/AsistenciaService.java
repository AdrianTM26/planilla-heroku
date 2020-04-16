package com.mitocode.service;

import java.sql.Date;
import java.util.List;

import com.mitocode.model.Asistencia;
import com.mitocode.model.PdoAno;
import com.mitocode.model.PdoMes;
import com.mitocode.model.Trabajador;

public interface AsistenciaService extends ICRUD<Asistencia> {
	
	List<Asistencia> buscarPorTrabajador(Trabajador trabajador, PdoAno pdoAno, PdoMes pdoMes);
	Boolean buscarPorFechaYTrabajador(Date fecha, Trabajador trabajador);
	List<Asistencia> guardarTodo(List<Asistencia> asistencias);

}

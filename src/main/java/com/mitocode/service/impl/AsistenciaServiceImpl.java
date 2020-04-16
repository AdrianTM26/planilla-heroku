package com.mitocode.service.impl;

import java.sql.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mitocode.model.Asistencia;
import com.mitocode.model.PdoAno;
import com.mitocode.model.PdoMes;
import com.mitocode.model.Trabajador;
import com.mitocode.repo.AsistenciaRepo;
import com.mitocode.service.AsistenciaService;

@Service
public class AsistenciaServiceImpl implements AsistenciaService {

	@Autowired
	AsistenciaRepo repo;

	private static final Logger LOG = LoggerFactory.getLogger(Exception.class);

	@Override
	public Asistencia registrar(Asistencia obj) {
		try {
			return repo.save(obj);
		} catch (Exception e) {
			LOG.error(this.getClass().getSimpleName() + "registrarAsistencia. ERROR : " + e.getMessage());
			throw e;
		}
	}

	@Override
	public Asistencia modificar(Asistencia obj) {
		try {
			return repo.save(obj);
		} catch (Exception e) {
			LOG.error(this.getClass().getSimpleName() + "actualizarAsistencia. ERROR : " + e.getMessage());
			throw e;
		}
	}

	@Override
	public Asistencia leer(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@Transactional(readOnly = true)
	public List<Asistencia> listar() {
		try {
			
			return repo.findAll();
			
		} catch (Exception e) {
			LOG.error(this.getClass().getSimpleName() + "listarAsistencia. ERROR : " + e.getMessage());
			throw e;
		}
	}

	@Override
	public Boolean eliminar(Integer id) {
		try {
		if (repo.existsById(id)) {
			repo.deleteById(id);
			return true;
		} else {
			return false;
		}
		}catch(Exception e) {
			LOG.error(this.getClass().getSimpleName() + "eliminarAsistencia. ERROR : " + e.getMessage());
			throw e;
		}
	}

	@Override
	@Transactional(readOnly = true)
	public List<Asistencia> buscarPorTrabajador(Trabajador trabajador, PdoAno pdoAno, PdoMes pdoMes) {
		try {
			return repo.findByTrabajadorAndPdoAnoAndPdoMesOrderByFechaAsc(trabajador, pdoAno, pdoMes);
		} catch (Exception e) {
			LOG.error(this.getClass().getSimpleName() + "listarAsistenciaPorTrabajador. ERROR : " + e.getMessage());
			throw e;
		}
	}

	@Override
	@Transactional(readOnly = true)
	public Boolean buscarPorFechaYTrabajador(Date fecha, Trabajador trabajador) {
		try {
			return repo.existsByFechaAndTrabajador(fecha, trabajador);
		} catch (Exception e) {
			LOG.error(this.getClass().getSimpleName() + "buscarPorFechaYTrabajador. ERROR : " + e.getMessage());
			throw e;
		}
	}

	@Override
	public List<Asistencia> guardarTodo(List<Asistencia> asistencias) {
		try {
			
		return repo.saveAll(asistencias);
		
		}catch(Exception e) {
			LOG.error(this.getClass().getSimpleName() + "guardarListaAsistencias. ERROR : " + e.getMessage());
			throw e;
		}
	}

}

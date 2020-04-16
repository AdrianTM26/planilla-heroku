package com.mitocode.service.impl;

import java.sql.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mitocode.model.Falta;
import com.mitocode.model.Trabajador;
import com.mitocode.repo.AsistenciaRepo;
import com.mitocode.repo.FaltasRepo;
import com.mitocode.service.FaltasService;

@Service
public class FaltasServiceImpl implements FaltasService {

	@Autowired
	FaltasRepo repo;

	@Autowired
	AsistenciaRepo repoAsistencia;

	private static final Logger LOG = LoggerFactory.getLogger(Exception.class);

	@Override
	@Transactional
	public Falta registrar(Falta obj) {
		try {
			return repo.save(obj);
		} catch (Exception e) {
			LOG.error(this.getClass().getSimpleName() + "registrarFalta. ERROR : " + e.getMessage());
			throw e;
		}
	}

	@Override
	@Transactional
	public Falta modificar(Falta obj) {
		try {
			return repo.save(obj);
		} catch (Exception e) {
			LOG.error(this.getClass().getSimpleName() + "modificarFalta. ERROR : " + e.getMessage());
			throw e;
		}
	}

	@Override
	public Falta leer(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@Transactional(readOnly = true)
	public List<Falta> listar() {
		try {
			return repo.findAll();
		} catch (Exception e) {
			LOG.error(this.getClass().getSimpleName() + "listarFaltas. ERROR : " + e.getMessage());
			throw e;
		}
	}

	@Override
	@Transactional
	public Boolean eliminar(Integer id) {
		try {
			if (repo.existsById(id)) {
				repo.deleteById(id);
				return true;
			} else {
				return false;
			}
		} catch (Exception e) {
			LOG.error(this.getClass().getSimpleName() + "eliminarFalta. ERROR : " + e.getMessage());
			throw e;
		}
	}

	@Override
	public List<Falta> busarPorTrabajadoryPeriodo(Falta falta) {
		try {
			return repo.findByTrabajadorAndPdoAnoAndPdoMesOrderByFechaAsc(falta.getTrabajador(), falta.getPdoAno(),
					falta.getPdoMes());
		} catch (Exception e) {
			LOG.error(this.getClass().getSimpleName() + "listarFaltaPorTrabajador. ERROR : " + e.getMessage());
			throw e;
		}
	}

	@Override
	public Integer buscarPorFechaYTrabajador(Date fecha, Trabajador trabajador) {
		try {
			Boolean buscarAsist = repoAsistencia.existsByFechaAndTrabajador(fecha, trabajador);
			if (buscarAsist) {
				return 0;
			} else {
				Boolean buscarFalta = repo.existsByFechaAndTrabajador(fecha, trabajador);
				if (buscarFalta) {
					return 1;
				} else {
					return 2;
				}
			}
		} catch (Exception e) {
			LOG.error(this.getClass().getSimpleName() + "buscarFaltaPorTrabajadorYFecha. ERROR : " + e.getMessage());
			throw e;
		}
	}

}

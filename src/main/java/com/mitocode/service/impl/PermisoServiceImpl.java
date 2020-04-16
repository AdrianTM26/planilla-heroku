package com.mitocode.service.impl;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mitocode.model.Permiso;
import com.mitocode.model.Trabajador;
import com.mitocode.repo.PermisoRepo;
import com.mitocode.service.PermisoService;

@Service
public class PermisoServiceImpl implements PermisoService {

	@Autowired
	PermisoRepo repo;

	private static final Logger LOG = LoggerFactory.getLogger(Exception.class);

	@Override
	public Permiso registrar(Permiso obj) {
		try {
			Integer dias = obj.getTipoPermiso().getDiasPermiso();
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(obj.getFechaIni());
			calendar.add(Calendar.DAY_OF_YEAR, dias);
			obj.setFechaFin(calendar.getTime());

			return repo.save(obj);
		} catch (Exception e) {
			LOG.error(this.getClass().getSimpleName() + "registrarPermiso. ERROR : " + e.getMessage());
			throw e;
		}
	}

	@Override
	public Permiso modificar(Permiso obj) {
		try {
			Integer dias = obj.getTipoPermiso().getDiasPermiso();
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(obj.getFechaIni());
			calendar.add(Calendar.DAY_OF_YEAR, dias);
			obj.setFechaFin(calendar.getTime());
			return repo.save(obj);
		} catch (Exception e) {
			LOG.error(this.getClass().getSimpleName() + "modificarPermiso. ERROR : " + e.getMessage());
			throw e;
		}
	}

	@Override
	public Permiso leer(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Permiso> listar() {
		try {
			return repo.findAll();
		} catch (Exception e) {
			LOG.error(this.getClass().getSimpleName() + "listarAsistencia. ERROR : " + e.getMessage());
			throw e;
		}
	}

	@Override
	public Boolean eliminar(Integer id) {
		if (repo.existsById(id)) {
			repo.deleteById(id);
			return true;
		} else {
			return false;
		}
	}

	@Override
	public List<Permiso> listarPorTrabajadoryPeriodo(Permiso permiso) {
		try {
			return repo.findByTrabajadorAndPdoAnoAndPdoMesOrderByFechaIniAsc(permiso.getTrabajador(),
					permiso.getPdoAno(), permiso.getPdoMes());
		} catch (Exception e) {
			LOG.error(this.getClass().getSimpleName() + "listarPermisosPorTrabajador. ERROR : " + e.getMessage());
			throw e;
		}
	}

	@Override
	public Boolean buscarPorFechaYTrabajador(Date fecha, Trabajador trabajador) {
		try {
			return repo.existsByFechaIniAndTrabajador(fecha, trabajador);
		} catch (Exception e) {
			LOG.error(this.getClass().getSimpleName() + "buscarPorFechayTrabajador. ERROR : " + e.getMessage());
			throw e;
		}
	}

}

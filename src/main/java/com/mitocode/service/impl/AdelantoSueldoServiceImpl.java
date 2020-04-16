package com.mitocode.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mitocode.exception.ResponseExceptionHandler;
import com.mitocode.model.AdelantoSueldo;
import com.mitocode.model.Trabajador;
import com.mitocode.repo.AdelantoSueldoRepo;
import com.mitocode.service.AdelantoSueldoService;
import com.mitocode.util.Constantes;

@Service
public class AdelantoSueldoServiceImpl implements AdelantoSueldoService {

	@Autowired
	AdelantoSueldoRepo repo;

	private static final Logger LOG = LoggerFactory.getLogger(Exception.class);

	@Override
	public AdelantoSueldo registrar(AdelantoSueldo obj) {
		try {
			return repo.save(obj);

		} catch (Exception e) {
			LOG.error(this.getClass().getSimpleName() + " registrarAdelantoSueldo. ERROR : " + e.getMessage());
			throw e;
		}

	}

	@Override
	public AdelantoSueldo modificar(AdelantoSueldo obj) {
		try {

			return repo.save(obj);

		} catch (Exception e) {
			LOG.error(this.getClass().getSimpleName() + " modificarAdelantoSueldo. ERROR : " + e.getMessage());
			throw e;
		}
	}

	@Override
	public AdelantoSueldo leer(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<AdelantoSueldo> listar() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean eliminar(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<AdelantoSueldo> listarXTrab(Trabajador trab) {
		try {
			return repo.findByTrabajador(trab);
		} catch (Exception e) {
			LOG.error(
					this.getClass().getSimpleName() + " listsarAdelantoSueldoPorTrabajador. ERROR : " + e.getMessage());
			throw e;
		}
	}

	@Override
	public AdelantoSueldo deudaSaldada(AdelantoSueldo obj) {
		try {

			obj.setEstado(1);
			return repo.save(obj);

		} catch (Exception e) {
			LOG.error(this.getClass().getSimpleName() + " deudaSaldada. ERROR : " + e.getMessage());
			throw e;
		}
	}

	@Override
	public List<AdelantoSueldo> listarDeuda(Trabajador trab) {
		try {

			return repo.findByTrabajadorAndEstado(trab, Constantes.ConsInActivo);

		} catch (Exception e) {
			LOG.error(this.getClass().getSimpleName() + " listarDeuda. ERROR : " + e.getMessage());
			throw e;
		}
	}

	@Override
	public AdelantoSueldo econtrarAdeSueldo(Integer id) {
		try {
			
		return repo.findByIdAdelantoSueldo(id);
		
		}catch(Exception e) {
			LOG.error(this.getClass().getSimpleName()+" buscarAdelantoSueldo. ERROR : "+e.getMessage());
			throw e;
		}
	}

}

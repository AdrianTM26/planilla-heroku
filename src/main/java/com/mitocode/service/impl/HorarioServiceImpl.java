package com.mitocode.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mitocode.model.Empresa;
import com.mitocode.model.Horario;
import com.mitocode.repo.HorarioRepo;
import com.mitocode.service.HorarioService;

@Service
public class HorarioServiceImpl implements HorarioService {

	@Autowired
	HorarioRepo repoHorario;
	
	private static final Logger LOG  = LoggerFactory.getLogger(Exception.class);

	@Override
	public Horario registrar(Horario obj) {
		try {
			return repoHorario.save(obj);
		} catch (Exception e) {
			LOG.error(this.getClass().getSimpleName() + " registrarHorario. ERROR : " + e.getMessage());
			throw e;
		}
	}

	@Override
	public Horario modificar(Horario obj) {
		try {
			return repoHorario.save(obj);
		} catch (Exception e) {
			LOG.error(this.getClass().getSimpleName() + " modificarHorario. ERROR : " + e.getMessage());
			throw e;
		}
	}

	@Override
	public Horario leer(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Horario> listar() {
		try {
			return repoHorario.findAll();
		} catch (Exception e) {
			LOG.error(this.getClass().getSimpleName() + " listarHorario. ERROR : " + e.getMessage());
			throw e;
		}
	}

	@Override
	public Boolean eliminar(Integer id) {
		try {
			boolean verificar = repoHorario.existsById(id);
			if(verificar) {
				repoHorario.deleteById(id);
				return true;
			}else {
				return false;
			}
		} catch (Exception e) {
			LOG.error(this.getClass().getSimpleName() + " eliminarHorario. ERROR : " + e.getMessage());
			throw e;
		}
	}

	@Override
	public List<Horario> listarPorEmpresa(Empresa empresa) {
		try {
			return repoHorario.findByEmpresa(empresa);
		} catch (Exception e) {
			LOG.error(this.getClass().getSimpleName() + " listarHorarioPorEmpresa. ERROR : " + e.getMessage());
			throw e;
		}
	}

}

package com.mitocode.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mitocode.model.Empresa;
import com.mitocode.model.Remuneraciones;
import com.mitocode.repo.RemuneracionesRepo;
import com.mitocode.service.RemuneracionesService;
import com.mitocode.util.Constantes;

@Service
public class RemuneracionesServiceImpl implements RemuneracionesService {

	@Autowired
	RemuneracionesRepo repo;

	private static final Logger LOG = LoggerFactory.getLogger(Exception.class);

	@Override
	public Remuneraciones registrar(Remuneraciones obj) {
		try {
			return repo.save(obj);
		} catch (Exception e) {
			LOG.error(this.getClass().getSimpleName() + " registrarRemuneracion. ERROR : " + e.getMessage());
			throw e;
		}
	}

	@Override
	public Remuneraciones modificar(Remuneraciones obj) {
		try {
			return repo.save(obj);
		} catch (Exception e) {
			LOG.error(this.getClass().getSimpleName() + " modificarRemuneracion. ERROR : " + e.getMessage());
			throw e;
		}
	}

	@Override
	public Remuneraciones leer(Integer id) {
		return null;
	}

	@Override
	public List<Remuneraciones> listar() {
		return null;
	}

	@Override
	public Boolean eliminar(Integer id) {
		try {
			Boolean resp = repo.existsById(id);
			if (resp) {
				repo.deleteById(id);
			}
			return resp;
		} catch (Exception e) {
			LOG.error(this.getClass().getSimpleName() + " eliminarRemuneracion. ERROR : " + e.getMessage());
			throw e;
		}
	}

	@Override
	public List<Remuneraciones> listarXEmpresa(Empresa emp) {
		try {
			return repo.findByEmpresaAndEstado(emp, Constantes.ConsActivo);
		} catch (Exception e) {
			LOG.error(this.getClass().getSimpleName() + " listarRemuneracionesPorEmpresa. ERROR : " + e.getMessage());
			throw e;
		}
	}

	@Override
	public List<Remuneraciones> listarXEmpresaInac(Empresa emp) {
		try {
			return repo.findByEmpresaAndEstado(emp, Constantes.ConsInActivo);
		} catch (Exception e) {
			LOG.error(this.getClass().getSimpleName() + " listarRemuneracionesInactivaPorEmpresa. ERROR : "
					+ e.getMessage());
			throw e;
		}
	}

	@Override
	public Remuneraciones darBaja(Remuneraciones rem) {
		try {
			rem.setEstado(0);
			return repo.save(rem);
		} catch (Exception e) {
			LOG.error(this.getClass().getSimpleName() + " darBajaRemuneracion. ERROR : " + e.getMessage());
			throw e;
		}
	}

	@Override
	public Remuneraciones activar(Remuneraciones rem) {
		try {
			rem.setEstado(1);
			return repo.save(rem);
		} catch (Exception e) {
			LOG.error(this.getClass().getSimpleName() + " activarRemuneracion. ERROR : " + e.getMessage());
			throw e;
		}
	}

}

package com.mitocode.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mitocode.model.CuentaCargo;
import com.mitocode.model.Empresa;
import com.mitocode.repo.CuentaCargoRepo;
import com.mitocode.service.CuentaCargoService;

@Service
public class CuentaCargoServiceImpl implements CuentaCargoService {

	@Autowired
	CuentaCargoRepo repo;

	private static final Logger LOG = LoggerFactory.getLogger(Exception.class);

	@Override
	public CuentaCargo registrar(CuentaCargo obj) {
		try {
			return repo.save(obj);
		} catch (Exception e) {
			LOG.error(this.getClass().getSimpleName() + "registrarCuentaCargo. ERROR : " + e.getMessage());
			throw e;

		}
	}

	@Override
	public CuentaCargo modificar(CuentaCargo obj) {
		try {
			return repo.save(obj);
		} catch (Exception e) {
			LOG.error(this.getClass().getSimpleName() + "modificarCuentaCargo. ERROR : " + e.getMessage());
			throw e;

		}
	}

	@Override
	public CuentaCargo leer(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CuentaCargo> listar() {
		// TODO Auto-generated method stub
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
			LOG.error(this.getClass().getSimpleName() + "eiminarCuentaCargo. ERROR : " + e.getMessage());
			throw e;

		}
	}

	@Override
	public List<CuentaCargo> listarxEmpresa(Empresa emp) {
		try {
			return repo.findByEmpresa(emp);
		} catch (Exception e) {
			LOG.error(this.getClass().getSimpleName() + "listarCuentaCargoPorEmpresa. ERROR : " + e.getMessage());
			throw e;

		}
	}

	@Override
	public CuentaCargo encontrarCueCargo(CuentaCargo cueCargo) {
		try {
			return repo.findByIdCuentaCargo(cueCargo.getIdCuentaCargo());
		} catch (Exception e) {
			LOG.error(this.getClass().getSimpleName() + "encontrarCuentaCargo. ERROR : " + e.getMessage());
			throw e;

		}
	}

}

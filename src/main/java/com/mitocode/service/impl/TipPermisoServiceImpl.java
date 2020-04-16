package com.mitocode.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mitocode.model.Empresa;
import com.mitocode.model.TipoPermiso;
import com.mitocode.repo.TipoPermisoRepo;
import com.mitocode.service.TipoPermisoService;

@Service
public class TipPermisoServiceImpl implements TipoPermisoService {
	
	@Autowired
	TipoPermisoRepo repo;
	
	private static final Logger LOG = LoggerFactory.getLogger(Exception.class);
	
	@Override
	public TipoPermiso registrar(TipoPermiso obj) {
		try {
			return repo.save(obj);
		} catch (Exception e) {
			LOG.error(this.getClass().getSimpleName() + " registrarTipoPermiso. ERROR : " + e.getMessage());
			throw e;
		}
	}

	@Override
	public TipoPermiso modificar(TipoPermiso obj) {
		try {
			return repo.save(obj);
		} catch (Exception e) {
			System.out.println(this.getClass().getSimpleName() + " actualizarTipoPermiso. ERROR : " + e.getMessage());
			throw e;
		}
	}

	@Override
	public TipoPermiso leer(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<TipoPermiso> listar() {
		try {
			return repo.findAll();
		} catch (Exception e) {
			LOG.error(this.getClass().getSimpleName() + " listarTipoPermiso. ERROR : " + e.getMessage());
			throw e;
		}
	}

	@Override
	public Boolean eliminar(Integer id) {
		try {
			Boolean resp = repo.existsById(id);
			if(resp) {
				repo.deleteById(id);
				return true;
			}
			else {
				return false;
			}
		} catch (Exception e) {
			LOG.error(this.getClass().getSimpleName() + " eliminarTipoPermiso. ERROR : " + e.getMessage());
			throw e;
		}
	}

	@Override
	public List<TipoPermiso> listarPorEmpresa(Empresa empresa) {
		try {
			return repo.findByEmpresa(empresa);
		} catch (Exception e) {
			LOG.error(this.getClass().getSimpleName() + " listarTipoPermiso. ERROR : " + e.getMessage());
			throw e;
		}
	}

}

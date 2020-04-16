package com.mitocode.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mitocode.model.Cargo;
import com.mitocode.model.Categoria;
import com.mitocode.model.Empresa;
import com.mitocode.repo.CargoRepo;
import com.mitocode.service.CargoService;

@Service
public class CargoServiceImpl implements CargoService {

	@Autowired
	private CargoRepo repo;

	private static final Logger LOG = LoggerFactory.getLogger(Exception.class);

	@Override
	public Cargo registrar(Cargo obj) {
		try {
			return repo.save(obj);
		} catch (Exception e) {
			LOG.error(this.getClass().getSimpleName() + " registrar. ERROR : " + e.getMessage());
			throw e;
		}
	}

	@Override
	public Cargo modificar(Cargo obj) {
		try {
			return repo.save(obj);
		} catch (Exception e) {
			LOG.error(this.getClass().getSimpleName() + " registrarAFP. ERROR : " + e.getMessage());
			throw e;
		}
	}

	@Override
	public Cargo leer(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Cargo> listar() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean eliminar(Integer id) {
		try {
			repo.deleteById(id);
			Boolean resp = repo.existsById(id);
			return resp;

		} catch (Exception e) {
			LOG.error(this.getClass().getSimpleName() + " eliminarEmpresa. ERROR : " + e.getMessage());
			throw e;
		}
	}

	@Override
	public List<Cargo> listarPorCategoria(Categoria categoria) {
		try {

			return repo.findByCategoria(categoria);

		} catch (Exception e) {
			LOG.error(this.getClass().getSimpleName() + " listarPorCategoria. ERROR : " + e.getMessage());
			throw e;
		}
	}

	@Override
	public Cargo listarPorDescripcion(Cargo cargo) {
		try {
			
		return repo.findByDescripcion(cargo.getDescripcion());
		
		}catch(Exception e) {
			LOG.error(this.getClass().getSimpleName() + " listarCargoPorDescripcion. ERROR : " + e.getMessage());
			throw e;
		}

	}

	@Override
	public List<Cargo> listarCargoXEmpresa(Empresa empresa) {
		try {
			List<Cargo> lsres = repo.listarCargoXEmpresa(empresa.getIdEmpresa());
			return lsres;
		} catch (Exception e) {
			LOG.error(this.getClass().getSimpleName() + " listarCargoPorEmpresa. ERROR : " + e.getMessage());
			throw e;
		}
	}

}

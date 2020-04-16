package com.mitocode.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mitocode.model.Empresa;
import com.mitocode.model.EncargadoPlanilla;
import com.mitocode.repo.EncargadoPlanillaRepo;
import com.mitocode.service.EncargadoPlanillaService;
import com.mitocode.util.Constantes;

@Service
public class EncargadoPlanillaServiceImpl implements EncargadoPlanillaService {

	@Autowired
	EncargadoPlanillaRepo repo;

	private static final Logger LOG = LoggerFactory.getLogger(Exception.class);

	@Override
	public EncargadoPlanilla registrar(EncargadoPlanilla obj) {
		try {
			return repo.save(obj);
		} catch (Exception e) {
			LOG.error(this.getClass().getSimpleName() + " registrarEncargadoPlanilla. ERROR : " + e.getMessage());
			throw e;
		}
	}

	@Override
	public EncargadoPlanilla modificar(EncargadoPlanilla obj) {
		try {
			return repo.save(obj);
		} catch (Exception e) {
			LOG.error(this.getClass().getSimpleName() + " modificarEncargadoPlanilla. ERROR : " + e.getMessage());
			throw e;
		}
	}

	@Override
	public EncargadoPlanilla leer(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<EncargadoPlanilla> listar() {
		try {
			return repo.findAll();
		} catch (Exception e) {
			LOG.error(this.getClass().getSimpleName() + " listarEncargadosPlanilla. ERROR : " + e.getMessage());
			throw e;
		}
	}

	@Override
	public Boolean eliminar(Integer id) {
		try {
			Boolean existe = repo.existsById(id);
			if (existe) {
				repo.deleteById(id);
			}
			return existe;
		} catch (Exception e) {
			LOG.error(this.getClass().getSimpleName() + " eliminarEncargadoPlanilla. ERROR : " + e.getMessage());
			throw e;
		}
	}

	@Override
	public List<EncargadoPlanilla> listarXEmpresa(Empresa emp) {
		try {
			return repo.findByEmpresaAndEstado(emp, Constantes.ConsActivo);
		} catch (Exception e) {
			LOG.error(
					this.getClass().getSimpleName() + " listarEncargadosPlanillaPorEmpresa. ERROR : " + e.getMessage());
			throw e;
		}
	}

	@Override
	public EncargadoPlanilla darBaja(EncargadoPlanilla obj) {
		try {
			obj.setEstado(0);
			return repo.save(obj);
		} catch (Exception e) {
			LOG.error(this.getClass().getSimpleName() + " darBajaEncargadoPlanilla. ERROR : " + e.getMessage());
			throw e;
		}
	}

	@Override
	public EncargadoPlanilla activar(EncargadoPlanilla obj) {
		try {
			obj.setEstado(1);
			return repo.save(obj);
		} catch (Exception e) {
			LOG.error(this.getClass().getSimpleName() + " activarEncargadoPlanilla. ERROR : " + e.getMessage());
			throw e;
		}
	}

	@Override
	public List<EncargadoPlanilla> listarXEmpresaInac(Empresa emp) {
		try {
			return repo.findByEmpresaAndEstado(emp, Constantes.ConsInActivo);
		} catch (Exception e) {
			LOG.error(this.getClass().getSimpleName() + " listarEncargadosPlanillaInactivoPorEmpresa. ERROR : "
					+ e.getMessage());
			throw e;
		}
	}

	@Override
	public EncargadoPlanilla encontrar(Integer id) {
		try {
			return repo.findByIdEncargadoPlanilla(id);
		} catch (Exception e) {
			LOG.error(this.getClass().getSimpleName() + " encontrarEncargadoPlanilla. ERROR : " + e.getMessage());
			throw e;
		}
	}

}

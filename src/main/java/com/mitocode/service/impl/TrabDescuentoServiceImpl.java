package com.mitocode.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mitocode.model.Descuentos;
import com.mitocode.model.TrabDescuento;
import com.mitocode.model.Trabajador;
import com.mitocode.repo.TrabDescuentoRepo;
import com.mitocode.service.TrabDescuentoService;
import com.mitocode.util.Constantes;

@Service
public class TrabDescuentoServiceImpl implements TrabDescuentoService {

	@Autowired
	TrabDescuentoRepo repo;

	private static final Logger LOG = LoggerFactory.getLogger(Exception.class);

	@Override
	public TrabDescuento registrar(TrabDescuento obj) {
		try {
			return repo.save(obj);
		} catch (Exception e) {
			LOG.error(this.getClass().getSimpleName() + " registrarTrabDescuento. ERROR : " + e.getMessage());
			throw e;
		}
	}

	@Override
	public TrabDescuento modificar(TrabDescuento obj) {
		try {
			return repo.save(obj);
		} catch (Exception e) {
			LOG.error(this.getClass().getSimpleName() + " modificarTrabDescuento. ERROR : " + e.getMessage());
			throw e;
		}

	}

	@Override
	public TrabDescuento leer(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<TrabDescuento> listar() {
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
			LOG.error(this.getClass().getSimpleName() + " eliminarTrabDescuento. ERROR : " + e.getMessage());
			throw e;
		}
	}

	@Override
	public List<TrabDescuento> listarXTrab(Trabajador trab) {
		try {
			return repo.findByTrabajadorAndEstado(trab, Constantes.ConsActivo);
		} catch (Exception e) {
			LOG.error(this.getClass().getSimpleName() + " listarDescuentoPorTrabajador. ERROR : " + e.getMessage());
			throw e;
		}
	}

	@Override
	public List<TrabDescuento> listarXTrabInac(Trabajador trab) {
		try {
			return repo.findByTrabajadorAndEstado(trab, Constantes.ConsInActivo);
		} catch (Exception e) {
			LOG.error(this.getClass().getSimpleName() + " listarDescuentoInactivoPorTrabajador. ERROR : "
					+ e.getMessage());
			throw e;
		}
	}

	@Override
	public Boolean existe(Descuentos dsct) {
		try {
			TrabDescuento trabDsct = repo.findByDescuentos(dsct);
			Boolean resp = false;
			if (trabDsct != null) {
				resp = true;
			}
			return resp;
		} catch (Exception e) {
			LOG.error(this.getClass().getSimpleName() + " buscarPorDescuento. ERROR : " + e.getMessage());
			throw e;
		}
	}

	@Override
	public TrabDescuento darBaja(TrabDescuento trabDsct) {
		try {
			trabDsct.setEstado(Constantes.ConsInActivo);
			return repo.save(trabDsct);
		} catch (Exception e) {
			LOG.error(this.getClass().getSimpleName() + " darBajaTrabDescuento. ERROR : " + e.getMessage());
			throw e;
		}
	}

}

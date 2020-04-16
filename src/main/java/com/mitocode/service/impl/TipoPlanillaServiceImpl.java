package com.mitocode.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mitocode.model.Empresa;
import com.mitocode.model.Perfil;
import com.mitocode.model.TipoPlanilla;
import com.mitocode.model.TipoPlanillaDetalle;
import com.mitocode.model.TipoPlanillaPerfil;
import com.mitocode.model.Trabajador;
import com.mitocode.repo.TipoPlanPerfilRepo;
import com.mitocode.repo.TipoPlanillaDetalleRepo;
import com.mitocode.repo.TipoPlanillaRepo;
import com.mitocode.service.TipoPlanillaService;

@Service
public class TipoPlanillaServiceImpl implements TipoPlanillaService {

	@Autowired
	TipoPlanillaRepo repo;

	@Autowired
	TipoPlanillaDetalleRepo repo_detalle;

	@Autowired
	TipoPlanPerfilRepo repo_tipoplanilla_perfil;

	@Override
	public TipoPlanilla registrar(TipoPlanilla obj) {
		return repo.save(obj);
	}

	@Override
	public TipoPlanilla modificar(TipoPlanilla obj) {
		return repo.save(obj);
	}

	@Override
	public TipoPlanilla leer(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<TipoPlanilla> listar() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean eliminar(Integer id) {
		try {
			repo.deleteById(id);
			if (repo.existsById(id)) {
				return false;
			} else {
				return true;
			}
		} catch (Exception e) {
			throw e;
		}
	}

	@Override
	public List<TipoPlanilla> listarPorEmpresa(Empresa empresa) {
		try {
			return repo.findByEmpresa(empresa);
		} catch (Exception e) {
			throw e;
		}
	}

	@Override
	public TipoPlanilla encontrarTipPlan(TipoPlanilla tipPlan) {
		return repo.findByIdTipoPlanilla(tipPlan.getIdTipoPlanilla());
	}

	@Override
	public List<TipoPlanillaDetalle> registrarTrabajadores(List<Trabajador> lsTrabajador, TipoPlanilla tipoPlanilla) {
		try {
			List<TipoPlanillaDetalle> lsresp = new ArrayList<>();
			for (Trabajador t : lsTrabajador) {
				lsresp.add(repo_detalle.save(this.CrearTipoPlanillaDetall(tipoPlanilla, t)));
			}
			return lsresp;
		} catch (Exception e) {
			throw e;
		}
	}

	public TipoPlanillaDetalle CrearTipoPlanillaDetall(TipoPlanilla tp, Trabajador trb) {
		TipoPlanillaDetalle detalle = new TipoPlanillaDetalle();
		detalle.setTipoPlanilla(tp);
		detalle.setTrabajador(trb);
		return detalle;
	}

	@Override
	public List<TipoPlanilla> listarPorPerfil(Perfil perfil) {
		try {
			List<TipoPlanilla> lsTipoPlanilla = new ArrayList<>();
			List<TipoPlanillaPerfil> lsTipoPlanillaPerfil = repo_tipoplanilla_perfil.findByPerfil(perfil);
			for (TipoPlanillaPerfil tp : lsTipoPlanillaPerfil) {
				lsTipoPlanilla.add(tp.getTipoPlanilla());
			}
			return lsTipoPlanilla;
		} catch (Exception e) {
			throw e;
		}
	}

}

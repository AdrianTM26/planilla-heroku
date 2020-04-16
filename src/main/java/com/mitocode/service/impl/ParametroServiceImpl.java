package com.mitocode.service.impl;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mitocode.dto.EmpresaDTO;
import com.mitocode.model.Empresa;
import com.mitocode.model.Parametro;
import com.mitocode.repo.ParametroRepo;
import com.mitocode.service.ParametroService;
import com.mitocode.util.Constantes;

@Service
public class ParametroServiceImpl implements ParametroService {

	@Autowired
	private ParametroRepo repo;

	private static final Logger LOG = LoggerFactory.getLogger(Exception.class);

	@Override
	public Parametro modificar(Parametro obj) {
		try {

			Parametro resp = repo.save(obj);

			if (obj.getCodigo().equals(Constantes.CODTIPTARD)) {
				if (obj.getValor().equals("1")) {
					Parametro tmp_par_cnt_dias = repo.findByCodigoAndEmpresa(Constantes.CODTARCNTDIAS, obj.getEmpresa());
					tmp_par_cnt_dias.setEstado(Constantes.ConsActivo);
					repo.save(tmp_par_cnt_dias);
					Parametro tmp_par_ran_min = repo.findByCodigoAndEmpresa(Constantes.CODTIPORANGO, obj.getEmpresa());
					tmp_par_ran_min.setEstado(Constantes.ConsInActivo);
					repo.save(tmp_par_ran_min);
				} else {
					Parametro tmp_par_cnt_dias = repo.findByCodigoAndEmpresa(Constantes.CODTARCNTDIAS, obj.getEmpresa());
					tmp_par_cnt_dias.setEstado(Constantes.ConsInActivo);
					repo.save(tmp_par_cnt_dias);
					Parametro tmp_par_ran_min = repo.findByCodigoAndEmpresa(Constantes.CODTIPORANGO, obj.getEmpresa());
					tmp_par_ran_min.setEstado(Constantes.ConsActivo);
					repo.save(tmp_par_ran_min);
				}
			}

			return resp;

		} catch (Exception e) {
			LOG.error(this.getClass().getSimpleName() + " modificarParametro. ERROR : " + e.getMessage());
			throw e;
		}
	}

	@Override
	public Parametro registrar(Parametro obj) {
		try {
			return repo.save(obj);
		} catch (Exception e) {
			LOG.error(this.getClass().getSimpleName() + " registrarParametro. ERROR : " + e.getMessage());
			throw e;
		}

	}

	@Override
	public Parametro leer(Integer id) {
		// TODO Auto-generated method stub
		Optional<Parametro> op = repo.findById(id);
		return op.isPresent() ? op.get() : new Parametro();

	}

	@Override
	public List<Parametro> listar() {
		try {
			return repo.findAll();
		} catch (Exception e) {
			LOG.error(this.getClass().getSimpleName() + " listarParametros. ERROR : " + e.getMessage());
			throw e;
		}
	}

	@Override
	public Parametro buscarPorCodigoAndEmpresa(EmpresaDTO empresadto) {
		try {
			return repo.findByCodigoAndEmpresa(empresadto.getParametro().getCodigo(), empresadto.getEmpresa());
		} catch (Exception e) {
			LOG.error(this.getClass().getSimpleName() + " buscarPorCodigoYEmpresa. ERROR : " + e.getMessage());
			throw e;
		}
	}

	@Override
	public Parametro buscarTardanzaPorEmpresa(Empresa empresa) {

		try {
			return repo.findByCodigoAndEmpresa(Constantes.CODTIPTARD, empresa);
		} catch (Exception e) {
			LOG.error(this.getClass().getSimpleName() + " buscarTardanzaPorEmpresa. ERROR : " + e.getMessage());
			throw e;
		}

	}

	@Override
	public Parametro buscarRangoPorEmpresa(Empresa empresa) {
		try {
			return repo.findByCodigoAndEmpresa(Constantes.CODTIPORANGO, empresa);
		} catch (Exception e) {
			LOG.error(this.getClass().getSimpleName() + " buscarTipoTardanzaPorEmpresa. ERROR : " + e.getMessage());
			throw e;
		}

	}

	@Override
	public Boolean eliminar(Integer id) {
		try {
			if (repo.existsById(id)) {
				repo.deleteById(id);
				return true;
			} else {
				return false;
			}

		} catch (Exception e) {
			LOG.error(this.getClass().getSimpleName() + " eliminarParametro. ERROR : " + e.getMessage());
			throw e;
		}
	}

	@Override
	public List<Parametro> listarPorEmpresaActivo(Empresa empresa) {
		try {
			return repo.findByEstadoAndEmpresa(Constantes.ConsActivo, empresa);
		} catch (Exception e) {
			LOG.error(
					this.getClass().getSimpleName() + " listarParametrosPorEmpresasActivos. ERROR : " + e.getMessage());
			throw e;
		}
	}

	@Override
	public Parametro listarPorNombre(Parametro parametro) {
		try {
			return repo.findByNombre(parametro.getNombre());
		} catch (Exception e) {
			LOG.error(this.getClass().getSimpleName() + " listarParametrosPorNombre. ERROR : " + e.getMessage());
			throw e;
		}
	}
}
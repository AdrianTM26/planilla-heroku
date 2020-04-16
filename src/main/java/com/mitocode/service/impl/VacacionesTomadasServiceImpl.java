package com.mitocode.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mitocode.model.VacacionesTomadas;
import com.mitocode.repo.VacacionesTomadasRepo;
import com.mitocode.service.VacacionesTomadasService;

@Service
public class VacacionesTomadasServiceImpl implements VacacionesTomadasService {

	@Autowired
	VacacionesTomadasRepo repo;

	@Override
	public VacacionesTomadas registrar(VacacionesTomadas obj) {
		try {
			return repo.save(obj);
		} catch (Exception e) {
			System.out.println(this.getClass().getSimpleName() + " registrarVacacionTomada. ERROR : " + e.getMessage());
			throw e;
		}
	}

	@Override
	public VacacionesTomadas modificar(VacacionesTomadas obj) {
		try {
			return repo.save(obj);
		} catch (Exception e) {
			System.out
					.println(this.getClass().getSimpleName() + " actualizarVacacionTomada. ERROR : " + e.getMessage());
			return null;
		}
	}

	@Override
	public VacacionesTomadas leer(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<VacacionesTomadas> listar() {
		try {
			return repo.findAll();
		} catch (Exception e) {
			System.out.println(this.getClass().getSimpleName() + " listarVacacionesTomadas. ERROR : " + e.getMessage());
			return null;
		}
	}

	@Override
	public Boolean eliminar(Integer id) {
		try {

			repo.deleteById(id);
			Boolean resp = repo.existsById(id);
			return resp;

		} catch (Exception e) {
			System.out.println(this.getClass().getSimpleName() + " eliminarVacacionTomada. ERROR : " + e.getMessage());
			return null;
		}
	}

}

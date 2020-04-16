package com.mitocode.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mitocode.model.VacacionesVendidas;
import com.mitocode.repo.VacacionesVendidasRepo;
import com.mitocode.service.VacacionesVendidasService;

@Service
public class VacacionesVendidasServiceImpl implements VacacionesVendidasService {
	
	@Autowired
	VacacionesVendidasRepo repo;
	
	@Override
	public VacacionesVendidas registrar(VacacionesVendidas obj) {
		try {
			return repo.save(obj);
		} catch (Exception e) {
			System.out.println(this.getClass().getSimpleName() + " registrarVacacionVendida. ERROR : " + e.getMessage());
			return null;
		}
	}

	@Override
	public VacacionesVendidas modificar(VacacionesVendidas obj) {
		try {
			return repo.save(obj);
		} catch (Exception e) {
			System.out.println(this.getClass().getSimpleName() + " actualizarVacacionVendida. ERROR : " + e.getMessage());
			return null;
		}
	}

	@Override
	public VacacionesVendidas leer(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<VacacionesVendidas> listar() {
		try {
			return repo.findAll();
		} catch (Exception e) {
			System.out.println(this.getClass().getSimpleName() + " listarVacacionesVendidas. ERROR : " + e.getMessage());
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
			System.out.println(this.getClass().getSimpleName() + " eliminarVacacionVendida. ERROR : " + e.getMessage());
			return null;
		}
	}

}

package com.mitocode.service;

import java.util.List;

import com.mitocode.model.Remuneraciones;
import com.mitocode.model.TrabRemuneracion;
import com.mitocode.model.Trabajador;

public interface TrabRemuneracionService extends ICRUD<TrabRemuneracion> {

	List<TrabRemuneracion> listarXTrab(Trabajador trab);

	Boolean existe(Remuneraciones rem);

	TrabRemuneracion darBaja(TrabRemuneracion trabRemu);

	List<TrabRemuneracion> listarXTrabInac(Trabajador trab);

}

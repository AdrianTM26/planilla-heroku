package com.mitocode.service;

import java.util.List;

import com.mitocode.model.Descuentos;
import com.mitocode.model.TrabDescuento;
import com.mitocode.model.Trabajador;

public interface TrabDescuentoService extends ICRUD<TrabDescuento> {

	List<TrabDescuento> listarXTrab(Trabajador trab);

	Boolean existe(Descuentos dsct);

	TrabDescuento darBaja(TrabDescuento trabDsct);

	List<TrabDescuento> listarXTrabInac(Trabajador trab);

}

package com.mitocode.service;

import java.util.List;

import com.mitocode.model.CuentaCargo;
import com.mitocode.model.Empresa;

public interface CuentaCargoService extends ICRUD<CuentaCargo>{

	List<CuentaCargo> listarxEmpresa(Empresa emp);

	CuentaCargo encontrarCueCargo(CuentaCargo cueCargo);

}

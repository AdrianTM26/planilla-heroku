package com.mitocode.service;

import java.util.List;

import com.mitocode.model.PdoAno;
import com.mitocode.model.PdoMes;
import com.mitocode.model.Rhe;
import com.mitocode.model.Trabajador;

public interface RheService extends ICRUD<Rhe>{

	List<Rhe> listarUlt(Integer id);

	Rhe encontrarRhe(Integer id);

	List<Rhe> encontrarRhes(Trabajador trab, PdoAno pdoAno, PdoMes pdoMes);

	List<Rhe> encontrarXTrab(Trabajador trab);

}

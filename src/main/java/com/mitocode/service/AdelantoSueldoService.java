package com.mitocode.service;

import java.util.List;

import com.mitocode.model.AdelantoSueldo;
import com.mitocode.model.Trabajador;

public interface AdelantoSueldoService extends ICRUD<AdelantoSueldo>{

	List<AdelantoSueldo> listarXTrab(Trabajador trab);

	AdelantoSueldo deudaSaldada(AdelantoSueldo obj);

	List<AdelantoSueldo> listarDeuda(Trabajador trab);

	AdelantoSueldo econtrarAdeSueldo(Integer id);

}

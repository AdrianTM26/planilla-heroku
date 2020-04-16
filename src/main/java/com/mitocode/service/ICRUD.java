package com.mitocode.service;

import java.util.List;

import com.mitocode.model.Parametro;

public interface ICRUD<T> {

	T registrar(T obj);
	T modificar(T obj);
	T leer(Integer id);
	List<T> listar();
	Boolean eliminar(Integer id);
}

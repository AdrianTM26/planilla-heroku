package com.mitocode.dto;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import com.mitocode.model.Cargo;
import com.mitocode.model.Categoria;

public class CategoriaDTO {
	
	@NotNull(message="No se ha especificado una categoria para el cargo")
	private Categoria categoria;
	
	@NotNull(message="No se ha especificado un cargo")
	@Valid
	private Cargo cargo;

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public Cargo getCargo() {
		return cargo;
	}

	public void setCargo(Cargo cargo) {
		this.cargo = cargo;
	}

}

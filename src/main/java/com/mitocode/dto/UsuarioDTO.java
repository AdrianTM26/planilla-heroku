package com.mitocode.dto;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import com.mitocode.model.Perfil;
import com.mitocode.model.Usuario;

public class UsuarioDTO {
	
	@NotNull(message="No se ha especificado un usuario")
	@Valid
	private Usuario usuario;
	
	@NotNull(message="No se ha especificado un perfil")
	private Perfil perfil;
	
	
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	public Perfil getPerfil() {
		return perfil;
	}
	public void setPerfil(Perfil perfil) {
		this.perfil = perfil;
	}
	
}

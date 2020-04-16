package com.mitocode.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mitocode.model.Afp;
import com.mitocode.model.Perfil;
import com.mitocode.model.Usuario;
import com.mitocode.repo.UsuarioRepo;
import com.mitocode.service.IUsuarioService;

import net.bytebuddy.asm.Advice.Return;

@Service
public class UsuarioServiceImpl implements UserDetailsService, IUsuarioService{
	
	private static final Logger LOG = LoggerFactory.getLogger(UsuarioServiceImpl.class);
	
	
	@Autowired
	private UsuarioRepo repo;
	
	
	public UsuarioRepo getRepo() {
		return repo;
	}

	public void setRepo(UsuarioRepo repo) {
		this.repo = repo;
	}

	@Override
	@Transactional(readOnly=true)
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		Usuario usuario = repo.findByUsername(username);
	
		if(usuario==null) {
			UsernameNotFoundException ex = new UsernameNotFoundException("¡Error en el login: no existe el usuario '"+username+"' en el sistema!");
			LOG.error("¡Error en el login: no existe el usuario '"+username+"' en el sistema!", new RuntimeException(ex),"Fallo: "+ex.getStackTrace()[0].getClassName());
			throw ex;
		}
		
		GrantedAuthority rol = new SimpleGrantedAuthority(usuario.getPerfil().getNombres());
		List<GrantedAuthority> authorities = new ArrayList<>();
		authorities.add(rol);
		
		return new User(usuario.getUsername(), usuario.getPassword(),usuario.getEstado(), true, true, true, authorities);
	}

	@Override
	public Usuario findbyUsername(String username) {
		try {
			return repo.findByUsername(username);
		}catch(Exception e) {
			LOG.error(this.getClass().getSimpleName()+" buscarPorUsername. ERROR : "+e.getMessage());
			throw e;
		}
		
	}

	@Override
	public Usuario findbyPerfil(Perfil perfil) {
		try {
			return repo.findByPerfil(perfil);
		}catch(Exception e) {
			LOG.error(this.getClass().getSimpleName()+" buscarPorPerfil. ERROR : "+e.getMessage());
			throw e;
		}
		
	}

	@Override
	public Usuario registrar(Usuario obj) {
		try {
			return repo.save(obj);
		}catch(Exception e) {
			LOG.error(this.getClass().getSimpleName()+" registrarUsuario. ERROR : "+e.getMessage());
			throw e;
		}
	}

	@Override
	public Usuario modificar(Usuario obj) {
		try {
			return repo.save(obj);
		}catch(Exception e) {
			LOG.error(this.getClass().getSimpleName()+" actualizarUsuario. ERROR : "+e.getMessage());
			throw e;
		}
	}

	@Override
	public Usuario leer(Integer id) {
		try{
			Optional<Usuario> op = repo.findById(id);
			return op.isPresent() ? op.get() : null;
		}catch(Exception e){
			LOG.error(this.getClass().getSimpleName()+" leerUsuario. ERROR : "+e.getMessage());
			throw e;
		}
	}

	@Override
	public List<Usuario> listar() {
		try {
			return repo.findAll();
					
		}catch(Exception e) {
			LOG.error(this.getClass().getSimpleName()+" listarUsuarios. ERROR : "+e.getMessage());
			throw e;
		}
	}

	@Override
	public Boolean eliminar(Integer id) {
		try {
			Boolean resp = repo.existsById(id);
			if(resp) {
				repo.deleteById(id);
				return true;
			}else {
				return false;
			}
		}catch(Exception e) {
			LOG.error(this.getClass().getSimpleName()+" eliminarUsuario. ERROR : "+e.getMessage());
			throw e;
		}
		
	}
}

package com.mitocode.auth;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.common.DefaultOAuth2AccessToken;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.TokenEnhancer;
import org.springframework.stereotype.Component;

import com.mitocode.model.Usuario;
import com.mitocode.service.IUsuarioService;

@Component
public class InfoAdicionalToken implements TokenEnhancer{
	
	@Autowired
	private IUsuarioService usuarioService;

	@Override
	public OAuth2AccessToken enhance(OAuth2AccessToken accessToken, OAuth2Authentication authentication) {
		
		Usuario usuario = usuarioService.findbyUsername(authentication.getName());
		Map<String,Object> info = new HashMap<>();
		info.put("username", usuario.getUsername());
		info.put("correo",usuario.getEmail());
		info.put("estado", usuario.getEstado());
		info.put("id_perfil", usuario.getPerfil().getIdPerfil());
		info.put("nombre_perfil", usuario.getPerfil().getNombres());
		
		((DefaultOAuth2AccessToken) accessToken).setAdditionalInformation(info);
		return accessToken;
	}

}

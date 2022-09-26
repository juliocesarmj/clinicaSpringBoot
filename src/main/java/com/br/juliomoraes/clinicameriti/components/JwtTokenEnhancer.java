package com.br.juliomoraes.clinicameriti.components;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.common.DefaultOAuth2AccessToken;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.TokenEnhancer;
import org.springframework.stereotype.Component;

import com.br.juliomoraes.clinicameriti.model.Usuario;
import com.br.juliomoraes.clinicameriti.repository.IUsuarioRepository;
import com.br.juliomoraes.clinicameriti.services.exceptions.ObjectNotFoundException;

@Component
public class JwtTokenEnhancer implements TokenEnhancer {
	
	@Autowired
	private IUsuarioRepository userRepository;
	
	@Override
	public OAuth2AccessToken enhance(OAuth2AccessToken accessToken, OAuth2Authentication authentication) {
		
		Usuario usuario = userRepository.findByEmail(authentication.getName())
				.orElseThrow(() -> new ObjectNotFoundException("Usuário não encontrado."));
		
		Map<String, Object> map = new HashMap<>();
		map.put("usuarioId", usuario.getId());
		map.put("nome", usuario.getNomeUsuario());
		map.put("permissoes", usuario.getAuthorities());
		
		DefaultOAuth2AccessToken token = (DefaultOAuth2AccessToken) accessToken;
		token.setAdditionalInformation(map);
		
		return accessToken;
	}
}

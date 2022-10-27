package com.br.juliomoraes.clinicameriti.services.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.br.juliomoraes.clinicameriti.model.Usuario;
import com.br.juliomoraes.clinicameriti.repository.IUsuarioRepository;
import com.br.juliomoraes.clinicameriti.services.exceptions.ForbiddenException;
import com.br.juliomoraes.clinicameriti.services.exceptions.ObjectNotFoundException;
import com.br.juliomoraes.clinicameriti.services.exceptions.UnauthorizedException;

@Service
public class AuthService implements IAuthService {
	
	@Autowired
	IUsuarioRepository usuarioRepository;
	
	@Override
	public Usuario authenticated() {
		try {
			String username = SecurityContextHolder.getContext().getAuthentication().getName();
			return usuarioRepository.findByEmail(username).orElseThrow(() -> new ObjectNotFoundException("Usuário não encontrado."));
			
		} catch (Exception e) {
			throw new UnauthorizedException("Usuário inválido.");
		}
	}
	
	@Override
	public void validaUsuarioLogadoOuAdmin(Long usuarioId) {
		Usuario usuario = authenticated();
		
		if(!usuario.getId().equals(usuarioId) && !usuario.temPerfil("ROLE_ADMIN")) {
			throw new ForbiddenException("Acesso negado");
		}
	}

	@Override
	public boolean validaSeUsuarioLogadoEMedico(Usuario usuario) {
		return usuario.temPerfil("ROLE_MEDICO");
	}
}

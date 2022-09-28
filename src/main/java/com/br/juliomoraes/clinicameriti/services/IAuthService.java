package com.br.juliomoraes.clinicameriti.services;

import com.br.juliomoraes.clinicameriti.model.Usuario;

public interface IAuthService {
	
	Usuario authenticated();
	
	void validaUsuarioLogadoOuAdmin(Long usuarioId);
}

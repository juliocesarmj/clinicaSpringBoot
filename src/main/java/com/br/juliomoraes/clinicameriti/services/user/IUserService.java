package com.br.juliomoraes.clinicameriti.services.user;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.br.juliomoraes.clinicameriti.dto.usuario.UsuarioGetDTO;
import com.br.juliomoraes.clinicameriti.dto.usuario.UsuarioPostDto;

public interface IUserService {
	
	Page<UsuarioGetDTO> findAllPaged(Pageable pageable);
	
	UsuarioGetDTO findById(Long id);
	
	UsuarioGetDTO create(UsuarioPostDto dto);
	
	UsuarioGetDTO update(UsuarioGetDTO dto);
}

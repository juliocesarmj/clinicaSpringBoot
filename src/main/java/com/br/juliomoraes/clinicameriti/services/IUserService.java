package com.br.juliomoraes.clinicameriti.services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.br.juliomoraes.clinicameriti.dto.UsuarioGetDTO;
import com.br.juliomoraes.clinicameriti.dto.UsuarioPostDto;

public interface IUserService {
	
	Page<UsuarioGetDTO> findAllPaged(Pageable pageable);
	
	UsuarioGetDTO findById(Long id);
	
	UsuarioGetDTO create(UsuarioPostDto dto);
	
	UsuarioGetDTO update(UsuarioGetDTO dto);
}

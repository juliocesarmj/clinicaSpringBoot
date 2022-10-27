package com.br.juliomoraes.clinicameriti.controller;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.br.juliomoraes.clinicameriti.dto.usuario.UsuarioGetDTO;
import com.br.juliomoraes.clinicameriti.dto.usuario.UsuarioPostDto;
import com.br.juliomoraes.clinicameriti.services.user.IUserService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping(value = "/usuarios")
@RequiredArgsConstructor
@PreAuthorize("hasRole('ADMIN')")
@Api(tags = "Usuários")
public class UsuarioController {
	
	final IUserService service;
	
	@PostMapping
	@ApiOperation("Cadastro de usuarios")
	public ResponseEntity<UsuarioGetDTO> create(@Valid @RequestBody UsuarioPostDto dto) {
		return ResponseEntity.status(HttpStatus.CREATED).body(service.create(dto));
	}
}

package com.br.juliomoraes.clinicameriti.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping(value = "/medico")
@RequiredArgsConstructor
@Api(tags = "Medico")
public class RotinaMedicoController {
	
	public ResponseEntity<String> post() {
		return ResponseEntity.status(HttpStatus.CREATED).body("Agenda cancelada com sucesso");
	}
}

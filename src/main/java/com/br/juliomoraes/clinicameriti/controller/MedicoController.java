package com.br.juliomoraes.clinicameriti.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.br.juliomoraes.clinicameriti.dto.MedicoDTO;
import com.br.juliomoraes.clinicameriti.services.IMedicoService;

@RestController
@RequestMapping(value = "/medico")
public class MedicoController {

	@Autowired
	private IMedicoService service;

	@PostMapping
	public ResponseEntity<Void> novoMedico(@RequestBody final MedicoDTO dto) {
		this.service.novoMedico(dto);
		return ResponseEntity.status(HttpStatus.CREATED).body(null);
	}

	@GetMapping("/especialidades/{idEspecialidade}")
	public ResponseEntity<List<MedicoDTO>> medicosPorEspecialidade(@PathVariable final Long idEspecialidade) {
		return ResponseEntity.status(HttpStatus.OK).body(this.service.medicosPorEspecialidade(idEspecialidade));
	}

}

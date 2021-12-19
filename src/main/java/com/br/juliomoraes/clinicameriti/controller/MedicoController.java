package com.br.juliomoraes.clinicameriti.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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

	@PutMapping(value = "/{idMedico}")
	public ResponseEntity<Void> alterarMedico(@PathVariable final Long idMedico, @RequestBody final MedicoDTO dto) {
		this.service.alterarMedico(idMedico, dto);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
	}

	@GetMapping
	public ResponseEntity<List<MedicoDTO>> medicos() {
		return ResponseEntity.status(HttpStatus.OK).body(this.service.medicos());
	}

	@DeleteMapping(value = "/{idMedico}")
	public ResponseEntity<Void> excluirMedico(@PathVariable final Long idMedico) {
		this.service.excluirMedico(idMedico);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
	}

	@GetMapping(value = "/{idMedico}")
	public ResponseEntity<MedicoDTO> consultarMedico(@PathVariable final Long idMedico) {
		return ResponseEntity.status(HttpStatus.OK).body(this.service.consultarMedico(idMedico));
	}

}

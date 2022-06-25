package com.br.juliomoraes.clinicameriti.controller;

import com.br.juliomoraes.clinicameriti.dto.MedicoDTO;
import com.br.juliomoraes.clinicameriti.enums.especialidades.Especialidade;
import com.br.juliomoraes.clinicameriti.services.IMedicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "/medico")
public class MedicoController {

	@Autowired
	private IMedicoService service;

	@PostMapping
	public ResponseEntity<Void> novoMedico(@RequestBody @Valid final MedicoDTO dto) {
		this.service.novoMedico(dto);
		return ResponseEntity.status(HttpStatus.CREATED).body(null);
	}

	@GetMapping("/especialidades/{especialidade}")
	public ResponseEntity<List<MedicoDTO>> medicosPorEspecialidade(@PathVariable Especialidade especialidade) {
		return ResponseEntity.status(HttpStatus.OK).body(this.service.medicosPorEspecialidade(especialidade));
	}

	@PutMapping(value = "/{idMedico}")
	public ResponseEntity<Void> alterarMedico(@PathVariable final Long idMedico, @RequestBody final MedicoDTO dto) {
		this.service.alterarMedico(idMedico, dto);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
	}

	@GetMapping
	public ResponseEntity<List<MedicoDTO>> medicos(Pageable pageable) {
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

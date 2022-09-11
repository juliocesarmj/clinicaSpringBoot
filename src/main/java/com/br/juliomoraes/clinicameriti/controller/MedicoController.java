package com.br.juliomoraes.clinicameriti.controller;

import com.br.juliomoraes.clinicameriti.dto.MedicoDTO;
import com.br.juliomoraes.clinicameriti.dto.MedicoResponseDto;
import com.br.juliomoraes.clinicameriti.enums.especialidades.Especialidade;
import com.br.juliomoraes.clinicameriti.services.IMedicoService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "/medico")
@RequiredArgsConstructor
public class MedicoController {
	final IMedicoService service;
	@PostMapping
	public ResponseEntity<Void> novoMedico(@RequestBody @Valid final MedicoDTO dto) {
		this.service.novoMedico(dto);
		return ResponseEntity.status(HttpStatus.CREATED).body(null);
	}

	@GetMapping("/especialidades/{especialidade}")
	public ResponseEntity<List<MedicoResponseDto>> medicosPorEspecialidade(@PathVariable("especialidade") Especialidade especialidade) {
		return ResponseEntity.status(HttpStatus.OK).body(this.service.medicosPorEspecialidade(especialidade));
	}

	@PutMapping(value = "/{idMedico}")
	public ResponseEntity<Void> alterarMedico(@PathVariable("idMedico") final Long idMedico, @RequestBody final MedicoDTO dto) {
		this.service.alterarMedico(idMedico, dto);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
	}

	@GetMapping
	public ResponseEntity<List<MedicoResponseDto>> medicos() {
		return ResponseEntity.status(HttpStatus.OK).body(this.service.medicos());
	}

	@DeleteMapping(value = "/{idMedico}")
	public ResponseEntity<Void> excluirMedico(@PathVariable("idMedico") final Long idMedico) {
		this.service.excluirMedico(idMedico);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
	}

	@GetMapping(value = "/{idMedico}")
	public ResponseEntity<MedicoResponseDto> consultarMedico(@PathVariable("idMedico") final Long idMedico) {
		return ResponseEntity.ok(this.service.consultarMedico(idMedico));
	}
}

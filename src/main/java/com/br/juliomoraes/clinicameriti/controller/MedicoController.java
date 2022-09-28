package com.br.juliomoraes.clinicameriti.controller;

import com.br.juliomoraes.clinicameriti.dto.medico.MedicoDTO;
import com.br.juliomoraes.clinicameriti.dto.medico.MedicoResponseDto;
import com.br.juliomoraes.clinicameriti.services.IMedicoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "/medicos")
@RequiredArgsConstructor
@Api(tags = "Medicos")
public class MedicoController {
	
	final IMedicoService service;
	
	@ApiOperation("Serviço de cadastro de um médico")
	@PostMapping
	public ResponseEntity<Void> novoMedico(@RequestBody @Valid final MedicoDTO dto) {
		this.service.novoMedico(dto);
		return ResponseEntity.status(HttpStatus.CREATED).body(null);
	}

	@ApiOperation("Serviço de consulta de médicos por especialidade")
	@GetMapping("/especialidades/{especialidadeId}")
	public ResponseEntity<List<MedicoResponseDto>> medicosPorEspecialidade(@PathVariable("especialidadeId") final Long especialidadeId) {
		return ResponseEntity.status(HttpStatus.OK).body(this.service.medicosPorEspecialidade(especialidadeId));
	}

	@ApiOperation("Serviço de atualização dos dados de um médico por ID")
	@PutMapping(value = "/{id}")
	public ResponseEntity<Void> alterarMedico(@PathVariable("id") final Long id,@Valid @RequestBody final MedicoDTO dto) {
		this.service.alterarMedico(id, dto);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
	}

	@ApiOperation("Serviço de consulta de todos os médicos cadastrados.")
	@GetMapping
	public ResponseEntity<List<MedicoResponseDto>> medicos() {
		return ResponseEntity.status(HttpStatus.OK).body(this.service.medicos());
	}

	@ApiOperation("Serviço de consulta dos dados de um médico por ID")
	@GetMapping(value = "/{id}")
	public ResponseEntity<MedicoResponseDto> consultarMedico(@PathVariable("id") final Long id) {
		return ResponseEntity.ok(this.service.consultarMedico(id));
	}
}

package com.br.juliomoraes.clinicameriti.controller;

import java.time.LocalDate;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.br.juliomoraes.clinicameriti.dto.consulta.ConsultaPaginadaDTO;
import com.br.juliomoraes.clinicameriti.services.consulta.IConsultaService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping(value = "/medico")
@RequiredArgsConstructor
@PreAuthorize("hasRole('MEDICO')")
@Api(tags = "Medico")
public class RotinaMedicoController {

	final IConsultaService service;

	@ApiOperation("Serviço de listagem de todas as consultas agendadas. Ordenação decrescente por data de agendamento")
	@GetMapping
	public ResponseEntity<Page<ConsultaPaginadaDTO>> getConsultas(Pageable pageable) {
		return ResponseEntity.ok().body(this.service.getConsultasPaginada(pageable));
	}

	@ApiOperation("Cancela a agenda de uma data informada.")
	@PutMapping("/cancelar-agenda")
	public ResponseEntity<Void> cancelarConsultasPorData(
			@RequestParam(name = "data", required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate data,
			@RequestParam(name ="motivo", required = false) String motivo) {
		this.service.cancelarAgendaPorData(data, motivo);
		return ResponseEntity.noContent().build();
	}

}

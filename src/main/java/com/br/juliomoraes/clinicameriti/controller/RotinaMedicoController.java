package com.br.juliomoraes.clinicameriti.controller;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.br.juliomoraes.clinicameriti.dto.consulta.ConsultaPaginadaDTO;
import com.br.juliomoraes.clinicameriti.services.ConsultaService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping(value = "/medico")
@RequiredArgsConstructor
@PreAuthorize("hasRole('MEDICO')")
@Api(tags = "Medico")
public class RotinaMedicoController {
	
	final ConsultaService service;
	
	@ApiOperation("Serviço de listagem de todas as consultas agendadas. Ordenação decrescente por data de agendamento")
    @GetMapping
    public ResponseEntity<Page<ConsultaPaginadaDTO>> getConsultas(Pageable pageable) {
        return ResponseEntity.ok().body(this.service.getConsultasPaginada(pageable));
    }
}

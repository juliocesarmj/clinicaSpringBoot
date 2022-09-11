package com.br.juliomoraes.clinicameriti.controller;

import com.br.juliomoraes.clinicameriti.dto.PacienteDTO;
import com.br.juliomoraes.clinicameriti.dto.PacienteResponseDto;
import com.br.juliomoraes.clinicameriti.repository.IEnderecoRepository;
import com.br.juliomoraes.clinicameriti.services.PacienteService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(value = "/pacientes")
@RequiredArgsConstructor
@Api(tags = "Pacientes")
public class PacienteController {
    private final PacienteService service;

    @ApiOperation("Serviço de cadastro de pacientes")
    @PostMapping
    public ResponseEntity<Void> create(@RequestBody @Valid PacienteDTO dto) {
        this.service.novo(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(null);
    }

    @ApiOperation("Serviço de listagem de todos os pacientes com paginação.")
    @GetMapping
    public ResponseEntity<Page<PacienteResponseDto>> findAll(Pageable pageable) {
        return ResponseEntity.ok().body(this.service.pacientes(pageable));
    }

    @ApiOperation("Serviço de consulta de um paciente por ID")
    @GetMapping("/{id}")
    public ResponseEntity<PacienteResponseDto> findById(@PathVariable("id") Long id) {
        return ResponseEntity.ok().body(this.service.pacientePorId(id));
    }

    @ApiOperation("Serviço de consulta de um paciente por CPF")
    @GetMapping("/findbycpf/{cpf}")
    public ResponseEntity<PacienteResponseDto> findByCpf(@PathVariable String cpf) {
        return ResponseEntity.ok().body(this.service.pacientePorCpf(cpf));
    }
}

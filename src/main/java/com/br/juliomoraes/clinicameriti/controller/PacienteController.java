package com.br.juliomoraes.clinicameriti.controller;

import com.br.juliomoraes.clinicameriti.dto.PacienteDTO;
import com.br.juliomoraes.clinicameriti.repository.IEnderecoRepository;
import com.br.juliomoraes.clinicameriti.services.PacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(value = "/paciente")
public class PacienteController {

    @Autowired
    private PacienteService service;

    @Autowired
    private IEnderecoRepository enderecoRepository;

    @PostMapping
    public ResponseEntity<Void> novo(@RequestBody @Valid PacienteDTO dto) {
        this.service.novo(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(null);
    }

    @GetMapping
    public ResponseEntity<Page<PacienteDTO>> pacientes(Pageable pageable) {
        return ResponseEntity.ok().body(this.service.pacientes(pageable));
    }

    @GetMapping("/{idPaciente}")
    public ResponseEntity<PacienteDTO> pacientePorId(@PathVariable Long idPaciente) {
        return ResponseEntity.ok().body(this.service.pacientePorId(idPaciente));
    }

    @GetMapping("/pacienteporcpf/{cpf}")
    public ResponseEntity<PacienteDTO> pacientePorCpf(@PathVariable String cpf) {
        return ResponseEntity.ok().body(this.service.pacientePorCpf(cpf));
    }
}

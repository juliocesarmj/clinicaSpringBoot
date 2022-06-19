package com.br.juliomoraes.clinicameriti.controller;

import com.br.juliomoraes.clinicameriti.dto.PacienteDTO;
import com.br.juliomoraes.clinicameriti.model.endereco.Endereco;
import com.br.juliomoraes.clinicameriti.model.paciente.Paciente;
import com.br.juliomoraes.clinicameriti.repository.IEnderecoRepository;
import com.br.juliomoraes.clinicameriti.services.PacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

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
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public ResponseEntity<Page<Paciente>> pacientes(Pageable pageable) {
        return ResponseEntity.ok().body(this.service.pacientes(pageable));
    }

}

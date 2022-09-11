package com.br.juliomoraes.clinicameriti.controller;

import com.br.juliomoraes.clinicameriti.dto.ConsultaCompletaDTO;
import com.br.juliomoraes.clinicameriti.dto.ConsultaDTO;
import com.br.juliomoraes.clinicameriti.services.ConsultaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/consulta")
public class ConsultaController {

    @Autowired
    private ConsultaService service;

    @PostMapping
    public ResponseEntity<Void> novaConsulta(@RequestBody @Valid  final ConsultaDTO dto) {
        this.service.novaConsulta(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(null);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ConsultaCompletaDTO> consultaPorId(@PathVariable Long id){
        return ResponseEntity.ok().body(this.service.consultaPorId(id));
    }

    @GetMapping("/consultapornome/{nome}")
    public ResponseEntity<ConsultaCompletaDTO> findByNomePaciente(@PathVariable("nome") String nome){
        return ResponseEntity.ok().body(this.service.consultaPorNome(nome));
    }
}

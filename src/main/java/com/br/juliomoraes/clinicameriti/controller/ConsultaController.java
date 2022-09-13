package com.br.juliomoraes.clinicameriti.controller;

import com.br.juliomoraes.clinicameriti.dto.ConsultaCompletaDTO;
import com.br.juliomoraes.clinicameriti.dto.ConsultaDTO;
import com.br.juliomoraes.clinicameriti.services.ConsultaService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/consulta")
@RequiredArgsConstructor
@Api(tags = "Consultas")
public class ConsultaController {

    final ConsultaService service;

    @ApiOperation("Serviço de agendamento de uma nova consulta")
    @PostMapping
    public ResponseEntity<Void> novaConsulta(@RequestBody @Valid  final ConsultaDTO dto) {
        this.service.novaConsulta(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(null);
    }

    @ApiOperation("Serviço de consulta de um agendamento por ID")
    @GetMapping("/{id}")
    public ResponseEntity<ConsultaCompletaDTO> consultaPorId(@PathVariable("id") Long id){
        return ResponseEntity.ok().body(this.service.consultaPorId(id));
    }

    @ApiOperation("Serviço de consulta de um agendamento por nome do paciente")
    @GetMapping("/findbyname/{nome}")
    public ResponseEntity<List<ConsultaCompletaDTO>> findByNomePaciente(@PathVariable("nome") String nome){
        return ResponseEntity.ok().body(this.service.consultaPorNome(nome));
    }
}

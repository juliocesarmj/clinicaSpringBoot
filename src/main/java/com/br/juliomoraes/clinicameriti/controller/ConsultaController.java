package com.br.juliomoraes.clinicameriti.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.br.juliomoraes.clinicameriti.dto.consulta.ConsultaCompletaDTO;
import com.br.juliomoraes.clinicameriti.dto.consulta.ConsultaDTO;
import com.br.juliomoraes.clinicameriti.dto.consulta.ConsultaPaginadaDTO;
import com.br.juliomoraes.clinicameriti.dto.paciente.PacienteSimplesDTO;
import com.br.juliomoraes.clinicameriti.services.consulta.ConsultaService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/consulta")
@RequiredArgsConstructor
@PreAuthorize("hasAnyRole('ADMIN', 'ATENDENTE')")
@Api(tags = "Consultas")
public class ConsultaController {

    final ConsultaService service;
    
    //TODO - informar retorno para a consulta após agendar
    @ApiOperation("Serviço de agendamento de uma nova consulta")
    @PostMapping
    public ResponseEntity<Void> novaConsulta(@RequestBody @Valid  final ConsultaDTO dto) {
        this.service.novaConsulta(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(null);
    }

    @ApiOperation("Serviço de consulta de um agendamento por ID")
    @GetMapping("/{id}")
    public ResponseEntity<ConsultaCompletaDTO> consultaPorId(@PathVariable("id") Long id) {
        return ResponseEntity.ok().body(this.service.consultaPorId(id));
    }

    @ApiOperation("Serviço de consulta de um agendamento por nome do paciente")
    @GetMapping("/consulta-nome/{nome}")
    public ResponseEntity<List<ConsultaCompletaDTO>> findByNomePaciente(@PathVariable("nome") String nome){
        return ResponseEntity.ok().body(this.service.consultaPorNome(nome));
    }
    
    @ApiOperation("Serviço para listar consultas agendadas de um paciente por cpf")
    @GetMapping("/consultas-cpf/{cpf}")
    public ResponseEntity<PacienteSimplesDTO> findConsultasByCpf(@PathVariable("cpf") String cpf){
        return ResponseEntity.ok().body(this.service.consultasPorCpf(cpf));
    }
    
    @ApiOperation("Serviço de listagem de todas as consultas agendadas. Ordenação decrescente por data de agendamento")
    @GetMapping
    public ResponseEntity<Page<ConsultaPaginadaDTO>> getConsultas(Pageable pageable) {
        return ResponseEntity.ok().body(this.service.getConsultasPaginada(pageable));
    }
}

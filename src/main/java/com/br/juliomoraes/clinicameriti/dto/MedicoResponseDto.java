package com.br.juliomoraes.clinicameriti.dto;

import com.br.juliomoraes.clinicameriti.enums.especialidades.Especialidade;
import com.br.juliomoraes.clinicameriti.model.medico.Medico;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.time.LocalDate;

@Data
public class MedicoResponseDto {
    private Long id;
    private String nome;
    private String crm;

    @JsonFormat(pattern = "yyyy-MM-dd", shape = JsonFormat.Shape.STRING)
    private LocalDate dataNascimento;
    private Especialidade especialidade;
    private Double valorConsulta;

    public MedicoResponseDto(final Medico entidade) {
        this.id = entidade.getId();
        this.nome = entidade.getNome();
        this.crm = entidade.getCrm();
        this.dataNascimento = entidade.getDataNascimento();
        this.especialidade = entidade.getEspecialidade();
        this.valorConsulta = entidade.getValorConsulta();
    }
}

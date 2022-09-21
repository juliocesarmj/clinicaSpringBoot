package com.br.juliomoraes.clinicameriti.dto;

import com.br.juliomoraes.clinicameriti.model.Medico;
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
    private Double valorConsulta;
    private EspecialidadeDTO especialidade;

    public MedicoResponseDto(final Medico entidade) {
        this.id = entidade.getId();
        this.nome = entidade.getNome();
        this.crm = entidade.getCrm();
        this.dataNascimento = entidade.getDataNascimento();
        this.especialidade = new EspecialidadeDTO(entidade.getEspecialidade());
        this.valorConsulta = entidade.getValorConsulta();
    }
}

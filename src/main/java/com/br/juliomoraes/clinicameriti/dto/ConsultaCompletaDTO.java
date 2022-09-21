package com.br.juliomoraes.clinicameriti.dto;

import com.br.juliomoraes.clinicameriti.enums.consulta.TipoStatusConsulta;
import com.br.juliomoraes.clinicameriti.enums.consulta.TipoStatusPagamento;
import com.br.juliomoraes.clinicameriti.model.Consulta;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ConsultaCompletaDTO {

    private Long id;

    @JsonFormat(pattern = "yyyy-MM-dd", shape = JsonFormat.Shape.STRING)
    private LocalDate dataRegistroConsulta;
    private TipoStatusConsulta statusConsulta;
    private TipoStatusPagamento statusPagamento;

    @JsonFormat(pattern = "yyyy-MM-dd", shape = JsonFormat.Shape.STRING)
    private LocalDate dataAgendamento;
    private PacienteResponseDto paciente;
    private MedicoResponseDto medico;
    private String observacoesMedico;

    public static ConsultaCompletaDTO copyEntityFromDto(Consulta consulta) {
        return ConsultaCompletaDTO.builder()
                .medico(new MedicoResponseDto(consulta.getMedico()))
                .paciente(new PacienteResponseDto(consulta.getPaciente()))
                .id(consulta.getId())
                .dataRegistroConsulta(consulta.getDataRegistroConsulta())
                .statusConsulta(consulta.getStatusConsulta())
                .dataAgendamento(consulta.getDataAgendamento())
                .observacoesMedico(consulta.getObservacoesMedico())
                .statusPagamento(consulta.getStatusPagamento())
                .build();
    }
}

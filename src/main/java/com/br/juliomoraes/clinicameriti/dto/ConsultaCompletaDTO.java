package com.br.juliomoraes.clinicameriti.dto;

import com.br.juliomoraes.clinicameriti.enums.consulta.TipoStatusConsulta;
import com.br.juliomoraes.clinicameriti.enums.consulta.TipoStatusPagamento;
import com.br.juliomoraes.clinicameriti.model.consulta.Consulta;
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
    private LocalDate dataRegistroConsulta;
    private TipoStatusConsulta statusConsulta;
    private TipoStatusPagamento statusPagamento;
    private LocalDate dataAgendamento;
    private PacienteDTO paciente;
    private MedicoResponseDto medico;
    private String observacoesMedico;

    public static ConsultaCompletaDTO copyEntityFromDto(Consulta consulta) {
        return ConsultaCompletaDTO.builder()
                .medico(new MedicoResponseDto(consulta.getMedico()))
                .paciente(new PacienteDTO(consulta.getPaciente()))
                .id(consulta.getId())
                .dataRegistroConsulta(consulta.getDataRegistroConsulta())
                .statusConsulta(consulta.getStatusConsulta())
                .dataAgendamento(consulta.getDataAgendamento())
                .observacoesMedico(consulta.getObservacoesMedico())
                .statusPagamento(consulta.getStatusPagamento())
                .build();
    }
}

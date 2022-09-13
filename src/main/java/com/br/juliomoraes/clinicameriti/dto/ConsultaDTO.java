package com.br.juliomoraes.clinicameriti.dto;

import com.br.juliomoraes.clinicameriti.enums.consulta.TipoStatusConsulta;
import com.br.juliomoraes.clinicameriti.enums.consulta.TipoStatusPagamento;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ConsultaDTO {

    private Long id;
    private Long pacienteId;

    @JsonFormat(pattern = "yyyy-MM-dd", shape = JsonFormat.Shape.STRING)
    private LocalDate dataRegistroConsulta;
    private Long medicoId;
    private TipoStatusConsulta statusConsulta;
    private TipoStatusPagamento statusPagamento;

    @JsonFormat(pattern = "yyyy-MM-dd", shape = JsonFormat.Shape.STRING)
    private LocalDate dataAgendamento;
    private String observacoesMedico;

}

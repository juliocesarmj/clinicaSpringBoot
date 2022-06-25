package com.br.juliomoraes.clinicameriti.dto;

import com.br.juliomoraes.clinicameriti.enums.consulta.TipoStatusConsulta;
import com.br.juliomoraes.clinicameriti.enums.consulta.TipoStatusPagamento;
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
    private LocalDate dataRegistroConsulta;
    private Long medicoId;
    private TipoStatusConsulta statusConsulta;
    private TipoStatusPagamento statusPagamento;
    private LocalDate dataAgendamento;
    private String observacoesMedico;

}

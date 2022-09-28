package com.br.juliomoraes.clinicameriti.dto;

import java.time.LocalDate;

import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.Min;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ConsultaDTO {
	
	@Min(value = 1, message = "É Necessário informar um paciente.")
    private Long pacienteId;

    @JsonFormat(pattern = "yyyy-MM-dd", shape = JsonFormat.Shape.STRING)
    @JsonIgnore
    private LocalDate dataRegistroConsulta;
    
    @Min(value = 1, message = "É Necessário informar um medico.")
    private Long medicoId;

    @JsonFormat(pattern = "yyyy-MM-dd", shape = JsonFormat.Shape.STRING)
    @FutureOrPresent(message = "Informe uma data válida para o agendamento.")
    private LocalDate dataAgendamento;
    private String observacoesMedico;

}

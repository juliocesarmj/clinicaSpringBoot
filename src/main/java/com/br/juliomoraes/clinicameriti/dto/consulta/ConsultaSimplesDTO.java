package com.br.juliomoraes.clinicameriti.dto.consulta;

import java.math.BigDecimal;
import java.time.LocalDate;

import com.br.juliomoraes.clinicameriti.enums.consulta.TipoStatusConsulta;
import com.br.juliomoraes.clinicameriti.enums.consulta.TipoStatusPagamento;
import com.br.juliomoraes.clinicameriti.model.Consulta;
import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Data
public class ConsultaSimplesDTO {
	
	private String medico;
	private String especialidade;
	
	@JsonFormat(pattern = "yyyy-MM-dd", shape = JsonFormat.Shape.STRING)
	private LocalDate dataRegistroConsulta;
	
	@JsonFormat(pattern = "yyyy-MM-dd", shape = JsonFormat.Shape.STRING)
	private LocalDate dataAgendamento;
	private TipoStatusPagamento statusPagamento;
	private TipoStatusConsulta statusConsulta;
	private BigDecimal valorConsulta;
	
	public ConsultaSimplesDTO(Consulta consulta) {
		medico = consulta.getMedico().getNome();
		especialidade = consulta.getMedico().getEspecialidade().getNome();
		dataRegistroConsulta = consulta.getDataRegistroConsulta();
		dataAgendamento = consulta.getDataAgendamento();
		statusPagamento = consulta.getStatusPagamento();
		statusConsulta = consulta.getStatusConsulta();
		valorConsulta = BigDecimal.valueOf(consulta.getMedico().getValorConsulta());
	}
}

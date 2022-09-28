package com.br.juliomoraes.clinicameriti.enums.consulta;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum TipoStatusConsulta {
	
	AGENDADA(1, "agendada"), REAGENDADA(2, "reagendada"), CANCELADA(3, "cancelada"), CONCLUIDA(4, "concluída"),
	REAGENDAMENTO_SOLICITADO(5, "reagendamento solicitado");

	private final int index;
	private final String valor;
}

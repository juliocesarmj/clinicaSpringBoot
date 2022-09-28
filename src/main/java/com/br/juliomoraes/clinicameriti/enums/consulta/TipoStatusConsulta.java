package com.br.juliomoraes.clinicameriti.enums.consulta;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum TipoStatusConsulta {
	
	//TODO - Adicionar indice a partir de 1
	AGENDADA("agendada"), REAGENDADA("reagendada"), CANCELADA("cancelada"), CONCLUIDA("concluída");

	private final String valor;

}

package com.br.juliomoraes.clinicameriti.enums.consulta;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum TipoStatusConsulta {

	AGENDADA("agendada"), REAGENDADA("reagendada"), CANCELADA("cancelada"), CONCLUIDA("concluída");

	private String valor;

}

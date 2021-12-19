package com.br.juliomoraes.clinicameriti.dto;

import com.br.juliomoraes.clinicameriti.model.Especialidade;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class EspecialidadeDTO {

	private Long id;
	private String especialidade;

	public EspecialidadeDTO(final Especialidade entidade) {
		this.id = entidade.getId();
		this.especialidade = entidade.getEspecialidade();
	}
}

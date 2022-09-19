package com.br.juliomoraes.clinicameriti.dto;

import com.br.juliomoraes.clinicameriti.model.Perfil;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PerfilGetDTO {
	
	private Long id;
	private String authority;
	
	public PerfilGetDTO(Perfil entidade) {
		this.id = entidade.getId();
		this.authority = entidade.getAuthority();
	}
}

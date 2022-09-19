package com.br.juliomoraes.clinicameriti.dto;

import java.util.HashSet;
import java.util.Set;

import com.br.juliomoraes.clinicameriti.model.Usuario;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UsuarioGetDTO {
	
	private Long id;
	private String nomeUsuario;
	private String email;
	private Set<PerfilGetDTO> perfis = new HashSet<>();
	
	public UsuarioGetDTO(Usuario entidade) {
		this.id = entidade.getId();
		this.nomeUsuario = entidade.getNomeUsuario();
		this.email = entidade.getEmail();
		entidade.getPerfis().forEach(perfil -> this.perfis.add(new PerfilGetDTO(perfil)));
	}
}

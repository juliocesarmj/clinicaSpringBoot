package com.br.juliomoraes.clinicameriti.dto.usuario;

import java.util.HashSet;
import java.util.Set;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import com.br.juliomoraes.clinicameriti.dto.perfil.PerfilGetDTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UsuarioPostDto {
	
	@NotEmpty(message = "Informe um nome de usuário válido")
	private String nomeUsuario;
	
	@Email(message = "Informe um email válido")
	private String email;
	
	@Size(min = 6, message = "Senhas inferiores a 6 caracteres não são permitidas.")
	private String senha;
	private Set<PerfilGetDTO> perfis = new HashSet<>();
}

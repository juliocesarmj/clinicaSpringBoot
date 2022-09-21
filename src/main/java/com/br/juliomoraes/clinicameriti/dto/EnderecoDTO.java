package com.br.juliomoraes.clinicameriti.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Size;

import com.br.juliomoraes.clinicameriti.model.Endereco;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EnderecoDTO {

	private String ruaOuAvenida;
	private int numero;
	private String complemento;
	private String bairro;
	private String cidade;
	private String estado;

	@Size(min = 8, max = 8 ,message = "CEP inválido")
	private String cep;

	public static EnderecoDTO copyEntityFromDto(Endereco endereco) {
		return EnderecoDTO.builder()
				.ruaOuAvenida(endereco.getRuaOuAvenida())
				.cep(endereco.getCep())
				.bairro(endereco.getBairro())
				.complemento(endereco.getComplemento())
				.cidade(endereco.getCidade())
				.estado(endereco.getEstado())
				.numero(endereco.getNumero())
				.build();
	}
}

package com.br.juliomoraes.clinicameriti.dto;

import com.br.juliomoraes.clinicameriti.model.Endereco;
import com.br.juliomoraes.clinicameriti.model.Paciente;
import com.br.juliomoraes.clinicameriti.utils.DataUtils;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class PacienteDTO {

	private Long id;
	private String nome;
	private String email;
	private String telefone;
	private String dataNascimento;
	private String cpf;
	private EnderecoDTO enderecoDTO;

	public PacienteDTO(final Long id, final String nome, final String email, final String telefone,
			final String dataNascimento, final String cpf, final EnderecoDTO enderecoDTO) {
		super();
		this.id = id;
		this.nome = nome;
		this.email = email;
		this.telefone = telefone;
		this.dataNascimento = dataNascimento;
		this.cpf = cpf;
		this.enderecoDTO = enderecoDTO;
	}

	public PacienteDTO(final Paciente paciente) {
		this.id = paciente.getId();
		this.nome = paciente.getNome();
		this.email = paciente.getEmail();
		this.telefone = paciente.getTelefone();
		this.dataNascimento = DataUtils.dataToStringPtBr(paciente.getDataNascimento());
		this.cpf = paciente.getCpf();
		this.enderecoDTO = this.novoEndereco(paciente.getEndereco());
	}

	public EnderecoDTO novoEndereco(final Endereco endereco) {
		final EnderecoDTO dto = new EnderecoDTO();
		dto.setId(endereco.getId());
		dto.setRuaOuAvenida(endereco.getRuaOuAvenida());
		dto.setNumero(endereco.getNumero());
		dto.setComplemento(endereco.getComplemento());
		dto.setBairro(endereco.getBairro());
		dto.setCidade(endereco.getCidade());
		dto.setEstado(endereco.getEstado());
		dto.setCep(endereco.getCep());

		return dto;
	}

}

package com.br.juliomoraes.clinicameriti.dto;

import com.br.juliomoraes.clinicameriti.model.endereco.Endereco;
import com.br.juliomoraes.clinicameriti.model.paciente.Paciente;
import com.br.juliomoraes.clinicameriti.utils.DataUtils;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PacienteDTO {

	private Long id;
	private String nome;
	private String email;
	private String telefone;
	private LocalDate dataNascimento;
	private String cpf;
	private EnderecoDTO enderecoDTO;
}

package com.br.juliomoraes.clinicameriti.dto;

import com.br.juliomoraes.clinicameriti.model.paciente.Paciente;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.validation.constraints.Email;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@SuperBuilder
public class PacienteDTO {
	private String nome;
	@Email(message = "Informe um email válido")
	private String email;
	private String telefone;

	@PastOrPresent(message = "Informe uma data de nascimento válida.")
	private LocalDate dataNascimento;

	@Size(min = 11, max = 11 ,message = "Cpf inválido")
	private String cpf;
	private EnderecoDTO endereco;

	public PacienteDTO(Paciente paciente) {
		nome = paciente.getNome();
		email = paciente.getEmail();
		telefone = paciente.getTelefone();
		dataNascimento = paciente.getDataNascimento();
		cpf = paciente.getCpf();
		endereco = EnderecoDTO.copyEntityFromDto(paciente.getEndereco());
	}
}

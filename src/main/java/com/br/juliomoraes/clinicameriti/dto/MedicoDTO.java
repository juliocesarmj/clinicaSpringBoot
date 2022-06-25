package com.br.juliomoraes.clinicameriti.dto;

import com.br.juliomoraes.clinicameriti.enums.especialidades.Especialidade;
import com.br.juliomoraes.clinicameriti.model.medico.Medico;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MedicoDTO {
	private Long id;

	@NotEmpty(message = "Informe um nome válido")
	private String nome;

	@Size(min = 8, max = 8, message = "Crm inválido")
	private String crm;

	@PastOrPresent(message = "Informe uma data de nascimento válida.")
	private LocalDate dataNascimento;

	private Especialidade especialidade;

	private Double valorConsulta;

	public MedicoDTO(final Medico entidade) {
		this.id = entidade.getId();
		this.nome = entidade.getNome();
		this.crm = entidade.getCrm();
		this.dataNascimento = entidade.getDataNascimento();
		this.especialidade = entidade.getEspecialidade();
		this.valorConsulta = entidade.getValorConsulta();
	}
}

package com.br.juliomoraes.clinicameriti.dto;

import com.br.juliomoraes.clinicameriti.enums.especialidades.Especialidade;
import com.br.juliomoraes.clinicameriti.model.medico.Medico;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MedicoDTO {
	private Long id;
	private String nome;
	private String crm;
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

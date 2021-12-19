package com.br.juliomoraes.clinicameriti.dto;

import com.br.juliomoraes.clinicameriti.model.Especialidade;
import com.br.juliomoraes.clinicameriti.model.Medico;
import com.br.juliomoraes.clinicameriti.utils.DataUtils;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class MedicoDTO {

	private Long id;
	private String nome;
	private String crm;
	private String dataNascimento;

	private EspecialidadeDTO especialidade;

	public MedicoDTO(final Medico entidade) {
		this.id = entidade.getId();
		this.nome = entidade.getNome();
		this.crm = entidade.getCrm();
		this.dataNascimento = DataUtils.dataToStringPtBr(entidade.getDataNascimento());
		this.especialidade = this.novo(entidade.getEspecialidade());
	}

	public EspecialidadeDTO novo(final Especialidade entidade) {
		final EspecialidadeDTO dto = new EspecialidadeDTO();
		dto.setId(entidade.getId());
		dto.setEspecialidade(entidade.getEspecialidade());
		return dto;
	}

}

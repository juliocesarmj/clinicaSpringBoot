package com.br.juliomoraes.clinicameriti.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.br.juliomoraes.clinicameriti.dto.EspecialidadeDTO;

@Entity
@Table(name = "especialidade")
public class Especialidade implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String especialidade;

	public Especialidade() {
	}

	public Especialidade(final Long id, final String especialidade) {
		super();
		this.id = id;
		this.especialidade = especialidade;
	}

	public Especialidade(final EspecialidadeDTO dto) {
		this.id = dto.getId();
		this.especialidade = dto.getEspecialidade();
	}

	public Long getId() {
		return this.id;
	}

	public void setId(final Long id) {
		this.id = id;
	}

	public String getEspecialidade() {
		return this.especialidade;
	}

	public void setEspecialidade(final String especialidade) {
		this.especialidade = especialidade;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((this.id == null) ? 0 : this.id.hashCode());
		return result;
	}

	@Override
	public boolean equals(final Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (this.getClass() != obj.getClass())
			return false;
		final Especialidade other = (Especialidade) obj;
		if (this.id == null) {
			if (other.id != null)
				return false;
		} else if (!this.id.equals(other.id))
			return false;
		return true;
	}
}

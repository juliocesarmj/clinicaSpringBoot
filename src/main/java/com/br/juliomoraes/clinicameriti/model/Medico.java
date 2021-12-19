package com.br.juliomoraes.clinicameriti.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "medico")
public class Medico implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nome;
	private String crm;
	private Date dataNascimento;

	@OneToOne
	@JoinColumn(name = "id_especialidade")
	private Especialidade especialidade;

	public Medico() {
	}

	public Medico(final Long id, final String nome, final String crm, final Date dataNascimento,
			final Especialidade especialidade) {
		this.id = id;
		this.nome = nome;
		this.crm = crm;
		this.dataNascimento = dataNascimento;
		this.especialidade = especialidade;
	}

	public Long getId() {
		return this.id;
	}

	public void setId(final Long id) {
		this.id = id;
	}

	public String getNome() {
		return this.nome;
	}

	public void setNome(final String nome) {
		this.nome = nome;
	}

	public String getCrm() {
		return this.crm;
	}

	public void setCrm(final String crm) {
		this.crm = crm;
	}

	public Date getDataNascimento() {
		return this.dataNascimento;
	}

	public void setDataNascimento(final Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public Especialidade getEspecialidade() {
		return this.especialidade;
	}

	public void setEspecialidade(final Especialidade especialidade) {
		this.especialidade = especialidade;
	}
}

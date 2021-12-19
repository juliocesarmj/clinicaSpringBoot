package com.br.juliomoraes.clinicameriti.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "paciente")
public class Paciente implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false, unique = false, length = 220)
	private String nome;

	@Column(nullable = true, unique = true, length = 100)
	private String email;

	@Column(nullable = false, unique = true, length = 11)
	private String telefone;

	@Column(nullable = false, unique = false, length = 100)
	private Date dataNascimento;

	@Column(nullable = false, unique = true, length = 11)
	private String cpf;

	@ManyToOne
	@JoinColumn(name = "id_endereco")
	private Endereco endereco;

	public Paciente() {
	}

	public Paciente(final Long id, final String nome, final String email, final String telefone,
			final Date dataNascimento, final String cpf) {
		super();
		this.id = id;
		this.nome = nome;
		this.email = email;
		this.telefone = telefone;
		this.dataNascimento = dataNascimento;
		this.cpf = cpf;
	}

	public Paciente(final Long id, final String nome, final String email, final String telefone,
			final Date dataNascimento, final String cpf, final Endereco endereco) {
		super();
		this.id = id;
		this.nome = nome;
		this.email = email;
		this.telefone = telefone;
		this.dataNascimento = dataNascimento;
		this.cpf = cpf;
		this.endereco = endereco;
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

	public String getEmail() {
		return this.email;
	}

	public void setEmail(final String email) {
		this.email = email;
	}

	public String getTelefone() {
		return this.telefone;
	}

	public void setTelefone(final String telefone) {
		this.telefone = telefone;
	}

	public Date getDataNascimento() {
		return this.dataNascimento;
	}

	public void setDataNascimento(final Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public String getCpf() {
		return this.cpf;
	}

	public void setCpf(final String cpf) {
		this.cpf = cpf;
	}

	public Endereco getEndereco() {
		return this.endereco;
	}

	public void setEndereco(final Endereco endereco) {
		this.endereco = endereco;
	}
}

package com.br.juliomoraes.clinicameriti.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "endereco")
public class Endereco implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false, unique = false, length = 100)
	private String ruaOuAvenida;

	@Column(nullable = false, unique = false, length = 10)
	private int numero;

	@Column(nullable = true, unique = false, length = 200)
	private String complemento;

	@Column(nullable = false, unique = false, length = 200)
	private String bairro;

	@Column(nullable = false, unique = false, length = 200)
	private String cidade;

	@Column(nullable = false, unique = false, length = 200)
	private String estado;

	@Column(nullable = false, unique = false, length = 8)
	private String cep;

	public Endereco() {
	}

	public Endereco(final Long id, final String ruaOuAvenida, final int numero, final String complemento,
			final String bairro, final String cidade, final String estado, final String cep) {
		super();
		this.id = id;
		this.ruaOuAvenida = ruaOuAvenida;
		this.numero = numero;
		this.complemento = complemento;
		this.bairro = bairro;
		this.cidade = cidade;
		this.estado = estado;
		this.cep = cep;
	}

	public Long getId() {
		return this.id;
	}

	public void setId(final Long id) {
		this.id = id;
	}

	public String getRuaOuAvenida() {
		return this.ruaOuAvenida;
	}

	public void setRuaOuAvenida(final String ruaOuAvenida) {
		this.ruaOuAvenida = ruaOuAvenida;
	}

	public int getNumero() {
		return this.numero;
	}

	public void setNumero(final int numero) {
		this.numero = numero;
	}

	public String getComplemento() {
		return this.complemento;
	}

	public void setComplemento(final String complemento) {
		this.complemento = complemento;
	}

	public String getBairro() {
		return this.bairro;
	}

	public void setBairro(final String bairro) {
		this.bairro = bairro;
	}

	public String getCidade() {
		return this.cidade;
	}

	public void setCidade(final String cidade) {
		this.cidade = cidade;
	}

	public String getEstado() {
		return this.estado;
	}

	public void setEstado(final String estado) {
		this.estado = estado;
	}

	public String getCep() {
		return this.cep;
	}

	public void setCep(final String cep) {
		this.cep = cep;
	}
}

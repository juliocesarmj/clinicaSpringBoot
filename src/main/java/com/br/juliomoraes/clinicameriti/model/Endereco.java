package com.br.juliomoraes.clinicameriti.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.br.juliomoraes.clinicameriti.dto.paciente.EnderecoDTO;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "endereco")
@AllArgsConstructor
@NoArgsConstructor
public class Endereco implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false, length = 100)
	private String ruaOuAvenida;

	@Column(nullable = false, length = 10)
	private int numero;

	@Column(nullable = true, length = 200)
	private String complemento;

	@Column(nullable = false, length = 200)
	private String bairro;

	@Column(nullable = false, length = 200)
	private String cidade;

	@Column(nullable = false, length = 200)
	private String estado;

	@Column(nullable = false, length = 8)
	private String cep;

	@OneToMany(mappedBy = "endereco")
	@JsonIgnore
	private List<Paciente> pacientes = new ArrayList<>();

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getRuaOuAvenida() {
		return ruaOuAvenida;
	}

	public void setRuaOuAvenida(String ruaOuAvenida) {
		this.ruaOuAvenida = ruaOuAvenida;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}
	public List<Paciente> getPacientes() {
		return pacientes;
	}
	public static Endereco novo(EnderecoDTO dto) {
		Endereco endereco = new Endereco();
		endereco.setBairro(dto.getBairro());
		endereco.setCep(dto.getCep());
		endereco.setCidade(dto.getCidade());
		endereco.setComplemento(dto.getComplemento());
		endereco.setEstado(dto.getEstado());
		endereco.setNumero(dto.getNumero());
		endereco.setRuaOuAvenida(dto.getRuaOuAvenida());
		return endereco;
	}
}

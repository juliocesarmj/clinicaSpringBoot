package com.br.juliomoraes.clinicameriti.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.br.juliomoraes.clinicameriti.dto.paciente.EnderecoDTO;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "endereco")
@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
public class Endereco implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_endereco")
	@SequenceGenerator(name = "seq_endereco", sequenceName = "endereco_sequence")
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
	private List<Paciente> pacientes;

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

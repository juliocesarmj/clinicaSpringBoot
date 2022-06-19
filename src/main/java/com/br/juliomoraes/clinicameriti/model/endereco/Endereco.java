package com.br.juliomoraes.clinicameriti.model.endereco;

import com.br.juliomoraes.clinicameriti.dto.EnderecoDTO;
import com.br.juliomoraes.clinicameriti.model.paciente.Paciente;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "endereco")
@AllArgsConstructor
@Data
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

	@Column(nullable = false)
	@OneToMany(mappedBy = "endereco")
	private List<Paciente> pacientes = new ArrayList<>();

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

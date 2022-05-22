package com.br.juliomoraes.clinicameriti.model.endereco;

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
@Builder
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
}

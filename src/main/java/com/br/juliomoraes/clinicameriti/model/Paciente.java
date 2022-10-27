package com.br.juliomoraes.clinicameriti.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.br.juliomoraes.clinicameriti.dto.paciente.PacienteDTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "paciente")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Paciente {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_paciente")
	@SequenceGenerator(name = "seq_paciente", sequenceName = "paciente_sequence")
	private Long id;

	@Column(nullable = false, length = 225)
	private String nome;

	@Column(unique = true, length = 50)
	private String email;

	@Column(nullable = false, unique = true, length = 20)
	private String telefone;

	@Column(nullable = false, unique = false, length = 12)
	private LocalDate dataNascimento;

	@Column(nullable = false, unique = true, length = 11)
	private String cpf;
	
	@ManyToOne
	@JoinColumn(name = "endereco_id")
	private Endereco endereco;

	@OneToMany(mappedBy = "paciente")
	private List<Consulta> consultas = new ArrayList<>();

	public static Paciente novo(PacienteDTO dto) {
		Paciente paciente = new Paciente();
		paciente.setNome(dto.getNome());
		paciente.setCpf(dto.getCpf());
		paciente.setEmail(dto.getEmail());
		paciente.setDataNascimento(dto.getDataNascimento());
		paciente.setTelefone(dto.getTelefone());
		return paciente;
	}
}

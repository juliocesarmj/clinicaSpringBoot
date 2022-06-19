package com.br.juliomoraes.clinicameriti.model.paciente;

import com.br.juliomoraes.clinicameriti.dto.PacienteDTO;
import com.br.juliomoraes.clinicameriti.model.endereco.Endereco;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "paciente")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Paciente {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
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

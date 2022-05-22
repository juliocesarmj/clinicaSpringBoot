package com.br.juliomoraes.clinicameriti.model.medico;

import com.br.juliomoraes.clinicameriti.enums.especialidades.Especialidade;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "medico")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Medico {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nome;
	private String crm;
	private LocalDate dataNascimento;
	private Especialidade especialidade;
	private Double valorConsulta;
}

package com.br.juliomoraes.clinicameriti.model;

import com.br.juliomoraes.clinicameriti.dto.ConsultaDTO;
import com.br.juliomoraes.clinicameriti.enums.consulta.TipoStatusConsulta;
import com.br.juliomoraes.clinicameriti.enums.consulta.TipoStatusPagamento;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "consulta")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Consulta {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne
	@JoinColumn(name = "paciente_id")
	private Paciente paciente;

	private LocalDate dataRegistroConsulta;

	@ManyToOne
	@JoinColumn(name = "medico_id")
	private Medico medico;

	@Enumerated(EnumType.STRING)
	@Column(nullable = false)
	private TipoStatusConsulta statusConsulta;

	@Enumerated(EnumType.STRING)
	@Column(nullable = false)
	private TipoStatusPagamento statusPagamento;

	@Column(nullable = false)
	private LocalDate dataAgendamento;

	@Column(columnDefinition = "TEXT")
	private String observacoesMedico;

	public static Consulta novo(ConsultaDTO dto, Paciente paciente, Medico medico) {
		Consulta consulta = new Consulta();
		consulta.setDataRegistroConsulta(LocalDate.now());
		consulta.setDataAgendamento(dto.getDataAgendamento());
		consulta.setStatusConsulta(dto.getStatusConsulta());
		consulta.setStatusPagamento(dto.getStatusPagamento());
		consulta.setObservacoesMedico(dto.getObservacoesMedico());
		consulta.setPaciente(paciente);
		consulta.setMedico(medico);
		return consulta;
	}
}

package com.br.juliomoraes.clinicameriti.model.consulta;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.br.juliomoraes.clinicameriti.enums.consulta.TipoStatusConsulta;
import com.br.juliomoraes.clinicameriti.enums.consulta.TipoStatusPagamento;
import com.br.juliomoraes.clinicameriti.model.medico.Medico;
import com.br.juliomoraes.clinicameriti.model.paciente.Paciente;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "consulta")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Consulta {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne
	@JoinColumn(name = "id_paciente")
	private Paciente paciente;

	private LocalDate registroConsulta;

	@ManyToOne
	@JoinColumn(name = "id_medico")
	private Medico medico;

	@Enumerated(EnumType.STRING)
	@Column(nullable = false)
	private TipoStatusConsulta statusConsulta;

	@Enumerated(EnumType.STRING)
	@Column(nullable = false, columnDefinition = "Aguardando pagamento")
	private TipoStatusPagamento statusPagamento;

	@Column(nullable = false)
	private LocalDate dataAgendamento;

	private String observacoesMedico;
}

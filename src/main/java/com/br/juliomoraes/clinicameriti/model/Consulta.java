package com.br.juliomoraes.clinicameriti.model;

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
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.br.juliomoraes.clinicameriti.dto.consulta.ConsultaDTO;
import com.br.juliomoraes.clinicameriti.enums.consulta.TipoStatusConsulta;
import com.br.juliomoraes.clinicameriti.enums.consulta.TipoStatusPagamento;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "consulta")
@Getter
@Setter(value = AccessLevel.PROTECTED)
@NoArgsConstructor
@AllArgsConstructor
public class Consulta {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_consulta")
	@SequenceGenerator(name = "seq_consulta", sequenceName = "consulta_sequence")
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
	
	private LocalDate dataReagendamentoSolicitado;
	
	@ManyToOne
	@JoinColumn(name = "usuarioId", nullable = false)
	private Usuario usuario;

	public static Consulta novo(ConsultaDTO dto, Paciente paciente, Medico medico) {
		Consulta consulta = new Consulta();
		consulta.setDataRegistroConsulta(LocalDate.now());
		consulta.setDataAgendamento(dto.getDataAgendamento());
		consulta.setStatusConsulta(TipoStatusConsulta.AGENDADA);
		consulta.setStatusPagamento(TipoStatusPagamento.AGUARDANDO_PAGAMENTO);
		consulta.setObservacoesMedico(dto.getObservacoesMedico());
		consulta.setPaciente(paciente);
		consulta.setMedico(medico);
		return consulta;
	}
	
	public void solicitarReagendamento(String motivoSolicitacaoReagendamento) {
		this.setStatusConsulta(TipoStatusConsulta.REAGENDAMENTO_SOLICITADO);
		this.setObservacoesMedico(motivoSolicitacaoReagendamento == null ? "motivos pessoais." : motivoSolicitacaoReagendamento);
		this.setDataReagendamentoSolicitado(LocalDate.now());
	}
	
	public void adicionarUsuario(Usuario usuario) {
		this.setUsuario(usuario);
	}
}

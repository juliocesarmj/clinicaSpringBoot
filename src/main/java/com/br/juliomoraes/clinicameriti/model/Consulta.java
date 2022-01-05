package com.br.juliomoraes.clinicameriti.model;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

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

@Entity
@Table(name = "consulta")
public class Consulta implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne
	@JoinColumn(name = "id_paciente")
	private Paciente paciente;

	private Date registroConsulta;

	@ManyToOne
	@JoinColumn(name = "id_especialidade")
	private Especialidade especialidade;

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
	private Date dataAgendamento;

	@Column(nullable = false)
	private Double valorConsulta;

	private String observacoesMedico;

	public Consulta() {
	}

	public Consulta(final Long id, final Paciente paciente, final Date registroConsulta,
			final Especialidade especialidade, final Medico medico, final TipoStatusConsulta statusConsulta,
			final TipoStatusPagamento statusPagamento, final Date dataAgendamento, final Double valorConsulta) {
		super();
		this.id = id;
		this.paciente = paciente;
		this.registroConsulta = registroConsulta;
		this.especialidade = especialidade;
		this.medico = medico;
		this.statusConsulta = statusConsulta;
		this.statusPagamento = statusPagamento;
		this.dataAgendamento = dataAgendamento;
		this.valorConsulta = valorConsulta;
	}

	public Consulta(final Long id, final Paciente paciente, final Date registroConsulta,
			final Especialidade especialidade, final Medico medico, final TipoStatusConsulta statusConsulta,
			final TipoStatusPagamento statusPagamento, final Date dataAgendamento, final Double valorConsulta,
			final String observacoesMedico) {
		super();
		this.id = id;
		this.paciente = paciente;
		this.registroConsulta = registroConsulta;
		this.especialidade = especialidade;
		this.medico = medico;
		this.statusConsulta = statusConsulta;
		this.statusPagamento = statusPagamento;
		this.dataAgendamento = dataAgendamento;
		this.valorConsulta = valorConsulta;
		this.observacoesMedico = observacoesMedico;
	}

	public Long getId() {
		return this.id;
	}

	public void setId(final Long id) {
		this.id = id;
	}

	public Paciente getPaciente() {
		return this.paciente;
	}

	public void setPaciente(final Paciente paciente) {
		this.paciente = paciente;
	}

	public Date getRegistroConsulta() {
		return this.registroConsulta;
	}

	public void setRegistroConsulta(final Date registroConsulta) {
		this.registroConsulta = registroConsulta;
	}

	public Especialidade getEspecialidade() {
		return this.especialidade;
	}

	public void setEspecialidade(final Especialidade especialidade) {
		this.especialidade = especialidade;
	}

	public Medico getMedico() {
		return this.medico;
	}

	public void setMedico(final Medico medico) {
		this.medico = medico;
	}

	public TipoStatusConsulta getStatusConsulta() {
		return this.statusConsulta;
	}

	public void setStatusConsulta(final TipoStatusConsulta statusConsulta) {
		this.statusConsulta = statusConsulta;
	}

	public TipoStatusPagamento getStatusPagamento() {
		return this.statusPagamento;
	}

	public void setStatusPagamento(final TipoStatusPagamento statusPagamento) {
		this.statusPagamento = statusPagamento;
	}

	public Date getDataAgendamento() {
		return this.dataAgendamento;
	}

	public void setDataAgendamento(final Date dataAgendamento) {
		this.dataAgendamento = dataAgendamento;
	}

	public Double getValorConsulta() {
		return this.valorConsulta;
	}

	public void setValorConsulta(final Double valorConsulta) {
		this.valorConsulta = valorConsulta;
	}

	public String getObservacoesMedico() {
		return this.observacoesMedico;
	}

	public void setObservacoesMedico(final String observacoesMedico) {
		this.observacoesMedico = observacoesMedico;
	}

	@Override
	public int hashCode() {
		return Objects.hash(this.id);
	}

	@Override
	public boolean equals(final Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (this.getClass() != obj.getClass())
			return false;
		final Consulta other = (Consulta) obj;
		return Objects.equals(this.id, other.id);
	}
}

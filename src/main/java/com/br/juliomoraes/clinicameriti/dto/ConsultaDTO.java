package com.br.juliomoraes.clinicameriti.dto;

import com.br.juliomoraes.clinicameriti.enums.consulta.TipoStatusConsulta;
import com.br.juliomoraes.clinicameriti.enums.consulta.TipoStatusPagamento;
import com.br.juliomoraes.clinicameriti.model.Consulta;
import com.br.juliomoraes.clinicameriti.model.Especialidade;
import com.br.juliomoraes.clinicameriti.model.Medico;
import com.br.juliomoraes.clinicameriti.model.Paciente;
import com.br.juliomoraes.clinicameriti.utils.DataUtils;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ConsultaDTO {

	private Long id;
	private PacienteDTO pacienteDTO;
	private String registroConsulta;
	private EspecialidadeDTO especialidadeDTO;
	private MedicoDTO medicoDTO;
	private TipoStatusConsulta statusConsulta;
	private TipoStatusPagamento statusPagamento;
	private String dataAgendamento;
	private Double valorConsulta;
	private String observacoesMedico;

	public ConsultaDTO(final Long id, final PacienteDTO pacienteDTO, final String registroConsulta,
			final EspecialidadeDTO especialidadeDTO, final MedicoDTO medicoDTO, final TipoStatusConsulta statusConsulta,
			final TipoStatusPagamento statusPagamento, final String dataAgendamento, final Double valorConsulta,
			final String observacoesMedico) {
		super();
		this.id = id;
		this.pacienteDTO = pacienteDTO;
		this.registroConsulta = registroConsulta;
		this.especialidadeDTO = especialidadeDTO;
		this.medicoDTO = medicoDTO;
		this.statusConsulta = statusConsulta;
		this.statusPagamento = statusPagamento;
		this.dataAgendamento = dataAgendamento;
		this.valorConsulta = valorConsulta;
		this.observacoesMedico = observacoesMedico;
	}

	public ConsultaDTO(final Consulta consulta) {
		this.id = consulta.getId();
		this.pacienteDTO = this.novoPaciente(consulta.getPaciente());
		this.registroConsulta = DataUtils.dataToStringPtBr(consulta.getRegistroConsulta());
		this.especialidadeDTO = this.novaEspecialidade(consulta.getEspecialidade());
		this.medicoDTO = this.novoMedico(consulta.getMedico());
		this.statusConsulta = consulta.getStatusConsulta();
		this.statusPagamento = consulta.getStatusPagamento();
		this.dataAgendamento = DataUtils.dataToStringPtBr(consulta.getDataAgendamento());
		this.valorConsulta = consulta.getValorConsulta();
		this.observacoesMedico = consulta.getObservacoesMedico();
	}

	public PacienteDTO novoPaciente(final Paciente paciente) {
		final PacienteDTO dto = new PacienteDTO();
		dto.setId(paciente.getId());
		dto.setNome(paciente.getNome());
		dto.setEmail(paciente.getEmail());
		dto.setTelefone(paciente.getTelefone());
		dto.setDataNascimento(DataUtils.dataToStringPtBr(paciente.getDataNascimento()));
		dto.setCpf(paciente.getCpf());
		dto.novoEndereco(paciente.getEndereco());
		return dto;
	}

	public EspecialidadeDTO novaEspecialidade(final Especialidade especialidade) {
		final EspecialidadeDTO dto = new EspecialidadeDTO();
		dto.setId(especialidade.getId());
		dto.setEspecialidade(especialidade.getEspecialidade());
		return dto;
	}

	public MedicoDTO novoMedico(final Medico medico) {
		final MedicoDTO dto = new MedicoDTO();
		dto.setId(medico.getId());
		dto.setNome(medico.getNome());
		dto.setCrm(medico.getCrm());
		dto.setDataNascimento(DataUtils.dataToStringPtBr(medico.getDataNascimento()));
		dto.setEspecialidade(this.novaEspecialidade(medico.getEspecialidade()));
		return dto;
	}
}

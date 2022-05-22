package com.br.juliomoraes.clinicameriti.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.br.juliomoraes.clinicameriti.model.consulta.Consulta;

public interface IConsultaRepository extends JpaRepository<Consulta, Long> {

	List<Consulta> findByMedicoId(final Long medicoId);

	List<Consulta> findByMedicoNome(final String medicoNome);

	@Query("FROM Consulta consulta JOIN consulta.paciente JOIN consulta.medico where consulta.paciente.nome = :nomePaciente")
	List<Consulta> consultasPorNomePaciente(@Param("nomePaciente") String nomePaciente);

	@Query("FROM Consulta consulta JOIN consulta.paciente JOIN consulta.medico where consulta.paciente.cpf = :cpfPaciente")
	List<Consulta> consultasPorCpfPaciente(@Param("cpfPaciente") String cpfPaciente);

	@Query("FROM Consulta consulta JOIN consulta.paciente JOIN consulta.medico where consulta.paciente.nome = :nomePaciente"
			+ " AND consulta.medico.nome = :nomeMedico")
	Consulta consultaNomePacienteNomeMedico(@Param("nomePaciente") final String nomePaciente,
			@Param("nomeMedico") final String nomeMedico);
}

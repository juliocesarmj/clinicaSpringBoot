package com.br.juliomoraes.clinicameriti.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.br.juliomoraes.clinicameriti.model.Consulta;

public interface IConsultaRepository extends JpaRepository<Consulta, Long> {
	
    List<Consulta> findByPacienteNomeContainingIgnoreCase(String nome);
    
    @Query("SELECT obj FROM Consulta obj JOIN obj.paciente pac "
    		+ "WHERE pac.cpf = :cpf "
    		+ "AND obj.dataAgendamento >= :dataAtual")
    List<Consulta> findByPacienteCpf(@Param("cpf") String cpf, @Param("dataAtual") LocalDate dataAtual);
    
    Page<Consulta> findAllByMedicoIdOrderByDataRegistroConsultaDesc(Pageable pageable, Long medicoId);
    
    List<Consulta> findAllByDataAgendamentoAndMedicoId(LocalDate dataAgendamento, Long medicoId);
}

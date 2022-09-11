package com.br.juliomoraes.clinicameriti.repository;

import com.br.juliomoraes.clinicameriti.model.consulta.Consulta;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface IConsultaRepository extends JpaRepository<Consulta, Long> {
    Optional<Consulta> findByPaciente_Nome(String nome);
}

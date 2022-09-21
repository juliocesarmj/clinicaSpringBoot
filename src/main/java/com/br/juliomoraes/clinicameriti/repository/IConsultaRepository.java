package com.br.juliomoraes.clinicameriti.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.br.juliomoraes.clinicameriti.model.Consulta;

import java.util.List;
import java.util.Optional;

public interface IConsultaRepository extends JpaRepository<Consulta, Long> {
    List<Consulta> findByPacienteNomeContainingIgnoreCase(String nome);
}

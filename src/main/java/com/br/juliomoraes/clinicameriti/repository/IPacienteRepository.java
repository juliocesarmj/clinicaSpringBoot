package com.br.juliomoraes.clinicameriti.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.br.juliomoraes.clinicameriti.model.paciente.Paciente;

public interface IPacienteRepository extends JpaRepository<Paciente, Long> {
    Paciente findByCpf(String cpf);
}

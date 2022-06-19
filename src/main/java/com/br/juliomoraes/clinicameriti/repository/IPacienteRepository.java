package com.br.juliomoraes.clinicameriti.repository;

import com.br.juliomoraes.clinicameriti.model.paciente.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface IPacienteRepository extends JpaRepository<Paciente, Long> {
    Paciente findByCpf(String cpf);

    Paciente findByEmail(String email);

    Paciente findByTelefone(String telefone);

    @Query("SELECT obj FROM Paciente obj where obj.cpf = :cpf")
    Optional<Paciente> findByCpfOptional(String cpf);
}

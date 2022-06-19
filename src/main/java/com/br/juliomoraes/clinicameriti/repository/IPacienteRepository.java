package com.br.juliomoraes.clinicameriti.repository;

import com.br.juliomoraes.clinicameriti.model.endereco.Endereco;
import com.br.juliomoraes.clinicameriti.model.paciente.Paciente;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface IPacienteRepository extends JpaRepository<Paciente, Long> {
    Paciente findByCpf(String cpf);

    Paciente findByEmail(String email);

    Paciente findByTelefone(String telefone);

}

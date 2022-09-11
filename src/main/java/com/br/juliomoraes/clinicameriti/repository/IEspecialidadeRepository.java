package com.br.juliomoraes.clinicameriti.repository;

import com.br.juliomoraes.clinicameriti.model.especialidade.Especialidade;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IEspecialidadeRepository extends JpaRepository<Especialidade, Long> {
}

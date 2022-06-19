package com.br.juliomoraes.clinicameriti.repository;

import com.br.juliomoraes.clinicameriti.model.endereco.Endereco;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IEnderecoRepository extends JpaRepository<Endereco, Long> {
}

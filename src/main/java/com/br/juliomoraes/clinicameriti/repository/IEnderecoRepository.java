package com.br.juliomoraes.clinicameriti.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.br.juliomoraes.clinicameriti.model.endereco.Endereco;

public interface IEnderecoRepository extends JpaRepository<Endereco, Long> {

}

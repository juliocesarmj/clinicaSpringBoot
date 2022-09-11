package com.br.juliomoraes.clinicameriti.repository;

import com.br.juliomoraes.clinicameriti.model.endereco.Endereco;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface IEnderecoRepository extends JpaRepository<Endereco, Long> {

    @Query("SELECT endereco FROM Endereco endereco WHERE endereco.bairro = :bairro" +
            " AND endereco.cep = :cep" +
            " AND (endereco.complemento = :complemento OR endereco.numero = :numero)" +
            " AND endereco.ruaOuAvenida = :rua")
    Endereco findEnderecoByParams(String rua, int numero, String cep, String complemento, String bairro);
}

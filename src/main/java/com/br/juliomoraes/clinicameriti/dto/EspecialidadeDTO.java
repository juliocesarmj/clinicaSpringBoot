package com.br.juliomoraes.clinicameriti.dto;

import com.br.juliomoraes.clinicameriti.model.Especialidade;

import lombok.Data;

@Data
public class EspecialidadeDTO {

    private long id;
    private String nome;

    public EspecialidadeDTO(Especialidade entidade) {
        this.id = entidade.getId();
        this.nome = entidade.getNome();
    }
}

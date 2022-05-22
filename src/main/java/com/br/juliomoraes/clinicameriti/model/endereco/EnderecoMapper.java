package com.br.juliomoraes.clinicameriti.model.endereco;

import com.br.juliomoraes.clinicameriti.dto.EnderecoDTO;
import com.br.juliomoraes.clinicameriti.enums.excecoes.mensagens.MessageException;

public class EnderecoMapper {

    public EnderecoMapper() {
        throw new IllegalArgumentException(String.valueOf(MessageException.CLASSE_NAO_PODE_INSTANCIAR));
    }

    public static Endereco copyDtoFromEntity(EnderecoDTO dto) {
        return Endereco.builder()
                .ruaOuAvenida(dto.getRuaOuAvenida())
                .bairro(dto.getBairro())
                .cep(dto.getCep())
                .cidade(dto.getCidade())
                .complemento(dto.getComplemento())
                .numero(dto.getNumero())
                .estado(dto.getEstado())
                .build();
    }
}

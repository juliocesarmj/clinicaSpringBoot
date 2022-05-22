package com.br.juliomoraes.clinicameriti.model.paciente;

import com.br.juliomoraes.clinicameriti.dto.PacienteDTO;
import com.br.juliomoraes.clinicameriti.enums.excecoes.mensagens.MessageException;
import com.br.juliomoraes.clinicameriti.model.endereco.EnderecoMapper;

public class PacienteMapper {

    public PacienteMapper() {
        throw new IllegalArgumentException(String.valueOf(MessageException.CLASSE_NAO_PODE_INSTANCIAR));
    }

    public static Paciente copyDtoFromEntity(PacienteDTO dto) {
        return Paciente.builder()
                .nome(dto.getNome())
                .cpf(dto.getCpf())
                .dataNascimento(dto.getDataNascimento())
                .email(dto.getEmail())
                .telefone(dto.getTelefone())
                .endereco(EnderecoMapper.copyDtoFromEntity(dto.getEnderecoDTO()))
                .build();
    }
}

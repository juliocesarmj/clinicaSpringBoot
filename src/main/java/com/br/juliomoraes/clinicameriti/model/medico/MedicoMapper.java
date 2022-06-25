package com.br.juliomoraes.clinicameriti.model.medico;

import com.br.juliomoraes.clinicameriti.dto.MedicoDTO;

public class MedicoMapper {

    public MedicoMapper() {
    }

    public static Medico copyDtoFromEntity(MedicoDTO dto) {
        return Medico.builder()
                .id(dto.getId())
                .nome(dto.getNome())
                .crm(dto.getCrm())
                .valorConsulta(dto.getValorConsulta())
                .dataNascimento(dto.getDataNascimento())
                .especialidade(dto.getEspecialidade())
                .build();
    }
}

package com.br.juliomoraes.clinicameriti.model.medico;

import com.br.juliomoraes.clinicameriti.dto.medico.MedicoDTO;
import com.br.juliomoraes.clinicameriti.model.Medico;

public class MedicoMapper {

    public MedicoMapper() {
    }

    public static Medico copyDtoFromEntity(MedicoDTO dto) {
        return Medico.builder()
                .nome(dto.getNome())
                .crm(dto.getCrm())
                .valorConsulta(dto.getValorConsulta())
                .dataNascimento(dto.getDataNascimento())
                .build();
    }
}

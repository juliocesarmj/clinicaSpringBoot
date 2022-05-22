package com.br.juliomoraes.clinicameriti.model.consulta;

import com.br.juliomoraes.clinicameriti.dto.ConsultaDTO;
import com.br.juliomoraes.clinicameriti.enums.excecoes.mensagens.MessageException;
import com.br.juliomoraes.clinicameriti.model.paciente.Paciente;
import com.br.juliomoraes.clinicameriti.model.medico.MedicoMapper;

import java.time.LocalDate;

public class ConsultaMapper {

    public ConsultaMapper() {
        throw new IllegalArgumentException(String.valueOf(MessageException.CLASSE_NAO_PODE_INSTANCIAR));
    }

    public static Consulta copyDtoFromEntity(ConsultaDTO dto) {
        return Consulta.builder()
                .registroConsulta(LocalDate.now())
                .statusConsulta(dto.getStatusConsulta())
                .dataAgendamento(dto.getDataAgendamento())
                .observacoesMedico(dto.getObservacoesMedico())
                .statusPagamento(dto.getStatusPagamento())
                .medico(MedicoMapper.copyDtoFromEntity(dto.getMedicoDTO()))
                .paciente(new Paciente())
                .build();
    }
}

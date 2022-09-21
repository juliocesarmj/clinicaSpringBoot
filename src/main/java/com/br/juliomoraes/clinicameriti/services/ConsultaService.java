package com.br.juliomoraes.clinicameriti.services;

import com.br.juliomoraes.clinicameriti.dto.ConsultaCompletaDTO;
import com.br.juliomoraes.clinicameriti.dto.ConsultaDTO;
import com.br.juliomoraes.clinicameriti.dto.PacienteDTO;
import com.br.juliomoraes.clinicameriti.enums.excecoes.mensagens.MessageException;
import com.br.juliomoraes.clinicameriti.model.Consulta;
import com.br.juliomoraes.clinicameriti.model.Medico;
import com.br.juliomoraes.clinicameriti.model.Paciente;
import com.br.juliomoraes.clinicameriti.repository.IConsultaRepository;
import com.br.juliomoraes.clinicameriti.repository.IMedicoRepository;
import com.br.juliomoraes.clinicameriti.repository.IPacienteRepository;
import com.br.juliomoraes.clinicameriti.services.exceptions.ObjectNotFoundException;
import com.br.juliomoraes.clinicameriti.services.exceptions.StandardException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ConsultaService {
    
    @Autowired
    private IConsultaRepository consultaRepository;
    
    @Autowired
    private IMedicoRepository medicoRepository;
    
    @Autowired
    private IPacienteRepository pacienteRepository;
    
    public void novaConsulta(ConsultaDTO dto) {
        Paciente paciente = this.pacienteRepository
                .findById(dto.getPacienteId())
                .orElseThrow(() -> new StandardException(MessageException.PACIENTE_NAO_EXISTE.getMensagem()));

        Medico medico = this.medicoRepository.findById(dto.getMedicoId())
                .orElseThrow(() -> new ObjectNotFoundException(MessageException.MEDICO_NAO_EXISTE.getMensagem()));

        Consulta consulta = Consulta.novo(dto, paciente, medico);

        this.consultaRepository.save(consulta);
    }

    public ConsultaCompletaDTO consultaPorId(Long id) {
        return ConsultaCompletaDTO.copyEntityFromDto(this.consultaRepository.findById(id)
                .orElseThrow(() -> new StandardException(MessageException.OBJECTO_NAO_ENCONTRADO.getMensagem())));
    }
    public List<ConsultaCompletaDTO> consultaPorNome(String nome) {
        return this.consultaRepository.findByPacienteNomeContainingIgnoreCase(nome).stream().map(ConsultaCompletaDTO::copyEntityFromDto)
                .collect(Collectors.toList());
    }
}

package com.br.juliomoraes.clinicameriti.services;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.br.juliomoraes.clinicameriti.dto.consulta.ConsultaCompletaDTO;
import com.br.juliomoraes.clinicameriti.dto.consulta.ConsultaDTO;
import com.br.juliomoraes.clinicameriti.dto.consulta.ConsultaPaginadaDTO;
import com.br.juliomoraes.clinicameriti.dto.consulta.ConsultaSimplesDTO;
import com.br.juliomoraes.clinicameriti.dto.paciente.PacienteSimplesDTO;
import com.br.juliomoraes.clinicameriti.enums.excecoes.mensagens.MessageException;
import com.br.juliomoraes.clinicameriti.model.Consulta;
import com.br.juliomoraes.clinicameriti.model.Medico;
import com.br.juliomoraes.clinicameriti.model.Paciente;
import com.br.juliomoraes.clinicameriti.model.Usuario;
import com.br.juliomoraes.clinicameriti.repository.IConsultaRepository;
import com.br.juliomoraes.clinicameriti.repository.IMedicoRepository;
import com.br.juliomoraes.clinicameriti.repository.IPacienteRepository;
import com.br.juliomoraes.clinicameriti.services.exceptions.ObjectNotFoundException;
import com.br.juliomoraes.clinicameriti.services.exceptions.StandardException;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ConsultaService {
    
    final IConsultaRepository consultaRepository;
    final IMedicoRepository medicoRepository;
    final IPacienteRepository pacienteRepository;
    final IAuthService authService;
    
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
    
    public PacienteSimplesDTO consultasPorCpf(String cpf) {
    	List<Consulta> listConsultasPorCpf = this.consultaRepository.findByPacienteCpf(cpf, LocalDate.now());
    	
    	if(listConsultasPorCpf.isEmpty())
    		throw new StandardException("Nenhuma consulta encontrada para o cpf informado.");
    	
    	return PacienteSimplesDTO.novo(listConsultasPorCpf.get(0).getPaciente() , this.getConsultas(listConsultasPorCpf));
    }
    
    private List<ConsultaSimplesDTO> getConsultas(List<Consulta> consultas) {
    	return consultas.stream().map(ConsultaSimplesDTO::new).collect(Collectors.toList());
    }

	public Page<ConsultaPaginadaDTO> getConsultasPaginada(Pageable pageable) {
		Long usuarioIdAdmin = 0L;
		Usuario usuario = this.authService.authenticated();
		if(this.authService.validaSeUsuarioLogadoEMedico(usuario)) {
			Medico medico = this.medicoRepository.findByUsuarioId(usuario.getId());
			
		}
		return null;
	}
}

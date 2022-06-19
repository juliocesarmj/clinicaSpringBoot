package com.br.juliomoraes.clinicameriti.services;

import com.br.juliomoraes.clinicameriti.dto.PacienteDTO;
import com.br.juliomoraes.clinicameriti.enums.excecoes.mensagens.MessageException;
import com.br.juliomoraes.clinicameriti.model.endereco.Endereco;
import com.br.juliomoraes.clinicameriti.model.paciente.Paciente;
import com.br.juliomoraes.clinicameriti.repository.IEnderecoRepository;
import com.br.juliomoraes.clinicameriti.repository.IPacienteRepository;
import com.br.juliomoraes.clinicameriti.services.exceptions.StandardException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PacienteService {

    @Autowired
    private IPacienteRepository pacienteRepository;

    @Autowired
    private IEnderecoRepository enderecoRepository;

    public void novo(PacienteDTO dto) {

        this.validaCpf(dto.getCpf());
        this.validaEmail(dto.getEmail());
        this.validaTelefone(dto.getTelefone());

        Paciente paciente = Paciente.novo(dto);
        Endereco endereco = Endereco.novo(dto.getEnderecoDTO());

        this.pacienteRepository.save(paciente);
        endereco.setPaciente(paciente);
        this.enderecoRepository.save(endereco);

    }

    private void validaCpf(String cpf) {
       if(this.pacienteRepository.findByCpf(cpf) != null) throw new StandardException(MessageException.CPF_EXISTENTE.getMensagem());
    }
    private void validaEmail(String email) {
        if(this.pacienteRepository.findByEmail(email) != null) throw new StandardException(MessageException.EMAIL_EXISTENTE.getMensagem());
    }

    private void validaTelefone(String telefone) {
        if(this.pacienteRepository.findByTelefone(telefone) != null) throw new StandardException(MessageException.TELEFONE_EXISTENTE.getMensagem());
    }

    public Page<Paciente> pacientes(Pageable pageable) {
        return this.pacienteRepository.findAll(pageable);
    }
}

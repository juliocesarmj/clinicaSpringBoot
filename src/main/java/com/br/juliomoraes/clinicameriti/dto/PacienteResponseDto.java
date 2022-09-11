package com.br.juliomoraes.clinicameriti.dto;

import com.br.juliomoraes.clinicameriti.model.paciente.Paciente;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@Data
public class PacienteResponseDto {
    private Long id;
    private String nome;
    private String email;
    private String telefone;
    @JsonFormat(pattern = "yyyy-MM-dd", shape = JsonFormat.Shape.STRING)
    private LocalDate dataNascimento;
    private String cpf;
    private EnderecoDTO endereco;

    public PacienteResponseDto(Paciente paciente) {
        this.id = paciente.getId();
        this.nome = paciente.getNome();
        this.email = paciente.getEmail();
        this.telefone = paciente.getTelefone();
        this.dataNascimento = paciente.getDataNascimento();
        this.cpf = paciente.getCpf();
        this.endereco = EnderecoDTO.copyEntityFromDto(paciente.getEndereco());
    }
}

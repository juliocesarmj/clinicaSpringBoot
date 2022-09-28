package com.br.juliomoraes.clinicameriti.dto;

import java.util.ArrayList;
import java.util.List;

import com.br.juliomoraes.clinicameriti.dto.consulta.ConsultaSimplesDTO;
import com.br.juliomoraes.clinicameriti.model.Paciente;

import lombok.Data;

@Data
public class PacienteSimplesDTO {
	
	private Long id;
	private String nome;
	private String cpf;
	private List<ConsultaSimplesDTO> consultas = new ArrayList<>();
	
	public static PacienteSimplesDTO novo(Paciente paciente, List<ConsultaSimplesDTO> listConsultas) {
		
		PacienteSimplesDTO dto = new PacienteSimplesDTO();
    	dto.setCpf(paciente.getCpf());
    	dto.setId(paciente.getId());
    	dto.setNome(paciente.getNome());
    	dto.setConsultas(listConsultas);
    	return dto;
	}
}

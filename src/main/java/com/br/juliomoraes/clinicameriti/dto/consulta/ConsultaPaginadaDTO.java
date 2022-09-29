package com.br.juliomoraes.clinicameriti.dto.consulta;

import java.util.Objects;

import com.br.juliomoraes.clinicameriti.model.Consulta;

public class ConsultaPaginadaDTO extends ConsultaSimplesDTO {
	
	private String nomePaciente;
	private String atendente;
	
	public ConsultaPaginadaDTO(Consulta consulta) {
		super(consulta);
		nomePaciente = consulta.getPaciente().getNome();
		atendente = consulta.getUsuario().getNomeUsuario();
	}

	public String getNomePaciente() {
		return nomePaciente;
	}

	public void setNomePaciente(String nomePaciente) {
		this.nomePaciente = nomePaciente;
	}

	public String getAtendente() {
		return atendente;
	}

	public void setAtendente(String atendente) {
		this.atendente = atendente;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(nomePaciente);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		ConsultaPaginadaDTO other = (ConsultaPaginadaDTO) obj;
		return Objects.equals(nomePaciente, other.nomePaciente);
	}
}

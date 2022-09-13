package com.br.juliomoraes.clinicameriti.model.medico;

import com.br.juliomoraes.clinicameriti.dto.MedicoDTO;
import com.br.juliomoraes.clinicameriti.model.consulta.Consulta;
import com.br.juliomoraes.clinicameriti.model.especialidade.Especialidade;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "medico")
public class Medico {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nome;
	private String crm;
	private LocalDate dataNascimento;
	@ManyToOne
	@JoinColumn(name = "especialidade_id")
	private Especialidade especialidade;
	private Double valorConsulta;

	@OneToMany(mappedBy = "medico")
	private List<Consulta> consultas = new ArrayList<>();

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCrm() {
		return crm;
	}

	public void setCrm(String crm) {
		this.crm = crm;
	}

	public LocalDate getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public Especialidade getEspecialidade() {
		return especialidade;
	}

	public void setEspecialidade(Especialidade especialidade) {
		this.especialidade = especialidade;
	}

	public Double getValorConsulta() {
		return valorConsulta;
	}

	public void setValorConsulta(Double valorConsulta) {
		this.valorConsulta = valorConsulta;
	}

	public List<Consulta> getConsultas() {
		return consultas;
	}

	public void atualizaDadosMedico(MedicoDTO dto) {
		this.nome = dto.getNome();
		this.crm = dto.getCrm();
		this.dataNascimento = dto.getDataNascimento();
		this.valorConsulta = dto.getValorConsulta();
	}
}

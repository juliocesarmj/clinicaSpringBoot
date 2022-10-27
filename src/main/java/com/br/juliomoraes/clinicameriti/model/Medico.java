package com.br.juliomoraes.clinicameriti.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.br.juliomoraes.clinicameriti.dto.medico.MedicoDTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "medico")
public class Medico {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_medico")
	@SequenceGenerator(name = "seq_medico", sequenceName = "medico_sequence")
	private Long id;
	private String nome;
	private String crm;
	private LocalDate dataNascimento;
	
	@ManyToOne
	@JoinColumn(name = "especialidade_id")
	private Especialidade especialidade;
	private Double valorConsulta;

	@OneToMany(mappedBy = "medico")
	private List<Consulta> consultas;
	
	private Long usuarioId;
	
	public void atualizaDadosMedico(MedicoDTO dto) {
		this.nome = dto.getNome();
		this.crm = dto.getCrm();
		this.dataNascimento = dto.getDataNascimento();
		this.valorConsulta = dto.getValorConsulta();
	}
}

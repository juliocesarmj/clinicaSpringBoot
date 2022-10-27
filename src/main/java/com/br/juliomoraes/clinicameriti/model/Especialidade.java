package com.br.juliomoraes.clinicameriti.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "especialidade")
@Getter
@Setter
public class Especialidade {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_especialidade")
	@SequenceGenerator(name = "seq_especialidade", sequenceName = "especialidade_sequence")
    private Long id;
    private String nome;

    @OneToMany(mappedBy = "especialidade")
    private List<Medico> medico = new ArrayList<>();

}

package com.br.juliomoraes.clinicameriti.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "perfil")
public class Perfil implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_perfil")
	@SequenceGenerator(name = "seq_perfil", sequenceName = "perfil_sequence")
	private Long id;
	private String authority;
	
	@ManyToMany(mappedBy = "perfis")
	private Set<Usuario> usuarios = new HashSet<>();
	
}

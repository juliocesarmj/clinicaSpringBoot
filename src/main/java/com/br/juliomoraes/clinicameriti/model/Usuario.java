package com.br.juliomoraes.clinicameriti.model;

import java.io.Serializable;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.br.juliomoraes.clinicameriti.dto.usuario.UsuarioPostDto;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "usuario")
public class Usuario implements Serializable, UserDetails {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_usuario")
	@SequenceGenerator(name = "seq_usuario", sequenceName = "usuario_sequence", initialValue = 8)
	private Long id;
	private String nomeUsuario;

	@Column(unique = true)
	private String email;
	private String senha;

	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "usuario_perfil", joinColumns = @JoinColumn(name = "usuario_id"), inverseJoinColumns = @JoinColumn(name = "perfil_id"))
	private Set<Perfil> perfis = new HashSet<>();

	private boolean ativo;
	
	@OneToMany(mappedBy = "usuario")
	private List<Consulta> consultas;
	
	public static Usuario novo(UsuarioPostDto dto) {
		Usuario usuario = new Usuario();
		usuario.setNomeUsuario(dto.getNomeUsuario());
		usuario.setEmail(dto.getEmail());
		usuario.setAtivo(true);
		return usuario;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return perfis.stream().map(perfil -> new SimpleGrantedAuthority(perfil.getAuthority()))
				.collect(Collectors.toList());
	}

	@Override
	public String getUsername() {
		return getEmail();
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

	@Override
	public String getPassword() {
		return getSenha();
	}
	
	public boolean temPerfil(String perfil) {
		return perfis.stream().anyMatch(p -> p.getAuthority().equals(perfil));
	}
}

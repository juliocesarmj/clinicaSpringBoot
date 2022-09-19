package com.br.juliomoraes.clinicameriti.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.br.juliomoraes.clinicameriti.model.Usuario;

public interface IUsuarioRepository extends JpaRepository<Usuario, Long> {
	
	Optional<Usuario> findByEmail(String email);
}

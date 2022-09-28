package com.br.juliomoraes.clinicameriti.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.br.juliomoraes.clinicameriti.model.Medico;

import java.util.List;
import java.util.Optional;

public interface IMedicoRepository extends JpaRepository<Medico, Long> {

	List<Medico> findAllByEspecialidade_Id(final Long especialidadeId);
	Optional<Medico> findByCrm(String crm);
	
	Medico findByUsuarioId(Long usuarioId);
}

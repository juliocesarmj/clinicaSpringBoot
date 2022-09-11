package com.br.juliomoraes.clinicameriti.repository;

import com.br.juliomoraes.clinicameriti.enums.especialidades.Especialidade;
import com.br.juliomoraes.clinicameriti.model.medico.Medico;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface IMedicoRepository extends JpaRepository<Medico, Long> {

	List<Medico> findAllByEspecialidade(final Especialidade especialidade);
	Optional<Medico> findByCrm(String crm);
}

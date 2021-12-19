package com.br.juliomoraes.clinicameriti.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.br.juliomoraes.clinicameriti.model.Medico;

public interface IMedicoRepository extends JpaRepository<Medico, Long> {

	@Query("FROM Medico med INNER JOIN med.especialidade esp where esp.id =:idEspecialidade")
	List<Medico> medicosPorEspecialidadeId(@Param("idEspecialidade") final Long idEspecialidade);

}

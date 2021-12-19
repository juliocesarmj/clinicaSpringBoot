package com.br.juliomoraes.clinicameriti.services;

import java.util.List;

import com.br.juliomoraes.clinicameriti.dto.MedicoDTO;

public interface IMedicoService {

	void novoMedico(MedicoDTO dto);

	void alterarMedico(Long idMedico, MedicoDTO dto);

	void excluirMedico(Long idMedico);

	MedicoDTO consultarMedico(Long idMedico);

	List<MedicoDTO> medicos();

	List<MedicoDTO> medicosPorEspecialidade(final Long idEspecialidade);
}

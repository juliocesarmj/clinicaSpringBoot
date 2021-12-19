package com.br.juliomoraes.clinicameriti.services;

import java.util.List;

import com.br.juliomoraes.clinicameriti.dto.MedicoDTO;

public interface IMedicoService {

	void novoMedico(MedicoDTO dto);

	List<MedicoDTO> medicos();

	List<MedicoDTO> medicosPorEspecialidade(final Long idEspecialidade);
}

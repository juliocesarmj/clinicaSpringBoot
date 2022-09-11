package com.br.juliomoraes.clinicameriti.services;

import java.util.List;

import com.br.juliomoraes.clinicameriti.dto.MedicoDTO;
import com.br.juliomoraes.clinicameriti.dto.MedicoResponseDto;
import com.br.juliomoraes.clinicameriti.enums.especialidades.Especialidade;

public interface IMedicoService {

	void novoMedico(MedicoDTO dto);

	void alterarMedico(Long idMedico, MedicoDTO dto);

	void excluirMedico(Long idMedico);

	MedicoResponseDto consultarMedico(Long idMedico);

	List<MedicoResponseDto> medicos();

	List<MedicoResponseDto> medicosPorEspecialidade(final Especialidade especialidade);
}

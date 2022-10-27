package com.br.juliomoraes.clinicameriti.services.medico;

import java.util.List;

import com.br.juliomoraes.clinicameriti.dto.medico.MedicoDTO;
import com.br.juliomoraes.clinicameriti.dto.medico.MedicoResponseDto;

public interface IMedicoService {

	void novoMedico(MedicoDTO dto);

	void alterarMedico(Long idMedico, MedicoDTO dto);

	MedicoResponseDto consultarMedico(Long idMedico);

	List<MedicoResponseDto> medicos();

	List<MedicoResponseDto> medicosPorEspecialidade(final Long especialidadeId);
}

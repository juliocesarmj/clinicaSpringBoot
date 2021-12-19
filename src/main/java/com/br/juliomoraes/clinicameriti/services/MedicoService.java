package com.br.juliomoraes.clinicameriti.services;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.br.juliomoraes.clinicameriti.dto.EspecialidadeDTO;
import com.br.juliomoraes.clinicameriti.dto.MedicoDTO;
import com.br.juliomoraes.clinicameriti.model.Especialidade;
import com.br.juliomoraes.clinicameriti.model.Medico;
import com.br.juliomoraes.clinicameriti.repository.IEspecialidadeRepository;
import com.br.juliomoraes.clinicameriti.repository.IMedicoRepository;
import com.br.juliomoraes.clinicameriti.utils.DataUtils;

@Service
public class MedicoService implements IMedicoService {

	@Autowired
	private IMedicoRepository repository;

	@Autowired
	private IEspecialidadeRepository especialidadeRepository;

	@Override
	public void novoMedico(final MedicoDTO dto) {

		try {
			final Medico medico = new Medico();
			medico.setNome(dto.getNome());
			medico.setCrm(dto.getCrm());
			if (dto.getDataNascimento().contains("/")) {
				medico.setDataNascimento(DataUtils.stringPtBrToDate(dto.getDataNascimento()));
			} else {
				medico.setDataNascimento(DataUtils.stringToDate(dto.getDataNascimento()));
			}

			final Especialidade especialidade = this.especialidadeRepository.getById(dto.getEspecialidade().getId());

			if (especialidade != null) {
				medico.setEspecialidade(especialidade);
			}

			this.repository.save(medico);
		} catch (final Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<MedicoDTO> medicos() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<MedicoDTO> medicosPorEspecialidade(final Long idEspecialidade) {

		try {
			final List<Medico> list = this.repository.medicosPorEspecialidadeId(idEspecialidade);
			final List<MedicoDTO> listDto = new ArrayList<>();
			for (final Medico medicoDTO : list) {
				final MedicoDTO dto = new MedicoDTO();
				dto.setId(medicoDTO.getId());
				dto.setNome(medicoDTO.getNome());
				dto.setCrm(medicoDTO.getCrm());
				dto.setDataNascimento(DataUtils.dataToStringPtBr(medicoDTO.getDataNascimento()));
				dto.setEspecialidade(new EspecialidadeDTO(medicoDTO.getEspecialidade()));
				listDto.add(dto);
			}
			return listDto;
		} catch (final Exception e) {
			return Collections.emptyList();
		}
	}

}

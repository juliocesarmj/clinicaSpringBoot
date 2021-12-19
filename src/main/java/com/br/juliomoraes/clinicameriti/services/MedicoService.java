package com.br.juliomoraes.clinicameriti.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.br.juliomoraes.clinicameriti.dto.MedicoDTO;
import com.br.juliomoraes.clinicameriti.model.Especialidade;
import com.br.juliomoraes.clinicameriti.model.Medico;
import com.br.juliomoraes.clinicameriti.repository.IEspecialidadeRepository;
import com.br.juliomoraes.clinicameriti.repository.IMedicoRepository;
import com.br.juliomoraes.clinicameriti.services.exceptions.MedicoExistsException;
import com.br.juliomoraes.clinicameriti.services.exceptions.ObjectNotFoundException;
import com.br.juliomoraes.clinicameriti.services.exceptions.StandardException;
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

			this.validaExisteMedicoCRM(dto.getCrm());

			final Medico medico = new Medico();

			medico.setNome(dto.getNome());

			medico.setCrm(dto.getCrm());

			this.validaDataStringESetaDataNascimento(dto.getDataNascimento(), medico);

			final Especialidade especialidade = this.especialidadeRepository.getById(dto.getEspecialidade().getId());

			if (especialidade != null) {
				medico.setEspecialidade(especialidade);
			}

			this.repository.save(medico);
		} catch (final MedicoExistsException m) {
			throw m;
		} catch (final Exception e) {
			throw e;
		}
	}

	@Override
	@Transactional(readOnly = true)
	public List<MedicoDTO> medicos() {

		final List<Medico> listaMedicos = this.repository.findAll();

		return listaMedicos.stream().map(MedicoDTO::new).collect(Collectors.toList());
	}

	@Override
	@Transactional(readOnly = true)
	public List<MedicoDTO> medicosPorEspecialidade(final Long idEspecialidade) {

		try {
			final List<Medico> list = this.repository.medicosPorEspecialidadeId(idEspecialidade);
			if (!list.isEmpty()) {
				return list.stream().map(MedicoDTO::new).collect(Collectors.toList());
			}
			throw new ObjectNotFoundException(HttpStatus.NOT_FOUND, "Não há médicos para a especialidade informada");
		} catch (final ObjectNotFoundException o) {
			throw o;
		} catch (final Exception e) {
			throw new StandardException(HttpStatus.INTERNAL_SERVER_ERROR,
					"Erro interno. Contate o suporte." + e.getMessage());
		}
	}

	@Override
	public void alterarMedico(final Long idMedico, final MedicoDTO dto) {

		try {
			final Medico medico = this.pesquisarMedico(idMedico);
			if (dto.getCrm().equalsIgnoreCase(medico.getCrm())) {
				medico.setCrm(dto.getCrm());
			} else {
				this.validaExisteMedicoCRM(dto.getCrm());
				medico.setCrm(dto.getCrm());
			}

			medico.setNome(dto.getNome());

			this.validaDataStringESetaDataNascimento(dto.getDataNascimento(), medico);
			this.repository.save(medico);

		} catch (final ObjectNotFoundException e) {
			throw e;
		} catch (final Exception e) {
			throw e;
		}
	}

	@Override
	public void excluirMedico(final Long idMedico) {

		try {
			final Medico medico = this.pesquisarMedico(idMedico);
			this.repository.delete(medico);
		} catch (final ObjectNotFoundException e) {
			throw e;
		} catch (final Exception e) {
			throw e;
		}

	}

	@Override
	@Transactional(readOnly = true)
	public MedicoDTO consultarMedico(final Long idMedico) {

		try {
			final Medico medico = this.pesquisarMedico(idMedico);
			return new MedicoDTO(medico);

		} catch (final ObjectNotFoundException e) {
			throw e;
		} catch (final Exception e) {
			throw e;
		}

	}

	private Medico pesquisarMedico(final Long idMedico) {

		try {
			final Optional<Medico> result = this.repository.findById(idMedico);

			return result
					.orElseThrow(() -> new ObjectNotFoundException(HttpStatus.NOT_FOUND, "Médico não encontrado."));

		} catch (final ObjectNotFoundException e) {
			throw e;
		} catch (final Exception e) {
			throw new StandardException(HttpStatus.INTERNAL_SERVER_ERROR,
					"Erro interno. Contate o suporte." + e.getMessage());
		}
	}

	private void validaDataStringESetaDataNascimento(final String data, final Medico medico) {
		if (data.contains("/")) {
			medico.setDataNascimento(DataUtils.stringPtBrToDate(data));
		} else {
			medico.setDataNascimento(DataUtils.stringToDate(data));
		}
	}

	private void validaExisteMedicoCRM(final String crm) {

		try {
			final Medico result = this.repository.medicoPorCrm(crm);
			if (result != null && result.getCrm().equalsIgnoreCase(crm)) {
				throw new MedicoExistsException(HttpStatus.BAD_REQUEST, "O crm informado já existe.");
			}
		} catch (final MedicoExistsException m) {
			throw m;
		} catch (final Exception e) {
			throw new StandardException(HttpStatus.INTERNAL_SERVER_ERROR,
					"Erro interno. Contate o suporte." + e.getMessage());
		}
	}

}

package com.br.juliomoraes.clinicameriti.services;

import com.br.juliomoraes.clinicameriti.dto.MedicoDTO;
import com.br.juliomoraes.clinicameriti.dto.MedicoResponseDto;
import com.br.juliomoraes.clinicameriti.enums.especialidades.Especialidade;
import com.br.juliomoraes.clinicameriti.enums.excecoes.mensagens.MessageException;
import com.br.juliomoraes.clinicameriti.model.medico.Medico;
import com.br.juliomoraes.clinicameriti.model.medico.MedicoMapper;
import com.br.juliomoraes.clinicameriti.repository.IMedicoRepository;
import com.br.juliomoraes.clinicameriti.services.exceptions.EspecialidadeException;
import com.br.juliomoraes.clinicameriti.services.exceptions.MedicoExistsException;
import com.br.juliomoraes.clinicameriti.services.exceptions.ObjectNotFoundException;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MedicoService implements IMedicoService {
    private final IMedicoRepository repository;

    @Override
    public void novoMedico(final MedicoDTO dto) {
        this.validaExisteMedicoCRM(dto.getCrm());
        this.repository.save(MedicoMapper.copyDtoFromEntity(dto));
    }
    @Override
    @Transactional(readOnly = true)
    public List<MedicoResponseDto> medicos() {
        return this.repository.findAll().stream().map(MedicoResponseDto::new).collect(Collectors.toList());
    }
    @Override
    @Transactional(readOnly = true)
    public List<MedicoResponseDto> medicosPorEspecialidade(final Especialidade especialidade) {
        if (Objects.nonNull(especialidade)) {
            return this.repository.findAllByEspecialidade(especialidade).stream().map(MedicoResponseDto::new).collect(Collectors.toList());
        }
        throw new EspecialidadeException(MessageException.ESPECIALIDADE_NAO_EXISTE.getMensagem());

    }
    @Override
    public void alterarMedico(final Long idMedico, final MedicoDTO dto) {
        Medico medico = this.pesquisarMedico(idMedico);
        medico.atualizaDadosMedico(dto);
        this.repository.save(medico);
    }
    @Override
    public void excluirMedico(final Long idMedico) {
        this.pesquisarMedico(idMedico);
        this.repository.deleteById(idMedico);

    }
    @Override
    @Transactional(readOnly = true)
    public MedicoResponseDto consultarMedico(final Long idMedico) {
        return new MedicoResponseDto(this.pesquisarMedico(idMedico));
    }

    private Medico pesquisarMedico(final Long idMedico) {
        return this.repository.findById(idMedico)
                .orElseThrow(() -> new ObjectNotFoundException(MessageException.MEDICO_NAO_EXISTE.getMensagem()));
    }
    private void validaExisteMedicoCRM(final String crm) {
        if (this.repository.findByCrm(crm).isPresent()) {
            throw new MedicoExistsException(MessageException.MEDICO_EXISTE_CRM.getMensagem());
        }
    }

}

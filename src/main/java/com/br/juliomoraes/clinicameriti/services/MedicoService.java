package com.br.juliomoraes.clinicameriti.services;

import com.br.juliomoraes.clinicameriti.dto.MedicoDTO;
import com.br.juliomoraes.clinicameriti.enums.especialidades.Especialidade;
import com.br.juliomoraes.clinicameriti.enums.excecoes.mensagens.MessageException;
import com.br.juliomoraes.clinicameriti.model.medico.Medico;
import com.br.juliomoraes.clinicameriti.model.medico.MedicoMapper;
import com.br.juliomoraes.clinicameriti.repository.IMedicoRepository;
import com.br.juliomoraes.clinicameriti.services.exceptions.EspecialidadeException;
import com.br.juliomoraes.clinicameriti.services.exceptions.MedicoExistsException;
import com.br.juliomoraes.clinicameriti.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class MedicoService implements IMedicoService {

    @Autowired
    private IMedicoRepository repository;

    @Override
    public void novoMedico(final MedicoDTO dto) {
        this.validaExisteMedicoCRM(dto.getCrm());
        this.repository.save(MedicoMapper.copyDtoFromEntity(dto));
    }
    @Override
    @Transactional(readOnly = true)
    public List<MedicoDTO> medicos() {
        return this.repository.findAll().stream().map(MedicoDTO::new).collect(Collectors.toList());
    }
    @Override
    @Transactional(readOnly = true)
    public List<MedicoDTO> medicosPorEspecialidade(final Especialidade especialidade) {
        if (Objects.nonNull(especialidade)) {
            for (int i = 0; i < Especialidade.values().length; i++) {
                if (especialidade.getNomeEspecialidade().equalsIgnoreCase(Especialidade.values()[i].getNomeEspecialidade())) {
                    return this.repository.findByEspecialidade(especialidade).stream().map(MedicoDTO::new).collect(Collectors.toList());
                }
            }
        }
        throw new EspecialidadeException(MessageException.ESPECIALIDADE_NAO_EXISTE.getMensagem());

    }
    @Override
    public void alterarMedico(final Long idMedico, final MedicoDTO dto) {
        this.pesquisarMedico(idMedico);
        dto.setId(idMedico);
        this.repository.save(MedicoMapper.copyDtoFromEntity(dto));
    }
    @Override
    public void excluirMedico(final Long idMedico) {
        this.pesquisarMedico(idMedico);
        this.repository.deleteById(idMedico);

    }
    @Override
    @Transactional(readOnly = true)
    public MedicoDTO consultarMedico(final Long idMedico) {
        return new MedicoDTO(this.pesquisarMedico(idMedico));
    }

    private Medico pesquisarMedico(final Long idMedico) {
        return this.repository.findById(idMedico)
                .orElseThrow(() -> new ObjectNotFoundException(MessageException.MEDICO_NAO_EXISTE.getMensagem()));
    }
    private void validaExisteMedicoCRM(final String crm) {
        final Medico result = this.repository.findByCrm(crm);
        if (Objects.nonNull(result)) {
            throw new MedicoExistsException(MessageException.MEDICO_EXISTE_CRM.getMensagem());
        }
    }

}

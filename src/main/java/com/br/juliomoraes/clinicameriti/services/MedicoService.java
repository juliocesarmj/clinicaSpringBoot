package com.br.juliomoraes.clinicameriti.services;

import com.br.juliomoraes.clinicameriti.dto.medico.MedicoDTO;
import com.br.juliomoraes.clinicameriti.dto.medico.MedicoResponseDto;
import com.br.juliomoraes.clinicameriti.dto.usuario.UsuarioGetDTO;
import com.br.juliomoraes.clinicameriti.enums.excecoes.mensagens.MessageException;
import com.br.juliomoraes.clinicameriti.model.Especialidade;
import com.br.juliomoraes.clinicameriti.model.Medico;
import com.br.juliomoraes.clinicameriti.model.medico.MedicoMapper;
import com.br.juliomoraes.clinicameriti.repository.IEspecialidadeRepository;
import com.br.juliomoraes.clinicameriti.repository.IMedicoRepository;
import com.br.juliomoraes.clinicameriti.services.exceptions.EspecialidadeException;
import com.br.juliomoraes.clinicameriti.services.exceptions.MedicoExistsException;
import com.br.juliomoraes.clinicameriti.services.exceptions.ObjectNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MedicoService implements IMedicoService {
	
    private final IMedicoRepository repository;
    private final IEspecialidadeRepository especialidadeRepository;
    private final IUserService userService;
    private final IAuthService authService;

    @Override
    public void novoMedico(final MedicoDTO dto) {
        this.validaExisteMedicoCRM(dto.getCrm());
        Especialidade especialidade = this.getByEspecialidadeId(dto.getEspecialidadeId());
        Medico medico = MedicoMapper.copyDtoFromEntity(dto);
        medico.setEspecialidade(especialidade);
        UsuarioGetDTO usuarioGetDTO = this.userService.create(dto.getUsuario());
        medico.setUsuarioId(usuarioGetDTO.getId());
        this.repository.save(medico);
    }
    
    @Override
    @Transactional(readOnly = true)
    public List<MedicoResponseDto> medicos() {
        return this.repository.findAll().stream().map(MedicoResponseDto::new).collect(Collectors.toList());
    }
    
    @Override
    @Transactional(readOnly = true)
    public List<MedicoResponseDto> medicosPorEspecialidade(final Long especialidadeId) {
        this.getByEspecialidadeId(especialidadeId);
        return this.repository.findAllByEspecialidade_Id(especialidadeId).stream().map(MedicoResponseDto::new).collect(Collectors.toList());
    }
    
    @Override
    public void alterarMedico(final Long idMedico, final MedicoDTO dto) {
        Medico medico = this.pesquisarMedico(idMedico);
        this.authService.validaUsuarioLogadoOuAdmin(medico.getUsuarioId());
        this.validaExisteMedicoCRM(dto.getCrm());
        medico.atualizaDadosMedico(dto);
        this.repository.save(medico);
    }
    
    @Override
    @Transactional(readOnly = true)
    public MedicoResponseDto consultarMedico(final Long idMedico) {
    	Medico medico = this.pesquisarMedico(idMedico);
    	this.authService.validaUsuarioLogadoOuAdmin(medico.getUsuarioId());
        return new MedicoResponseDto(medico);
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

    private Especialidade getByEspecialidadeId(final Long especialidadeId) {
       return this.especialidadeRepository.findById(especialidadeId).orElseThrow(() -> new EspecialidadeException(MessageException.ESPECIALIDADE_NAO_EXISTE.getMensagem()));
    }
}

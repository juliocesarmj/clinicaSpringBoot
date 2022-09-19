package com.br.juliomoraes.clinicameriti.services;

import java.util.Set;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.br.juliomoraes.clinicameriti.dto.PerfilGetDTO;
import com.br.juliomoraes.clinicameriti.dto.UsuarioGetDTO;
import com.br.juliomoraes.clinicameriti.dto.UsuarioPostDto;
import com.br.juliomoraes.clinicameriti.model.Perfil;
import com.br.juliomoraes.clinicameriti.model.Usuario;
import com.br.juliomoraes.clinicameriti.repository.IPerfilRepository;
import com.br.juliomoraes.clinicameriti.repository.IUsuarioRepository;
import com.br.juliomoraes.clinicameriti.services.exceptions.ObjectNotFoundException;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService implements IUserService {

	final IUsuarioRepository usuarioRepository;
	final IPerfilRepository perfilRepository;

	@Override
	public Page<UsuarioGetDTO> findAllPaged(Pageable pageable) {
		return usuarioRepository.findAll(pageable).map(UsuarioGetDTO::new);
	}

	@Override
	public UsuarioGetDTO findById(Long id) {
		return new UsuarioGetDTO(this.getOptionalById(id));
	}

	@Override
	public UsuarioGetDTO create(UsuarioPostDto dto) {
		this.validaPerfis(dto.getPerfis());
		Usuario usuario = Usuario.novo(dto);
		dto.getPerfis().forEach(perfil -> usuario.getPerfis().add(this.getPerfil(perfil.getId())));
		this.usuarioRepository.save(usuario);
		return new UsuarioGetDTO(usuario);
	}

	@Override
	public UsuarioGetDTO update(UsuarioGetDTO dto) {
		return null;
	}
	
	private Usuario getOptionalById(Long id) {
		return this.usuarioRepository.findById(id)
				.orElseThrow(() -> new ObjectNotFoundException("Usuário não encontrado."));
	}

	private void validaPerfis(Set<PerfilGetDTO> perfis) {
		perfis.forEach(perfil -> this.perfilRepository.findById(perfil.getId()).orElseThrow(
				() -> new ObjectNotFoundException("Perfil " + perfil.getAuthority() + " não encontrado.")));
	}

	private Perfil getPerfil(Long id) {
		return this.perfilRepository.findById(id)
				.orElseThrow(() -> new ObjectNotFoundException("Perfil não encontrado."));
	}
}

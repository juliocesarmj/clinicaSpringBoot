package com.br.juliomoraes.clinicameriti.services.user;

import java.util.Optional;
import java.util.Set;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.br.juliomoraes.clinicameriti.dto.perfil.PerfilGetDTO;
import com.br.juliomoraes.clinicameriti.dto.usuario.UsuarioGetDTO;
import com.br.juliomoraes.clinicameriti.dto.usuario.UsuarioPostDto;
import com.br.juliomoraes.clinicameriti.model.Perfil;
import com.br.juliomoraes.clinicameriti.model.Usuario;
import com.br.juliomoraes.clinicameriti.repository.IPerfilRepository;
import com.br.juliomoraes.clinicameriti.repository.IUsuarioRepository;
import com.br.juliomoraes.clinicameriti.services.exceptions.ObjectNotFoundException;
import com.br.juliomoraes.clinicameriti.services.exceptions.StandardException;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserService implements IUserService, UserDetailsService {

	final IUsuarioRepository usuarioRepository;
	final IPerfilRepository perfilRepository;
	final BCryptPasswordEncoder passwordEncoder;

	@Override
	public Page<UsuarioGetDTO> findAllPaged(Pageable pageable) {
		return usuarioRepository.findAll(pageable).map(UsuarioGetDTO::new);
	}

	@Override
	public UsuarioGetDTO findById(Long id) {
		return new UsuarioGetDTO(this.getUsuarioById(id));
	}

	@Override
	public UsuarioGetDTO create(UsuarioPostDto dto) {
		
		this.validaPerfis(dto.getPerfis());
		this.validaEmail(dto.getEmail());
		Usuario usuario = Usuario.novo(dto);
		usuario.setSenha(this.passwordEncoder.encode(dto.getSenha()));
		dto.getPerfis().forEach(perfil -> usuario.getPerfis().add(this.getPerfil(perfil.getId())));
		this.usuarioRepository.save(usuario);
		return new UsuarioGetDTO(usuario);
	}

	@Override
	public UsuarioGetDTO update(UsuarioGetDTO dto) {
		return null;
	}
	
	private Usuario getUsuarioById(Long id) {
		return this.usuarioRepository.findById(id)
				.orElseThrow(() -> new ObjectNotFoundException("Usuário não encontrado."));
	}

	private void validaPerfis(Set<PerfilGetDTO> perfis) {
		if(perfis.isEmpty()) {
			throw new StandardException("Informe pelo menos um perfil de acesso para este usuário.");
		}
		perfis.forEach(perfil -> this.perfilRepository.findById(perfil.getId()).orElseThrow(
				() -> new ObjectNotFoundException("Perfil " + perfil.getAuthority() + " não encontrado.")));
	}

	private Perfil getPerfil(Long id) {
		return this.perfilRepository.findById(id)
				.orElseThrow(() -> new ObjectNotFoundException("Perfil não encontrado."));
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<Usuario> user = this.usuarioRepository.findByEmail(username);
		
		if(user.isEmpty()) {
			log.error("Usuário não encontrado: " + username);
			throw new UsernameNotFoundException("Usuário não encontrado");
		}
		log.info("Usuário encontrado: " + username);
		return user.get();
	}
	
	private void validaEmail(String email) {
		Optional<Usuario> user = this.usuarioRepository.findByEmail(email);
		if(user.isPresent())
			throw new StandardException("O email informado já existe.");
	}
}

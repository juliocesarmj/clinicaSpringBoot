package com.br.juliomoraes.clinicameriti.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;

@Configuration
@EnableResourceServer
public class ResourceServerConfig extends ResourceServerConfigurerAdapter {
	
	@Autowired
	private JwtTokenStore tokenStore;
	
	private static final String[] PUBLIC = {"/oauth/token"};
	private static final String[] ADMIN_OR_ATENDENTE = {"/consulta/**", "/pacientes/**"};
	private static final String[] MEDICO = {"/medico"};
	private static final String[] ATENDENTE_GET = {"/medicos/**"};
	private static final String[] ADMIN_FULL = {"/consulta/**", "/pacientes/**", "/medicos/**", "/medico/**", "/usuarios/**"};
	private static final String ADMIN = "ADMIN";
	
	@Override
	public void configure(ResourceServerSecurityConfigurer resources) throws Exception {
		resources.tokenStore(tokenStore);
	}

	@Override
	public void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
		.antMatchers(PUBLIC).permitAll()
		.antMatchers(HttpMethod.GET, ATENDENTE_GET).permitAll()
		.antMatchers(ATENDENTE_GET).hasAnyRole("ATENDENTE", ADMIN)
		.antMatchers(ADMIN_FULL).permitAll()
		.antMatchers(ADMIN_FULL).hasAnyRole(ADMIN)
		.antMatchers(MEDICO).permitAll()
		.antMatchers(MEDICO).hasAnyRole("MEDICO", ADMIN)
		.antMatchers(ADMIN_OR_ATENDENTE).permitAll()
		.antMatchers(ADMIN_OR_ATENDENTE).hasAnyRole("ATENDENTE", ADMIN)
		.anyRequest().authenticated();
	}
}

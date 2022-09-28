package com.br.juliomoraes.clinicameriti.dto.medico;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.*;

import com.br.juliomoraes.clinicameriti.dto.usuario.UsuarioPostDto;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MedicoDTO {
	@NotEmpty(message = "Informe um nome válido")
	private String nome;

	@Size(min = 8, max = 8, message = "Crm inválido")
	private String crm;

	@PastOrPresent(message = "Informe uma data de nascimento válida.")
	private LocalDate dataNascimento;

	private long especialidadeId;

	@DecimalMin(value = "0.1", message = "Informe um valor de consulta válido.")
	@DecimalMax(value = "200.0", message = "Informe um valor de consulta válido.")
	private Double valorConsulta;
	
	private UsuarioPostDto usuario;
}

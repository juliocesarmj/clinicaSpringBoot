package com.br.juliomoraes.clinicameriti.services.consulta;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.br.juliomoraes.clinicameriti.dto.consulta.ConsultaCompletaDTO;
import com.br.juliomoraes.clinicameriti.dto.consulta.ConsultaDTO;
import com.br.juliomoraes.clinicameriti.dto.consulta.ConsultaPaginadaDTO;
import com.br.juliomoraes.clinicameriti.dto.paciente.PacienteSimplesDTO;

public interface IConsultaService {

	void novaConsulta(ConsultaDTO dto);

	ConsultaCompletaDTO consultaPorId(Long id);

	List<ConsultaCompletaDTO> consultaPorNome(String nome);

	PacienteSimplesDTO consultasPorCpf(String cpf);

	Page<ConsultaPaginadaDTO> getConsultasPaginada(Pageable pageable);
	
	void cancelarAgendaPorData(LocalDate data, String motivo);
}

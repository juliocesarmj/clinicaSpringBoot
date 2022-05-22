package com.br.juliomoraes.clinicameriti.controller.exceptions;

import java.time.Instant;

import javax.servlet.http.HttpServletRequest;

import com.br.juliomoraes.clinicameriti.enums.excecoes.mensagens.MessageException;
import com.br.juliomoraes.clinicameriti.services.exceptions.EspecialidadeException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.br.juliomoraes.clinicameriti.services.exceptions.MedicoExistsException;
import com.br.juliomoraes.clinicameriti.services.exceptions.ObjectNotFoundException;

@ControllerAdvice
public class ResourceHandlerException {

	@ExceptionHandler(ObjectNotFoundException.class)
	private ResponseEntity<StandardError> handlerObjectNotFoundException(final ObjectNotFoundException o,
			final HttpServletRequest req) {

		final StandardError error = new StandardError();
		error.setTimestamp(Instant.now());
		error.setStatus(HttpStatus.NOT_FOUND.value());
		error.setMessage(o.getMessage());
		error.setError("Médico não encontrado.");
		error.setPath(req.getRequestURI());

		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
	}

	@ExceptionHandler(MedicoExistsException.class)
	private ResponseEntity<StandardError> handlerMedicoExistsException(final MedicoExistsException o,
			final HttpServletRequest req) {

		final StandardError error = new StandardError();
		error.setTimestamp(Instant.now());
		error.setStatus(HttpStatus.BAD_REQUEST.value());
		error.setMessage(o.getMessage());
		error.setError("O crm informado já existe.");
		error.setPath(req.getRequestURI());

		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
	}

	@ExceptionHandler(EspecialidadeException.class)
	private ResponseEntity<StandardError> handlerEspecialidadeException(final EspecialidadeException e,
																		 final HttpServletRequest req) {
		final StandardError error = new StandardError();
		error.setTimestamp(Instant.now());
		error.setStatus(HttpStatus.NOT_FOUND.value());
		error.setMessage(e.getMessage());
		error.setError(String.valueOf(MessageException.ESPECIALIDADE_NAO_EXISTE));
		error.setPath(req.getRequestURI());

		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
	}

	@ExceptionHandler(HttpMessageNotReadableException.class)
	private ResponseEntity<StandardError> handlerHttpMessageNotReadableException(final HttpMessageNotReadableException e,
																		final HttpServletRequest req) {
		final StandardError error = new StandardError();
		error.setTimestamp(Instant.now());
		error.setStatus(HttpStatus.NOT_FOUND.value());
		error.setMessage(String.valueOf(MessageException.ESPECIALIDADE_NAO_EXISTE.getMensagem()));
		error.setError(String.valueOf(MessageException.ESPECIALIDADE_NAO_EXISTE));
		error.setPath(req.getRequestURI());

		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
	}

}

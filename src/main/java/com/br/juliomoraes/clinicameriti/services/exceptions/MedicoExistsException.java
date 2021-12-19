package com.br.juliomoraes.clinicameriti.services.exceptions;

import org.springframework.http.HttpStatus;

public class MedicoExistsException extends ObjectNotFoundException {
	private static final long serialVersionUID = 1L;

	public MedicoExistsException(final HttpStatus status, final String msg) {
		super(status, msg);

	}

}

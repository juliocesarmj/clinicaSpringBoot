package com.br.juliomoraes.clinicameriti.services.exceptions;

import org.springframework.http.HttpStatus;

public class StandardException extends ObjectNotFoundException {
	private static final long serialVersionUID = 1L;

	public StandardException(final HttpStatus status, final String msg) {
		super(status, msg);
	}

}

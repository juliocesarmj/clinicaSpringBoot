package com.br.juliomoraes.clinicameriti.services.exceptions;

import org.springframework.http.HttpStatus;

public class ObjectNotFoundException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	private final HttpStatus status;

	public ObjectNotFoundException(final HttpStatus status, final String msg) {
		super(msg);
		this.status = status;
	}

}

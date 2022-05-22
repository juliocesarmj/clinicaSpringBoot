package com.br.juliomoraes.clinicameriti.services.exceptions;

public class ObjectNotFoundException extends RuntimeException {
	private static final long serialVersionUID = 1L;
	public ObjectNotFoundException(final String msg) {
		super(msg);
	}

}

package com.br.juliomoraes.clinicameriti.services.exceptions;

public class StandardException extends ObjectNotFoundException {
	private static final long serialVersionUID = 1L;
	public StandardException(final String msg) {
		super(msg);
	}

}

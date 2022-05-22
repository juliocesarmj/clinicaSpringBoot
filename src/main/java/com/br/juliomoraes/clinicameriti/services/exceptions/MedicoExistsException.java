package com.br.juliomoraes.clinicameriti.services.exceptions;

public class MedicoExistsException extends ObjectNotFoundException {
	private static final long serialVersionUID = 1L;
	public MedicoExistsException(final String msg) {
		super(msg);

	}

}

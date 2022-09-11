package com.br.juliomoraes.clinicameriti.controller.exceptions;

import java.time.Instant;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

@Data
public class StandardError {

	private Instant timestamp;
	private int status;
	private String message;
	private String path;
}

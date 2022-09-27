package com.br.juliomoraes.clinicameriti.controller.exceptions;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Data
public class StandardError {
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", shape = JsonFormat.Shape.STRING)
	private LocalDateTime timestamp;
	private int status;
	private String message;
	private String path;
}

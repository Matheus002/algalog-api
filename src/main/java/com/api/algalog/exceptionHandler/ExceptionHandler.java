package com.api.algalog.exceptionHandler;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@ControllerAdvice
public class ExceptionHandler extends ResponseEntityExceptionHandler {
	
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
																  HttpHeaders headers, HttpStatus status, WebRequest request) {
		List<Problem.Field> fields = new ArrayList<>();

		for (ObjectError error: ex.getBindingResult().getAllErrors()) {
			fields.add( new Problem.Field("name", "mensage"));
		}

		Problem problem = new Problem();
		problem.setStatus(status.value());
		problem.setDateTime(LocalDateTime.now());
		problem.setTitulo("Um ou mais campos estão inválidos. Faça o preencimento correto e tente novamento.");
		problem.setFields(fields);
		return handleExceptionInternal(ex, problem, headers, status, request);
	}
	
}

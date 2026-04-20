package com.example.leandro.crud_client.dto;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

public class ValidationError extends CustomError{

	List<FieldMessage> errors = new ArrayList<>();
	
	public ValidationError(Instant timestamp, Integer status, String error, String path) {
		super(timestamp, status, error, path);
	}

	public List<FieldMessage> getFields() {
		return errors;
	}
	
	public void addError(String name, String message) {
		errors.add(new FieldMessage(name, message));
	}
}

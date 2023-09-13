package com.mfernando.meupiteu.resources.exceptions;

import java.util.ArrayList;
import java.util.List;

public class ValidationErrors extends StandardError{
	private static final long serialVersionUID = 1L;
	private List<FieldsMessageErrors> errors = new ArrayList<>();
	public ValidationErrors(Integer status, String mensagem, Long timeStamp) {
		super(status, mensagem, timeStamp);
		// TODO Auto-generated constructor stub
	}
	public List<FieldsMessageErrors> getErrors() {
		return errors;
	}
	public void addError(String fieldName, String message) {
		errors.add(new FieldsMessageErrors(fieldName, message));
	}
	
	
}

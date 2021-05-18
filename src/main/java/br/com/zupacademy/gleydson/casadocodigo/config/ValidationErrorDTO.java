package br.com.zupacademy.gleydson.casadocodigo.config;

public class ValidationErrorDTO {
	
	private String field;
	private String error;
	
	public ValidationErrorDTO(String field, String error) {
		this.field = field;
		this.error = error;
	}
	
	public String getField() {
		return field;
	}
	
	public String getError() {
		return error;
	}	
}

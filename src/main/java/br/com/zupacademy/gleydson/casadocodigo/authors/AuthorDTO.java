package br.com.zupacademy.gleydson.casadocodigo.authors;

import br.com.zupacademy.gleydson.casadocodigo.validators.UniqueValue;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class AuthorDTO {

	@NotBlank
	private String name;
	
	@Email
	@NotBlank
	@UniqueValue(domainClass = Author.class, fieldName = "email")
	private String email;
	
	@NotBlank @Size(min = 1, max = 400)
	private String description;

	public AuthorDTO(@NotBlank String name, 
			@Email @NotBlank String email, 
			@NotBlank @Size(min = 1, max = 400) String description) {
		this.name = name;
		this.email = email;
		this.description = description;
	}

	public String getEmail() {
		return this.email;
	}

	@Override
	public String toString() {
		return "AuthorDTO [name=" + name + ", email=" + email + ", description=" + description + "]";
	}

	public Author toModel() {
		return new Author(name, email, description);
	}
}

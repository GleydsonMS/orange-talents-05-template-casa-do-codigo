package br.com.zupacademy.gleydson.casadocodigo.authors;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class AuthorDTO {

	@NotBlank
	private String name;
	
	@Email @NotBlank
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

	@Override
	public String toString() {
		return "AuthorDTO [name=" + name + ", email=" + email + ", description=" + description + "]";
	}

	public Author toModel() {
		return new Author(name, email, description);
	}
}

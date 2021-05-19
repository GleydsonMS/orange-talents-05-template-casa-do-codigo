package br.com.zupacademy.gleydson.casadocodigo.authors;

import java.time.Instant;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Author {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank
	private String name;

	@Column(unique = true)
	@Email
	@NotBlank
	private String email;
	
	@NotBlank @Size(min = 1, max = 400)
	private String description;
	
	@NotNull
	private Instant created_at;

	@Deprecated
	public Author() {
	}

	public Author(@NotBlank String name, 
			@Email @NotBlank String email, 
			@NotBlank @Size(min = 1, max = 400) String description) {
		this.name = name;
		this.email = email;
		this.description = description;
		this.created_at = Instant.now();
	}

	@Override
	public String toString() {
		return "Author [id=" + id + ", name=" + name + ", email=" + email + ", description=" + description
				+ ", created_at=" + created_at + "]";
	}	
}

package br.com.zupacademy.gleydson.casadocodigo.authors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/authors")
public class AuthorController {
	
	@Autowired
	private AuthorRepository authorRepository;

	@PostMapping
	public ResponseEntity<?> create(@RequestBody @Valid AuthorDTO authorDTO) {
		Author author = authorDTO.toModel();
		authorRepository.save(author);
		return ResponseEntity.ok().build();
	}
}

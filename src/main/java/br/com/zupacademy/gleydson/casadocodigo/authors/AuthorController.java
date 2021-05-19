package br.com.zupacademy.gleydson.casadocodigo.authors;

import javax.validation.Valid;
import javax.validation.Validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/authors")
public class AuthorController {
	
	@Autowired
	private AuthorRepository authorRepository;

	@Autowired
	private ForbidEmailDuplicateAuthorValidator forbidEmailDuplicateAuthorValidator;

	@InitBinder
	public void init(WebDataBinder binder) {
		binder.addValidators(forbidEmailDuplicateAuthorValidator);
	}

	@PostMapping
	public ResponseEntity<?> create(@RequestBody @Valid AuthorDTO authorDTO) {
		Author author = authorDTO.toModel();
		authorRepository.save(author);
		return ResponseEntity.ok().build();
	}
}

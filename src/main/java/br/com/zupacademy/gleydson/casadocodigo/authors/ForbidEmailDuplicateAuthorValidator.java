package br.com.zupacademy.gleydson.casadocodigo.authors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.util.Optional;

@Component
public class ForbidEmailDuplicateAuthorValidator implements Validator {

    @Autowired
    private AuthorRepository authorRepository;

    @Override
    public boolean supports(Class<?> aClass) {
        return AuthorDTO.class.isAssignableFrom(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        if(errors.hasErrors()) {
            return;
        }
        AuthorDTO request = (AuthorDTO) o;
        Optional<Author> author = authorRepository.findByEmail(request.getEmail());

        if (author.isPresent()) {
            errors.rejectValue("email", null, "Já existe um(a) outro autor(a) com o mesmo email "
                    + request.getEmail());
        }
    }
}

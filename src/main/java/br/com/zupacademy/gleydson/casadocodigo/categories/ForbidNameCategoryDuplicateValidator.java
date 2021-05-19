package br.com.zupacademy.gleydson.casadocodigo.categories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.util.Optional;

@Component
public class ForbidNameCategoryDuplicateValidator implements Validator {

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public boolean supports(Class<?> aClass) {
        return CategoryDTO.class.isAssignableFrom(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        if(errors.hasErrors()) {
            return;
        }

        CategoryDTO request = (CategoryDTO) o;
        Optional<Category> category = categoryRepository.findByName(request.getName());

        if (category.isPresent()) {
            errors.rejectValue("name", null, "Já existe uma categoria com este nome "
            + request.getName());
        }
    }
}

package br.com.zupacademy.gleydson.casadocodigo.categories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/categories")
public class CategoryController {

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private ForbidNameCategoryDuplicateValidator forbidNameCategoryDuplicateValidator;

    @InitBinder
    public void init(WebDataBinder binder) {
        binder.addValidators(forbidNameCategoryDuplicateValidator);
    }

    @PostMapping
    public String create(@RequestBody @Valid CategoryDTO categoryDTO) {
        Category category = categoryDTO.toModel();
        Category categoryCreated = categoryRepository.save(category);
        return categoryCreated.toString();
    }
}

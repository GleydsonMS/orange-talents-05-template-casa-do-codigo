package br.com.zupacademy.gleydson.casadocodigo.categories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/categories")
public class CategoryController {

    @Autowired
    private CategoryRepository categoryRepository;

    @PostMapping
    public String create(@RequestBody @Valid CategoryDTO categoryDTO) {
        Category category = categoryDTO.toModel();
        Category categoryCreated = categoryRepository.save(category);
        return categoryCreated.toString();
    }
}

package br.com.zupacademy.gleydson.casadocodigo.categories;

import br.com.zupacademy.gleydson.casadocodigo.validators.UniqueValue;

import javax.validation.constraints.NotBlank;

public class CategoryDTO {

    @NotBlank
    @UniqueValue(domainClass = Category.class, fieldName = "name")
    private String name;

    @Deprecated
    public CategoryDTO(){}

    public CategoryDTO(@NotBlank String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "CategoryDTO{" +
                "name='" + name + '\'' +
                '}';
    }

    public Category toModel() {
        return new Category(this.name);
    }
}

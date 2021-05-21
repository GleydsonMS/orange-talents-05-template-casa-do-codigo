package br.com.zupacademy.gleydson.casadocodigo.country;

import br.com.zupacademy.gleydson.casadocodigo.validators.UniqueValue;

import javax.validation.constraints.NotBlank;

public class CountryDTO {

    @NotBlank
    @UniqueValue(domainClass = Country.class, fieldName = "name")
    private String name;

    @Deprecated
    public CountryDTO(){}

    public CountryDTO(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "CountryDTO{" +
                "name='" + name + '\'' +
                '}';
    }

    public Country toModel() {
        return new Country((name));
    }
}

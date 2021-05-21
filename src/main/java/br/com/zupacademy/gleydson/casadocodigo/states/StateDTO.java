package br.com.zupacademy.gleydson.casadocodigo.states;

import br.com.zupacademy.gleydson.casadocodigo.countries.Country;
import br.com.zupacademy.gleydson.casadocodigo.validators.UniqueValueInSameCountry;

import javax.persistence.EntityManager;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@UniqueValueInSameCountry(domainClass = State.class, fieldName = "name")
public class StateDTO {

    @NotBlank
    private String name;

    @NotNull
    private Long countryId;

    @Deprecated
    public StateDTO() {}

    public StateDTO(@NotBlank String name,
                    @NotNull Long countryId) {
        this.name = name;
        this.countryId = countryId;
    }

    public String getName() {
        return name;
    }

    public Long getCountryId() {
        return countryId;
    }

    @Override
    public String toString() {
        return "StateDTO{" +
                "name='" + name + '\'' +
                ", countryId=" + countryId +
                '}';
    }

    public State toModel(EntityManager em) {
        Country country = em.find(Country.class, countryId);
        return new State(name, country);
    }
}

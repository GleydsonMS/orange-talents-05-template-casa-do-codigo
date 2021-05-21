package br.com.zupacademy.gleydson.casadocodigo.states;

import br.com.zupacademy.gleydson.casadocodigo.countries.Country;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class StateDTO {

    @Autowired
    private StateRepository stateRepository;

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

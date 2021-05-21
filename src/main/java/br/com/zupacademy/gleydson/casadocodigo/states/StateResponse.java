package br.com.zupacademy.gleydson.casadocodigo.states;

import br.com.zupacademy.gleydson.casadocodigo.countries.Country;

public class StateResponse {

    private Long id;
    private String name;
    private Country country;

    @Deprecated
    public StateResponse(){}

    public StateResponse(State state) {
        this.id = state.getId();
        this.name = state.getName();
        this.country = state.getCountry();
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Country getCountry() {
        return country;
    }
}

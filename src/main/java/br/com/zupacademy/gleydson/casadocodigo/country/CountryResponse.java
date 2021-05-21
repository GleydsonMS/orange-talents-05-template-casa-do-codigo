package br.com.zupacademy.gleydson.casadocodigo.country;

public class CountryResponse {

    private Long id;
    private String name;

    @Deprecated
    public CountryResponse (){}

    public CountryResponse(Country country) {
        this.id = country.getId();
        this.name = country.getName();
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}

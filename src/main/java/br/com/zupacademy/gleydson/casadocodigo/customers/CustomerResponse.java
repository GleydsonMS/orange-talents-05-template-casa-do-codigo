package br.com.zupacademy.gleydson.casadocodigo.customers;

import br.com.zupacademy.gleydson.casadocodigo.countries.Country;
import br.com.zupacademy.gleydson.casadocodigo.states.State;

public class CustomerResponse {

    private Long id;
    private String email;
    private String firstName;
    private String lastName;
    private String document;
    private String address;
    private String complement;
    private String city;
    private Country country;
    private State state;
    private String phone;
    private String cep;

    @Deprecated
    public  CustomerResponse() {}

    public CustomerResponse(Customer customer) {
        this.id = customer.getId();
        this.email = customer.getEmail();
        this.firstName = customer.getFirstName();
        this.lastName = customer.getLastName();
        this.document = customer.getDocument();
        this.address = customer.getAddress();
        this.complement = customer.getComplement();
        this.city = customer.getCity();
        this.country = customer.getCountry();
        this.state = customer.getState();
        this.phone = customer.getPhone();
        this.cep = customer.getCep();
    }

    public Long getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getDocument() {
        return document;
    }

    public String getAddress() {
        return address;
    }

    public String getComplement() {
        return complement;
    }

    public String getCity() {
        return city;
    }

    public Country getCountry() {
        return country;
    }

    public State getState() {
        return state;
    }

    public String getPhone() {
        return phone;
    }

    public String getCep() {
        return cep;
    }
}

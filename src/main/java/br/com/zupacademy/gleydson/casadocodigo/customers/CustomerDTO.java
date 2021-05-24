package br.com.zupacademy.gleydson.casadocodigo.customers;

import br.com.zupacademy.gleydson.casadocodigo.countries.Country;
import br.com.zupacademy.gleydson.casadocodigo.states.State;
import br.com.zupacademy.gleydson.casadocodigo.validators.CPForCNJP;
import br.com.zupacademy.gleydson.casadocodigo.validators.UniqueValue;

import javax.persistence.EntityManager;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class CustomerDTO {

    @NotBlank
    @Email
    @UniqueValue(domainClass = Customer.class, fieldName = "email")
    private String email;

    @NotBlank
    private String firstName;

    @NotBlank
    private String lastName;

    @NotBlank
    @CPForCNJP
    @UniqueValue(domainClass = Customer.class, fieldName = "document")
    private String document;

    @NotBlank
    private String address;

    @NotBlank
    private String complement;

    @NotBlank
    private String city;

    @NotNull
    private Long countryId;

    private Long stateId;

    @NotBlank
    private String phone;

    @NotBlank
    private String cep;

    @Deprecated
    private CustomerDTO() {}

    public CustomerDTO(@NotBlank @Email String email,
                       @NotBlank String firstName,
                       @NotBlank String lastName,
                       @NotBlank String document,
                       @NotBlank String address,
                       @NotBlank String complement,
                       @NotBlank String city,
                       @NotNull Long countryId,
                       Long stateId,
                       @NotBlank String phone,
                       @NotBlank String cep) {
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.document = document;
        this.address = address;
        this.complement = complement;
        this.city = city;
        this.countryId = countryId;
        this.stateId = stateId;
        this.phone = phone;
        this.cep = cep;
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

    public Long getCountryId() {
        return countryId;
    }

    public Long getStateId() {
        return stateId;
    }

    public String getPhone() {
        return phone;
    }

    public String getCep() {
        return cep;
    }

    @Override
    public String toString() {
        return "CustomerDTO{" +
                "email='" + email + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", document='" + document + '\'' +
                ", address='" + address + '\'' +
                ", complement='" + complement + '\'' +
                ", city='" + city + '\'' +
                ", country=" + countryId +
                ", state=" + stateId +
                ", phone='" + phone + '\'' +
                ", cep='" + cep + '\'' +
                '}';
    }

    public Customer toModel(EntityManager em) {
        Country country = em.find(Country.class, countryId);
        if (stateId != null) {
            State state = em.find(State.class, stateId);
            return new Customer(email, firstName, lastName, document, address, complement, city, country, state, phone, cep);
        } else {
            return new Customer(email, firstName, lastName, document, address, complement, city, country, phone, cep);
        }
    }
}

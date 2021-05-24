package br.com.zupacademy.gleydson.casadocodigo.customers;

import br.com.zupacademy.gleydson.casadocodigo.countries.Country;
import br.com.zupacademy.gleydson.casadocodigo.states.State;
import br.com.zupacademy.gleydson.casadocodigo.validators.CPForCNJP;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Email
    @Column(unique = true)
    private String email;

    @NotBlank
    private String firstName;

    @NotBlank
    private String lastName;

    @NotBlank
    @CPForCNJP
    @Column(unique = true)
    private String document;

    @NotBlank
    private String address;

    @NotBlank
    private String complement;

    @NotBlank
    private String city;

    @NotNull
    @ManyToOne
    private Country country;

    @ManyToOne
    private State state;

    @NotBlank
    private String phone;

    @NotBlank
    private String cep;

    @Deprecated
    private Customer() {}

    public Customer(@NotBlank @Email String email,
                    @NotBlank String firstName,
                    @NotBlank String lastName,
                    @NotBlank String document,
                    @NotBlank String address,
                    @NotBlank String complement,
                    @NotBlank String city,
                    @NotNull Country country,
                    State state,
                    @NotBlank String phone,
                    @NotBlank String cep) {
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.document = document;
        this.address = address;
        this.complement = complement;
        this.city = city;
        this.country = country;
        this.state = state;
        this.phone = phone;
        this.cep = cep;
    }

    public Customer(@NotBlank @Email String email,
                    @NotBlank String firstName,
                    @NotBlank String lastName,
                    @NotBlank String document,
                    @NotBlank String address,
                    @NotBlank String complement,
                    @NotBlank String city,
                    @NotNull Country country,
                    @NotBlank String phone,
                    @NotBlank String cep) {
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.document = document;
        this.address = address;
        this.complement = complement;
        this.city = city;
        this.country = country;
        this.phone = phone;
        this.cep = cep;
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

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", document='" + document + '\'' +
                ", address='" + address + '\'' +
                ", complement='" + complement + '\'' +
                ", city='" + city + '\'' +
                ", country=" + country +
                ", state=" + state +
                ", phone='" + phone + '\'' +
                ", cep='" + cep + '\'' +
                '}';
    }
}

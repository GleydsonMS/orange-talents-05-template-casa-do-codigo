package br.com.zupacademy.gleydson.casadocodigo.countries;

import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.validation.Valid;

@RestController
@RequestMapping("/countries")
public class CountryController {

    @PersistenceContext
    private EntityManager em;

    @PostMapping
    @Transactional
    public ResponseEntity<CountryResponse> create(@RequestBody @Valid CountryDTO countryDTO) {
        Country country = countryDTO.toModel();
        em.persist(country);
        CountryResponse response = new CountryResponse(country);
        return ResponseEntity.ok().body(response);
    }
}

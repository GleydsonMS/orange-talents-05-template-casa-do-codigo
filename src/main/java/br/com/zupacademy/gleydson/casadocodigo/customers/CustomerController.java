package br.com.zupacademy.gleydson.casadocodigo.customers;

import br.com.zupacademy.gleydson.casadocodigo.validators.ForbidInformStateIfCountryToHaveStates;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.validation.Valid;

@RestController
@RequestMapping("/customers")
public class CustomerController {

    @PersistenceContext
    private EntityManager em;

    @Autowired
    private ForbidInformStateIfCountryToHaveStates forbidInformStateIfCountryToHaveStates;

    @InitBinder
    public void init(WebDataBinder binder) {
        binder.addValidators(forbidInformStateIfCountryToHaveStates);
    }

    @PostMapping
    @Transactional
    public ResponseEntity<CustomerResponse> create(@RequestBody @Valid CustomerDTO customerDTO) {
        Customer customer = customerDTO.toModel(em);
        em.persist(customer);
        CustomerResponse customerResponse = new CustomerResponse(customer);
        return ResponseEntity.ok().body(customerResponse);
    }
}

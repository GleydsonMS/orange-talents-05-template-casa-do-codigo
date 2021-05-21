package br.com.zupacademy.gleydson.casadocodigo.states;

import br.com.zupacademy.gleydson.casadocodigo.validators.ForbidStateNameInSameCountry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.validation.Valid;

@RestController
@RequestMapping("/states")
public class StateController {

    @PersistenceContext
    private EntityManager em;

    @Autowired
    private ForbidStateNameInSameCountry forbidStateNameInSameCountry;

    @InitBinder
    public void init(WebDataBinder binder) {
        binder.addValidators(forbidStateNameInSameCountry);
    }

    @PostMapping
    @Transactional
    public ResponseEntity<?> create(@RequestBody @Valid StateDTO stateDTO) {
        State state = stateDTO.toModel(em);
        em.persist(state);
        StateResponse response = new StateResponse(state);
        return ResponseEntity.ok().body(response);
    }
}

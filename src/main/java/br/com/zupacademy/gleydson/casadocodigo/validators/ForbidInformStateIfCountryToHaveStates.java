package br.com.zupacademy.gleydson.casadocodigo.validators;

import br.com.zupacademy.gleydson.casadocodigo.customers.CustomerDTO;
import br.com.zupacademy.gleydson.casadocodigo.states.State;
import br.com.zupacademy.gleydson.casadocodigo.states.StateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.util.List;
import java.util.Optional;

@Component
public class ForbidInformStateIfCountryToHaveStates implements Validator {

    @Autowired
    private StateRepository stateRepository;

    @Override
    public boolean supports(Class<?> aClass) {
        return CustomerDTO.class.isAssignableFrom(aClass);
    }

    @Override
    public void validate(Object value, Errors errors) {
        if (errors.hasErrors()) {
            return;
        }

        CustomerDTO customerDTO = (CustomerDTO) value;
        Optional<State> st = stateRepository.findById(customerDTO.getStateId());

        if(st.get().getCountry().getId() != customerDTO.getCountryId()) {
            errors.rejectValue("countryId", null, "O país informado não possui este estado.");
        }

        List<State> state = stateRepository.findByCountryId(customerDTO.getCountryId());

        if(!state.isEmpty() && customerDTO.getStateId() == null) {
            errors.rejectValue("stateId", null,"Deve ser informado um estado para este país.");
        }
    }
}

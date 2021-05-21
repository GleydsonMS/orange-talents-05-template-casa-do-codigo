package br.com.zupacademy.gleydson.casadocodigo.validators;

import br.com.zupacademy.gleydson.casadocodigo.states.State;
import br.com.zupacademy.gleydson.casadocodigo.states.StateDTO;
import br.com.zupacademy.gleydson.casadocodigo.states.StateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.util.Optional;

@Component
public class ForbidStateNameInSameCountry implements Validator {

    @Autowired
    private StateRepository stateRepository;

    @Override
    public boolean supports(Class<?> aClass) {
        return StateDTO.class.isAssignableFrom(aClass);
    }

    @Override
    public void validate(Object value, Errors errors) {
        if (errors.hasErrors()) {
            return;
        }

        StateDTO request = (StateDTO) value;
        Optional<State> state =  stateRepository.findByNameAndCountryId(request.getName(), request.getCountryId());

        if(state.isPresent()) {
            errors.rejectValue("name", null, "Já existe um estado com o mesmo nome neste pais. " +
                    request.getName());
        }
    }
}

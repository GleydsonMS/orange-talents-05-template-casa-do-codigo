package br.com.zupacademy.gleydson.casadocodigo.validators;

import br.com.zupacademy.gleydson.casadocodigo.states.StateDTO;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.List;

public class UniqueValueInSameCountryValidator implements ConstraintValidator<UniqueValueInSameCountry, StateDTO> {

    private Class<?> aClass;
    private String domainAttribute;

    @PersistenceContext
    private EntityManager em;

    @Override
    public void initialize(UniqueValueInSameCountry params) {
        domainAttribute = params.fieldName();
        aClass = params.domainClass();
    }

    @Override
    public boolean isValid(StateDTO value, ConstraintValidatorContext context) {
        Query query = em.createQuery("select 1 from " + aClass.getName() + " where " + domainAttribute + "=:value1"
                + " and country_id=:value2");
        query.setParameter("value1", value.getName());
        query.setParameter("value2", value.getCountryId());
        List<Query> list = query.getResultList();

        return list.isEmpty();
    }
}

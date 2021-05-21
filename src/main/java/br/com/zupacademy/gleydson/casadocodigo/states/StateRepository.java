package br.com.zupacademy.gleydson.casadocodigo.states;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StateRepository extends CrudRepository<State, Long> {

    Optional<State> findByNameAndCountryId(String name, Long countryId);
}

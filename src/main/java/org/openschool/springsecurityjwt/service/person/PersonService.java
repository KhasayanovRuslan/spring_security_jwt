package org.openschool.springsecurityjwt.service.person;

import org.openschool.springsecurityjwt.domain.model.person.Person;

import java.util.List;
import java.util.Optional;


public interface PersonService {

    List<Person> getAllPerson();

    Optional<Person> getPersonById(Long id);

    void deleteMyPersonById(Long id);

}

package org.openschool.springsecurityjwt.service.person;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.openschool.springsecurityjwt.domain.model.person.Person;
import org.openschool.springsecurityjwt.exception.NoSuchPersonEndpointException;
import org.openschool.springsecurityjwt.repository.person.PersonRepository;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PersonServiceImpl implements PersonService {

    private final PersonRepository personRepository;

    @Override
    @Transactional
    public List<Person> getAllPerson() {
        return new ArrayList<>(personRepository.findAll());
    }

    @Override
    @Transactional
    public Optional<Person> getPersonById(Long id) {
        return Optional.ofNullable(personRepository.findById(id)
                .orElseThrow(() -> new NoSuchPersonEndpointException("Такого пользователя в базе нет")));
    }

    @Override
    @Transactional
    public void deleteMyPersonById(Long id) {
        personRepository.deleteById(id);
    }
}

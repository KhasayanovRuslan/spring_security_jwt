package org.openschool.springsecurityjwt.repository.person;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.openschool.springsecurityjwt.domain.model.person.Person;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {
}

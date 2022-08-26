package by.spring.securityapp.repository;


import by.spring.securityapp.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface  PeopleRepository extends JpaRepository<Person, Integer> {
    Optional<Person> findPersonByUsername(String username);
}

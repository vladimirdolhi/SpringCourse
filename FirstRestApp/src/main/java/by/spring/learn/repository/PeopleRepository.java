package by.spring.learn.repository;

import by.spring.learn.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



    @Repository
    public interface PeopleRepository extends JpaRepository<Person, Integer> {
    }


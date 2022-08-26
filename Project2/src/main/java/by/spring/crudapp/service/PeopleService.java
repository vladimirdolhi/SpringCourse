package by.spring.crudapp.service;


import by.spring.crudapp.model.Book;
import by.spring.crudapp.model.Person;
import by.spring.crudapp.repository.PeopleRepository;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.ManyToMany;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class PeopleService {

    private final PeopleRepository peopleRepository;


    @Autowired
    public PeopleService(PeopleRepository peopleRepository) {
        this.peopleRepository = peopleRepository;

    }

    public List<Person> findAll(){
        return peopleRepository.findAll();
    }


    public Person findById(int id){
        Optional<Person> person = peopleRepository.findById(id);
        return person.orElse(null);
    }

    @Transactional
    public void save(Person person){
        peopleRepository.save(person);
    }

    @Transactional
    public void update(int id, Person updatedPerson){
        updatedPerson.setId(id);
        peopleRepository.save(updatedPerson);
    }

    @Transactional
    public void delete(int id){
        peopleRepository.deleteById(id);
    }


    @Transactional
    public List<Book> getBooksByPersonId(int id){

        Optional<Person> person = peopleRepository.findById(id);

        Hibernate.initialize(person.get().getBooks());

        if(person.isPresent()){

            person.get().getBooks().forEach(book ->{
                double diff = Math.abs(book.getTakenAt().getTime() - new Date().getTime());

                if (diff > 1209600000){
                    book.setExpired(true);
                } else {
                    book.setExpired(false);
                }

            });

            return person.get().getBooks();
        } else return Collections.emptyList();
    }

    public Optional<Person> findPersonByFullName(String fullName){
        return peopleRepository.findPersonByFullName(fullName);
    }



}

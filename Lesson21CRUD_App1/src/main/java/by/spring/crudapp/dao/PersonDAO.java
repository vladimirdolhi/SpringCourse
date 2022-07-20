package by.spring.crudapp.dao;

import by.spring.crudapp.model.Person;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class PersonDAO {
    private static int id = 1;
    private List<Person> people;

    {
        people = new ArrayList<>();
        people.add(new Person(id++, "Jack"));
        people.add(new Person(id++, "Bob"));
        people.add(new Person(id++, "Olga"));
        people.add(new Person(id++, "Ann"));


    }

    public List<Person> index(){
        return people;
    }

    public Person show(int id){
        return people.stream().filter(person -> person.getId() == id).findAny().orElse(null);
    }
}

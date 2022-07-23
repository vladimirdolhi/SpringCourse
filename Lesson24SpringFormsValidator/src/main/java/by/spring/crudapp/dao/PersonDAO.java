package by.spring.crudapp.dao;

import by.spring.crudapp.model.Person;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class PersonDAO {
    private static int PEOPLE_COUNT;
    private List<Person> people;

    {
        people = new ArrayList<>();
        people.add(new Person(++PEOPLE_COUNT, "Jack", 20, "jack@gmail.com"));
        people.add(new Person(++PEOPLE_COUNT, "Bob", 18, "bob@gmail.com"));
        people.add(new Person(++PEOPLE_COUNT, "Olga", 25, "olya@mail.ru"));
        people.add(new Person(++PEOPLE_COUNT, "Ann", 21, "ann@yandex.com"));

    }

    public List<Person> index(){
        return people;
    }

    public Person show(int id){
        return people.stream().filter(person -> person.getId() == id).findAny().orElse(null);
    }

    public void save(Person person){
        person.setId(++PEOPLE_COUNT);
        people.add(person);
    }

    public void update(int id, Person updatedPerson){
        Person personToUpdate = show(id);
        personToUpdate.setName(updatedPerson.getName());
        personToUpdate.setAge(updatedPerson.getAge());
        personToUpdate.setEmail(updatedPerson.getEmail());
    }

    public void delete(int id){
        people.removeIf(p -> p.getId() == id);
    }

}

package by.spring.crudapp.dao;

import by.spring.crudapp.model.Book;
import by.spring.crudapp.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class PersonDAO {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public PersonDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Person> index(){
        return jdbcTemplate.query("SELECT * FROM Person", new BeanPropertyRowMapper<>(Person.class));
    }

    public Person show(int id){
        return jdbcTemplate.query("SELECT * FROM Person WHERE id=?", new Object[]{id}, new BeanPropertyRowMapper<>(Person.class))
                .stream().findAny().orElse(null);
    }

    public void save(Person person){
        jdbcTemplate.update("INSERT INTO Person(full_name, birth_year, email) VALUES(?, ?, ?)", person.getFullName(),
                person.getBirthYear(), person.getEmail());

    }

    public void update(int id, Person updatedPerson){
        jdbcTemplate.update("UPDATE Person SET full_name=?, birth_year=? WHERE  id=?", updatedPerson.getFullName(),
                updatedPerson.getBirthYear(), updatedPerson.getId());
        }


    public void delete(int id){
       jdbcTemplate.update("DELETE FROM Person where id=?", id);

    }

    public List<Book> getBooksByPersonId(int id){

        return jdbcTemplate.query("SELECT * FROM Book WHERE person_id =?",  new Object[]{id},
                new BeanPropertyRowMapper<>(Book.class));
    }

    public Optional<Person> findPersonByEmail(String email){
        return jdbcTemplate.query("SELECT * FROM Person WHERE email=?", new Object[]{email}, new BeanPropertyRowMapper<>(Person.class))
                .stream().findAny();
    }

    public Optional<Person> findPersonByFullName(String fullName){
        return jdbcTemplate.query("SELECT * FROM Person WHERE full_name=?", new Object[]{fullName}, new BeanPropertyRowMapper<>(Person.class))
                .stream().findAny();
    }
}

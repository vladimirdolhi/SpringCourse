package by.spring.crudapp.dao;

import by.spring.crudapp.model.Person;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class PersonMapper implements RowMapper<Person> {
    @Override
    public Person mapRow(ResultSet resultSet, int rowNum) throws SQLException {
        Person person = new Person();

        person.setId(resultSet.getInt("id"));
        person.setFullName(resultSet.getString("name"));
        person.setBirthYear(resultSet.getInt("age"));
        person.setEmail(resultSet.getString("email"));
        return person;
    }
}

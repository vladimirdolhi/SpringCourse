package by.spring.crudapp.util;

import by.spring.crudapp.dao.PersonDAO;
import by.spring.crudapp.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class PersonValidator implements Validator {

    private final PersonDAO personDAO;

    @Autowired
    public PersonValidator(PersonDAO personDAO) {
        this.personDAO = personDAO;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return Person.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        Person person = (Person) target;

        if (personDAO.findPersonByEmail(person.getEmail()).isPresent()){
            errors.rejectValue("email", "", "This email is already taken");
        }

        if (personDAO.findPersonByFullName(person.getFullName()).isPresent()){
            errors.rejectValue("fullName", "", "This full name is already exist");
        }

    }
}

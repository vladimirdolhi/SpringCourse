package by.spring.learn.controller;

import by.spring.learn.exception.PersonNotFoundException;
import by.spring.learn.model.Person;
import by.spring.learn.service.PeopleService;
import by.spring.learn.util.PersonErrorResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/people")
public class PeopleController {

    private final PeopleService peopleService;

    @Autowired
    public PeopleController(PeopleService peopleService) {
        this.peopleService = peopleService;
    }

    @GetMapping
    public List<Person> getPeople(){
        return peopleService.findAll(); //Jackson converts to json
    }

    @GetMapping("/{id}")
    public Person getPerson(@PathVariable("id") int id){
        return peopleService.findOne(id);
    }

    @ExceptionHandler
    private ResponseEntity<PersonErrorResponse> handleException(PersonNotFoundException e){
      PersonErrorResponse response = new PersonErrorResponse(
              "Person with such id not found",
              System.currentTimeMillis()
      );

      return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }
}

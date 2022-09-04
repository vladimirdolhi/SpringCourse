package by.spring.learn.exception;

public class PersonNotCreatedException extends RuntimeException{


    public PersonNotCreatedException(String msg){
        super(msg);
    }
}

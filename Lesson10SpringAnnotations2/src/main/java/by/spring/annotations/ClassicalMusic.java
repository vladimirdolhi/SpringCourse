package by.spring.annotations;

import org.springframework.stereotype.Component;

@Component
public class ClassicalMusic implements Music{


    @Override
    public String getSong() {
        return "Simphony 1";
    }
}

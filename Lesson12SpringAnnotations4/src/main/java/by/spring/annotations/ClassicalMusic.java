package by.spring.annotations;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;


@Component
public class ClassicalMusic implements Music{


    @Override
    public String getSong() {
        return "Simphony 1";
    }

    @PostConstruct
    public void dpMyInit(){
        System.out.println("Doing my initialization");
    }

    @PreDestroy
    public void dpMyDestroy(){
        System.out.println("Doing my destruction");
    }
}

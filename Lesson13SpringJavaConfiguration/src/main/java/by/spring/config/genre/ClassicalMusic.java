package by.spring.config.genre;

import by.spring.config.Music;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;



public class ClassicalMusic implements Music {


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

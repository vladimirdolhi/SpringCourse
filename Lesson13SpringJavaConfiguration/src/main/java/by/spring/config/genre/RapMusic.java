package by.spring.config.genre;

import by.spring.config.Music;
import org.springframework.stereotype.Component;


public class RapMusic implements Music {
    @Override
    public String getSong() {
        return "Changes";
    }
}

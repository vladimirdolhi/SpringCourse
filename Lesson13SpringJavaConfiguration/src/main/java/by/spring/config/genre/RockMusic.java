package by.spring.config.genre;

import by.spring.config.Music;
import org.springframework.stereotype.Component;


public class RockMusic implements Music {
    @Override
    public String getSong() {
        return "Haifisch";
    }
}

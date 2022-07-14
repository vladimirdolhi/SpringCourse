package by.spring.annotations;

import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

@Component
public class RockMusic implements Music{

    private List<String> music = Arrays.asList("Bohemian Rhapsody", "Lithium", "The Bends");
    private Random random = new Random();

    @Override
    public String getSong() {
        return music.get(random.nextInt(music.size()));
    }
}

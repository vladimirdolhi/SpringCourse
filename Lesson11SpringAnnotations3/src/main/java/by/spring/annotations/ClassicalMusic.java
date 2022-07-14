package by.spring.annotations;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

@Component
public class ClassicalMusic implements Music{

    private List<String> music = Arrays.asList("Simphony 1", "Piano Sonata No. 14", "Ave Maria");

    private Random random = new Random();

    @Override
    public String getSong() {
        return music.get(random.nextInt(music.size()));
    }
}

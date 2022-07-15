package by.spring.config;

import by.spring.config.config.SpringConfig;
import by.spring.config.genre.ClassicalMusic;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class TestSpring {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(
                SpringConfig.class
        );


       MusicPlayer musicPlayer = context.getBean("musicPlayer", MusicPlayer.class);

       System.out.println(musicPlayer.getName() + " " + musicPlayer.getVolume());

        System.out.println(musicPlayer.playMusic());

       context.close();
    }
}

package by.spring.annotations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class MusicPlayer {


    private Music music1;
    private Music music2;

    @Autowired
    public MusicPlayer(@Qualifier("classicalMusic") Music music1,
                       @Qualifier("rockMusic") Music music2) {
        this.music1 = music1;
        this.music2 = music2;
    }

    public String playMusic(Genre genre){
        switch (genre){
            case CLASSICAL:
                return "Playing: " + music1.getSong();

            case ROCK:
                return "Playing: " + music2.getSong();

            default:
                return "Playing default music";
        }
    }


}

package by.spring.annotations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Computer {

    private int id;
    private MusicPlayer musicPlayer;

    @Autowired
    public Computer(MusicPlayer musicPlayer){
        this.id = 1;
        this.musicPlayer = musicPlayer;
    }

    public void playMusic(Genre genre){
        System.out.println(musicPlayer.playMusic(genre));
    }
    @Override
    public String toString() {
        return "Computer{" +
                "id=" + id +
                "\n" + musicPlayer +
                '}';
    }
}

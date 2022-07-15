package by.spring.config;

import by.spring.config.genre.ClassicalMusic;
import by.spring.config.genre.RapMusic;
import by.spring.config.genre.RockMusic;
import org.springframework.beans.factory.annotation.Value;

import java.util.List;
import java.util.Random;


public class MusicPlayer {

    @Value("${musicPlayer.name}")
    private String name;

    @Value("${musicPlayer.volume}")
    private int volume;

    private List<Music> musicList;
    private Random random = new Random();


    public MusicPlayer(List<Music> musicList){
        this.musicList = musicList;
    }

    public String playMusic(){
       return  musicList.get(random.nextInt(musicList.size())).getSong();
    }

    public String getName() {
        return name;
    }

    public int getVolume() {
        return volume;
    }
}

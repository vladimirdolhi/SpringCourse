package by.spring.annotations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MusicPlayer {


    private  ClassicalMusic classicalMusic;

    private  RockMusic rockMusic;

    private  RapMusic rapMusic;


    @Autowired
    public MusicPlayer(ClassicalMusic classicalMusic, RockMusic rockMusic,
                       RapMusic rapMusic){
        this.classicalMusic = classicalMusic;
        this.rockMusic = rockMusic;
        this.rapMusic = rapMusic;
    }

    public String playMusic(){
       return  "Playing:\n" + classicalMusic.getSong() + '\n' + rockMusic.getSong() + '\n' + rapMusic.getSong();
    }


}

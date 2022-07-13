package by.spring.scopes;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestSpring {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
                "applicationContext.xml"
        );

        //Music music = context.getBean("musicBean", Music.class);

        // musicPlayer = new MusicPlayer(music);

        MusicPlayer firstMusicPlayer = context.getBean("musicPlayer", MusicPlayer.class);
        MusicPlayer secondMusicPlayer = context.getBean("musicPlayer", MusicPlayer.class);



        /*System.out.println(musicPlayer.getName());
        System.out.println(musicPlayer.getVolume());*/

        boolean comparison = firstMusicPlayer == secondMusicPlayer;

        firstMusicPlayer.setVolume(100);

        System.out.println(firstMusicPlayer.getVolume());
        System.out.println(secondMusicPlayer.getVolume());

        System.out.println(comparison);
        context.close();
    }
}

package by.spring.annotations;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestSpring {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
                "applicationContext.xml"
        );


       Computer computer = context.getBean("computer", Computer.class);
       computer.playMusic(Genre.ROCK);
       context.close();
    }
}

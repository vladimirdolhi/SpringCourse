package by.spring.beanlifecycle;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestSpring {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
                "applicationContext.xml"
        );


        ClassicalMusic classicalMusic = context.getBean("classicalMusicBean", ClassicalMusic.class);

        System.out.println(classicalMusic.getSong());


        context.close();
    }
}

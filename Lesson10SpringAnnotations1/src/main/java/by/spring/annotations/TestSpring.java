package by.spring.annotations;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestSpring {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
                "applicationContext.xml"
        );


        Music classicalMusic = context.getBean("classicalMusic", Music.class);

        System.out.println(classicalMusic.getSong());

        Music rockMusic = context.getBean("rockMusic", Music.class);

        System.out.println(rockMusic.getSong());

        Music rapMusic = context.getBean("rapMusic", Music.class);

        System.out.println(rapMusic.getSong());


        context.close();
    }
}

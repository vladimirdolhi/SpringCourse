package by.spring.annotations;

import org.springframework.stereotype.Component;

@Component("rapMusic")
public class RapMusic implements Music{
    @Override
    public String getSong() {
        return "Changes";
    }
}

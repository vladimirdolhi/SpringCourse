package by.spring.learn.controller;

import by.spring.learn.security.PersonDetails;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {

    @GetMapping("/hello")
    public String sayHello(){
        return "hello";
    }

    @GetMapping("/showUserInfo")
    @ResponseBody
    public String showUserInfo(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        PersonDetails personDetails = (PersonDetails)authentication.getPrincipal();

        System.out.println(personDetails.getPerson());
        return personDetails.getUsername();

    }

    @GetMapping("/admin")
    public String adminPage(){
        return "admin";
    }


}

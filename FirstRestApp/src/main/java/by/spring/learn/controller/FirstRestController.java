package by.spring.learn.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RequestMapping("/api")
@RestController
public class FirstRestController {


    @GetMapping("/hello")
    public String hello(){
        return "Hello world";
    }

}

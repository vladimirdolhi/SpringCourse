package by.spring.modelintro.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/first")
public class FirstController {

    @GetMapping("/hello")
    public String helloPage(@RequestParam("name") String name,
                            @RequestParam(value = "surname", required = false) String surname){

        System.out.println("Hello, " + name + " "  + surname +"!");

        return "first/hello";
    }

    @GetMapping("/goodbye")
    public String goodbyePage(@RequestParam("name") String name,
                              @RequestParam(value = "surname", required = false) String surname){

        System.out.println("Hello, " + name + " "  + surname +"!");

        return "first/goodbye";
    }


    @GetMapping("/calculator")
    public String calculator(HttpServletRequest request,
                            Model model){

        int a = Integer.parseInt(request.getParameter("a"));
        int b = Integer.parseInt(request.getParameter("b"));
        String action = request.getParameter("action");

        Double result = null;

        switch (action){

            case "multiplication":{
                result = (double) (a * b);
                break;
            }

            case "addiction":{
                result = (double) (a + b);
                break;
            }

            case "subtraction":{
                result = (double) (a - b);
                break;
            }

            case "division":{
                result =  a / (double)b;
            }

        }

        model.addAttribute("result", "result of "
                + action + " with " + a + " and " + b + "= " + result);

        return "first/calculator";
    }

}

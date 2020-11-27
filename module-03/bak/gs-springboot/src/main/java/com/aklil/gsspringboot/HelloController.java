package com.aklil.gsspringboot;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController  // show class is ready for use by Spring MVC to handle web requests
public class HelloController {

    @RequestMapping("/")  // maps '/' to the index() method
    public String index(){
        return "Greetings from Spring Boot!";
    }
}

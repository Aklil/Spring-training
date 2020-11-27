package com.aklil.gsspringboot;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController  // show class is ready for use by Spring MVC to handle web requests
public class HelloController {

    private static Logger logger = LoggerFactory.getLogger(HelloController.class);

    @RequestMapping("/")  // maps '/' to the index() method
    public String index(){

        logger.info("Accepting request ---");
        return "Greetings from Spring Boot!";
    }
}

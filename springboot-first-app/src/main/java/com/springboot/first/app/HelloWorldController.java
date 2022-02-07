package com.springboot.first.app;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

//@Controller
//@ResponseBody //Java object to JSON or XML and send it back to client
@RestController
public class HelloWorldController {

    // GET HTTP Method
    // http://localhost:1954/hello-world
    @GetMapping("/hello-world") // Handles HTTP request
    public String helloWorld(){
        return "Hello World!";
    }
}

package it.myti.academy.backend.controller;

import it.myti.academy.backend.service.HelloWorldService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by david at 2019-02-19
 */
@RestController
public class HelloWorldController {

    private final HelloWorldService helloWorldService;

    @Autowired
    public HelloWorldController(HelloWorldService helloWorldService) {
        this.helloWorldService = helloWorldService;
    }

    @GetMapping("hello")
    public String hello() {
        return helloWorldService.sayHello();
    }

    @PostMapping("hello")
    public String helloAt(@RequestBody() String nome) {
        return helloWorldService.sayHello(nome);
    }

}

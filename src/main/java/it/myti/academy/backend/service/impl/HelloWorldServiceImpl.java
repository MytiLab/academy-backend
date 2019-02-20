package it.myti.academy.backend.service.impl;

import it.myti.academy.backend.service.HelloWorldService;
import org.springframework.stereotype.Service;

/**
 * Created by david at 2019-02-19
 */
@Service
public class HelloWorldServiceImpl implements HelloWorldService {
    @Override
    public String sayHello() {
        return "Hello";
    }

    @Override
    public String sayHello(String who) {
        return String.format("Hello %s!", who);
    }
}

package com.fasheng.li;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("/helloworld")
public class HelloWorldController {

    private HelloWorld helloWorld;

    public HelloWorldController(HelloWorld helloWorld) {
        this.helloWorld = helloWorld;
    }

    @GetMapping
    public String hello() {
        return helloWorld.hello();
    }
}

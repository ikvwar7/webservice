package webservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import webservice.service.HelloService;

@RestController
public class Hello {

    @Autowired
    private HelloService helloService;

    @RequestMapping("/")
    String hello(){
        return helloService.hello();
    }
}

package webservice.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class HelloService {

    private final String hello;

    public HelloService(@Value("${webservice.hello}") String hello) {
        this.hello = hello == null ? "" : hello;
    }

    public String hello() {
        return hello;
    }
}

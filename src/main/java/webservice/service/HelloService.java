package webservice.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class HelloService {

    @Value("${webservice.hello}")
    private String hello;

    public String hello() {
        return hello;
    }
}

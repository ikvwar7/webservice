package webservice.service;

import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class HelloService {

    private Gson gson=new Gson();

    @Value("${webservice.hello}")
    private String hello;

    public String hello() {
        return gson.toJson(hello);
    }
}

package webservice.controller;

import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import webservice.service.DBManagerService;
import webservice.service.HelloService;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
public class HelloController {

    private final HelloService helloService;
    private final DBManagerService dbManagerService;

    @Autowired
    public HelloController(HelloService helloService, DBManagerService dbManagerService) {
        this.helloService = helloService;
        this.dbManagerService = dbManagerService;
    }

    @RequestMapping(value = "/", method = RequestMethod.GET, produces = MediaType.TEXT_PLAIN_VALUE)
    public String hello(HttpServletRequest httpServletRequest) {
        dbManagerService.insertClientInfo(httpServletRequest);
        return helloService.hello();
    }

    @RequestMapping(value = "/getClients", method = RequestMethod.GET)
    public List<Document> getClients(HttpServletRequest htr) {
        List<Document> list = dbManagerService.getClientsInfo();
        return list;
    }
}


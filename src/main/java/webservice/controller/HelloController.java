package webservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import webservice.domain.ClientInfo;
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

    @GetMapping(value = "/", produces = MediaType.TEXT_PLAIN_VALUE)
    public String hello(HttpServletRequest httpServletRequest) {
        dbManagerService.saveClient(httpServletRequest);
        return helloService.hello();
    }

    @GetMapping(value = "/getClients")
    public List<ClientInfo> getClients(HttpServletRequest htr) {
        return dbManagerService.getClients();
    }

    @GetMapping(value = "/getClientByIp/{ip}")
    public List<ClientInfo> findByIp(@PathVariable String ip) {
        return dbManagerService.getByIp(ip);
    }

    @GetMapping(value = "/updateClientByIp/{ip}")
    public void updateByIp(@PathVariable String ip) {
        dbManagerService.updateByIp(ip);
    }

    @GetMapping(value = "/deleteClientByIp/{ip}")
    public void deleteByIp(@PathVariable String ip) {
        dbManagerService.deleteByIp(ip);
    }
}


package webservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
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

    @RequestMapping(value = "/", method = RequestMethod.GET, produces = MediaType.TEXT_PLAIN_VALUE)
    public String hello(HttpServletRequest httpServletRequest) {
        dbManagerService.saveClient(httpServletRequest);
        return helloService.hello();
    }

    @RequestMapping(value = "/getClients", method = RequestMethod.GET)
    public List<ClientInfo> getClients(HttpServletRequest htr) {
        return dbManagerService.getClients();
    }

    @RequestMapping(value = "/getClientByIp/{ip}", method = RequestMethod.GET)
    public List<ClientInfo> findByIp(@PathVariable String ip) {
        return dbManagerService.getByIp(ip);
    }

    @RequestMapping(value = "/updateClientByIp/{ip}", method = RequestMethod.GET)
    public void updateByIp(@PathVariable String ip) {
        dbManagerService.updateByIp(ip);
    }

    @RequestMapping(value = "/deleteClientByIp/{ip}", method = RequestMethod.GET)
    public void deleteByIp(@PathVariable String ip) {
        dbManagerService.deleteByIp(ip);
    }
}


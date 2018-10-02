package webservice.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Document(collection = "clientsInfo")
public class ClientInfo {

    @Id
    public String id;

    public String ip;

    public LocalDateTime currentTime;

    public String browser;

    public ClientInfo(String id, String ip, LocalDateTime currentTime, String browser) {
        this.id = id;
        this.ip = ip;
        this.currentTime = currentTime;
        this.browser = browser;
    }

    public ClientInfo(String ip, LocalDateTime currentTime, String browser) {
        this.ip = ip;
        this.currentTime = currentTime;
        this.browser = browser;
    }

    public ClientInfo() {
    }

    @Override
    public String toString() {
        return "ClientInfo{" +
                "id=" + id +
                ", ip='" + ip + '\'' +
                ", currentTime=" + currentTime +
                ", browser='" + browser + '\'' +
                '}';
    }
}


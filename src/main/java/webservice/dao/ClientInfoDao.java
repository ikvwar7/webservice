package webservice.dao;

import webservice.domain.ClientInfo;

import java.util.List;

public interface ClientInfoDao {

    List<ClientInfo> findAll();

    void save(ClientInfo clientInfo);

    List<ClientInfo> findByIp(String ip);

    Long deleteByIp(String ip);

    Long updateByIp(String ip);

}

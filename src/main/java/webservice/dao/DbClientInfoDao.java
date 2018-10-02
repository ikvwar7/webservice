package webservice.dao;

import com.mongodb.client.result.DeleteResult;
import com.mongodb.client.result.UpdateResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Component;
import webservice.domain.ClientInfo;

import java.util.List;

@Component
public class DbClientInfoDao implements ClientInfoDao {

    private final MongoTemplate mongoTemplate;

    @Autowired
    public DbClientInfoDao(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }

    @Override
    public List<ClientInfo> findAll() {
        return mongoTemplate.findAll(ClientInfo.class);
    }

    @Override
    public void save(ClientInfo clientInfo) {
        mongoTemplate.insert(clientInfo);
    }

    @Override
    public List<ClientInfo> findByIp(String ip) {
        Query query = new Query(Criteria.where("ip").is(ip));
        return mongoTemplate.find(query, ClientInfo.class);
    }

    @Override
    public Long deleteByIp(String ip) {
        Query query = new Query(Criteria.where("ip").is(ip));
        DeleteResult deleteResult = mongoTemplate.remove(query, ClientInfo.class);
        return deleteResult.getDeletedCount();
    }

    @Override
    public Long updateByIp(String ip) {
        Query query = new Query(Criteria.where("ip").is(ip));
        Update update = new Update().set("browser", "Yandex Browser");
        UpdateResult updateResult = mongoTemplate.updateMulti(query, update, ClientInfo.class);
        return updateResult.getModifiedCount();
    }
}

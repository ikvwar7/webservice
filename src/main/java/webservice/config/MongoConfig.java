package webservice.config;

import com.mongodb.MongoClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoDbFactory;

@Configuration
public abstract class MongoConfig extends AbstractMongoConfiguration {
    public MongoConfig() {
        super();
    }

    @Override
    @Bean
    public MongoTemplate mongoTemplate() throws Exception {
        MongoTemplate mongoTemplate = new MongoTemplate(mongoClient(), "ClientsInfo");
        return mongoTemplate;
    }

    @Bean
    @Override
    public MongoDbFactory mongoDbFactory() {
        return new SimpleMongoDbFactory(mongoClient(), "ClientsInfo");
    }

    @Override
    public MongoClient mongoClient() {
        MongoClient mongoClient = new MongoClient("localhost", 27017);
        return mongoClient;
    }
}

package webservice.dao.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Component;
import webservice.domain.User;

import java.util.Optional;

import static com.google.common.base.Preconditions.checkNotNull;
import static org.springframework.data.mongodb.core.query.Criteria.where;
import static org.springframework.data.mongodb.core.query.Query.query;

@Component
public class UserRepositoryImpl implements UserRepositoryCustom {
    private final MongoTemplate mongoTemplate;

    @Autowired
    public UserRepositoryImpl(MongoTemplate mongoTemplate) {
        checkNotNull(mongoTemplate);
        this.mongoTemplate = mongoTemplate;
    }

    @Override
    public Optional<User> findByName(String name) {
        User user = mongoTemplate.findOne(query(where("username").is(name)), User.class);
        return Optional.ofNullable(mongoTemplate.findOne(query(where("username").is(name)), User.class));
    }
}

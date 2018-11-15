package webservice.dao.auth;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;
import webservice.domain.User;

@Component
public interface UserRepository extends CrudRepository<User, String>, UserRepositoryCustom {
}

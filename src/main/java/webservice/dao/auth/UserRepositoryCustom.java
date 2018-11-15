package webservice.dao.auth;

import webservice.domain.User;

import java.util.Optional;

public interface UserRepositoryCustom {
    Optional<User> findByName(String name);
}

package org.web.service;

import org.web.model.User;

import java.util.List;
import java.util.Optional;

public interface UserService {

    User save(User user);

    List<User> getAllUser();

    void update(User user);

    void delete(User user);

    Optional<User> findById(Long id);
}

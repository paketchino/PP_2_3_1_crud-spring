package org.web.service;

import org.web.model.User;

import java.util.List;

public interface UserDaoService {

    void add(User user);

    List<User> getAllUser();

    void update(User user);

    void delete(Long id);

    User findById(Long id);
}

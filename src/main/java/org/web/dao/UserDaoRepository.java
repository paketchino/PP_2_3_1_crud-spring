package org.web.dao;

import org.web.model.User;

import java.util.List;

public interface UserDaoRepository {

    void add(User user);

    List<User> getAllUser();

    void update(User user);

    void delete(User user);

    User findUserById(Long id);

}

package org.web.dao;

import org.springframework.stereotype.Repository;
import org.web.model.User;

import java.util.List;
import java.util.Optional;

@Repository
public class UserDaoImpl {

    private final UserDaoRepository userDaoRepository;

    public UserDaoImpl(UserDaoRepository userDaoRepository) {
        this.userDaoRepository = userDaoRepository;
    }


    public User save(User user) {
        return userDaoRepository.save(user);
    }

    public List<User> getAllUser() {
        return userDaoRepository.getAllUser();
    }

    public void update(User user) {
        userDaoRepository.update(user);
    }

    public void delete(User user) {
        userDaoRepository.delete(user);
    }

    public Optional<User> findUserById(Long id) {
        return userDaoRepository.findUserById(id);
    }
}

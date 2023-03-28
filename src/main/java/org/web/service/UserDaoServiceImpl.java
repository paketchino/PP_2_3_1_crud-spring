package org.web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.web.dao.UserDaoRepository;
import org.web.model.User;

import java.util.List;

@Service
public class UserDaoServiceImpl implements UserDaoService {

    @Autowired
    private UserDaoRepository userDaoRepository;

    @Override
    public void add(User user) {
        userDaoRepository.add(user);
    }

    @Override
    public List<User> getAllUser() {
        return userDaoRepository.getAllUser();
    }

    @Override
    public void update(User user) {
        userDaoRepository.update(user);
    }

    @Override
    public void delete(Long id) {
        userDaoRepository.delete(id);
    }

    @Override
    public User findById(Long id) {
        return userDaoRepository.findUserById(id);
    }
}

package org.web.service;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.web.dao.UserDaoRepository;
import org.web.model.User;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserDaoRepository userDaoRepository;

    private static Logger logger = Logger.getLogger(UserServiceImpl.class);

    public UserServiceImpl(@Autowired UserDaoRepository userDaoRepository) {
        this.userDaoRepository = userDaoRepository;
    }

    @Transactional
    @Override
    public void add(User user) {
        logger.info("Начата операция добавления");
        userDaoRepository.add(user);
    }

    @Override
    public List<User> getAllUser() {
        logger.info("Начата операция поиска всех пользователей");
        return userDaoRepository.getAllUser();
    }

    @Transactional
    @Override
    public void update(User user) {
        logger.info("Начата операция обновления пользователя");
        userDaoRepository.update(user);
    }

    @Transactional
    @Override
    public void delete(User user) {
        logger.info("Начата операция удаления пользователя");
        userDaoRepository.delete(user);
    }

    @Override
    public User findById(Long id) {
        logger.info("Начата операция поиска по id");
        return userDaoRepository.findUserById(id);
    }
}

package org.web.dao;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.web.model.User;
import javax.persistence.*;
import java.util.List;
import java.util.logging.Logger;

@Repository
public class UserDaoRepositoryImpl implements UserDaoRepository {

    @PersistenceContext
    private EntityManager entityManager;

    private static Logger logger = Logger.getLogger("UserDaoRepositoryImpl");

    @Transactional
    @Override
    public void add(User user) {
        entityManager.persist(user);
    }

    @Transactional()
    @Override
    public List<User> getAllUser() {
        return entityManager.createQuery("from User", User.class)
                .getResultList();
    }

    @Transactional
    @Override
    public void update(User user) {
        entityManager.createQuery("update User as u set u.login =:login, u.firstName =:firstName," +
                        " u.secondName =: secondName where u.id =: id")
                .setParameter("login", user.getLogin())
                .setParameter("firstName", user.getFirstName())
                .setParameter("secondName", user.getSecondName())
                .setParameter("id", user.getId())
                .executeUpdate();
    }

    @Transactional
    @Override
    public void delete(Long id) {
        entityManager.createQuery("delete from User as u where u.id =: id")
                .setParameter("id", id).executeUpdate();
    }

    @Transactional
    @Override
    public User findUserById(Long id) {
        return entityManager.createQuery("from User as u where u.id =:id", User.class)
                .setParameter("id", id)
                .getSingleResult();
    }

}

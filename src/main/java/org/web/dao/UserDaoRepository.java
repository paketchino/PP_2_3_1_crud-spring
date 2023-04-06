package org.web.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.web.model.User;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserDaoRepository extends CrudRepository<User, Long> {

    User save(User user);

    @Query("from User")
    List<User> getAllUser();

    void update(User user);

    void delete(User user);

    Optional<User> findUserById(Long id);

}

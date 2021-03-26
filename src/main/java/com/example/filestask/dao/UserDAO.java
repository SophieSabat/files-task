package com.example.filestask.dao;

import com.example.filestask.models.User;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.List;

@AllArgsConstructor
@Repository
public class UserDAO {

    private EntityManager entityManager;

    @Transactional
    public void save(User user) {
        entityManager.persist(user);
    }

    public List<User> findALl() {
        return entityManager.createQuery("select u from User u", User.class).getResultList();
    }
}

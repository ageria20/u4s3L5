package dao;

import entities.User;
import exception.NotFounException;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

import java.util.UUID;

public class UserDAO {
    private EntityManager em;

    public UserDAO(EntityManager em) {
        this.em = em;
    }

    public void saveUser(User user){
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.persist(user);
        transaction.commit();
    }

    public User getById(String id){
        User found = em.find(User.class, UUID.fromString(id));
        if( found == null) throw new NotFounException(id);
        else return found;
    }
}

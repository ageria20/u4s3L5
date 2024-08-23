package dao;

import entities.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

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
}

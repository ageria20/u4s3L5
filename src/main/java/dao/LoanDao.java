package dao;

import jakarta.persistence.EntityManager;

public class LoanDao {
    private EntityManager em;

    public LoanDao(EntityManager em) {
        this.em = em;
    }




}

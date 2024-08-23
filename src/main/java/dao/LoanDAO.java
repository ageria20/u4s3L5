package dao;

import entities.Catalog;
import entities.Loan;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.TypedQuery;

import java.util.List;

public class LoanDAO {
    private EntityManager em;

    public LoanDAO(EntityManager em) {
        this.em = em;
    }

    public void saveLoan(Loan loan){
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.persist(loan);
        transaction.commit();
    }




}

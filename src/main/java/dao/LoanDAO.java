package dao;

import entities.Catalog;
import entities.Loan;
import entities.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.TypedQuery;

import java.util.List;
import java.util.spi.LocaleNameProvider;

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

    public List<Loan> getLoanByCardNumber(long cardNumber){
        TypedQuery<Loan> query = em.createQuery("SELECT l FROM Loan l WHERE l.user.cardNumber = :cardNumber", Loan.class);
        query.setParameter("cardNumber", cardNumber);
        return query.getResultList();
    }

    public List<Loan> getExpiredLoan(){
        TypedQuery<Loan> query = em.createQuery("SELECT l FROM Loan l WHERE l.actualReturn > l.expectedReturn AND l.actualReturn IS NULL", Loan.class);
        return query.getResultList();
    }


}

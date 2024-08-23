package dao;

import entities.Catalog;
import exception.NotFounException;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

import java.util.UUID;

public class CatalogDAO {
    private EntityManager em;

    public void save(Catalog element){
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.persist(element);
        transaction.commit();
    }

    public Catalog findById(String isbn){
        Catalog found = em.find(Catalog.class, UUID.fromString(isbn));
        if( found == null) throw new NotFounException(isbn);
        else return found;
    }

    public void deleteByISBN(String isbn){
        Catalog found = this.findById(isbn);
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.remove(found);
        transaction.commit();
        System.out.println("Element deleted correctly");
    }
}

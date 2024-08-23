package dao;

import entities.Catalog;
import exception.NotFounException;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.TypedQuery;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.List;
import java.util.UUID;

public class CatalogDAO {
    private EntityManager em;

    public CatalogDAO(EntityManager em) {
        this.em = em;
    }

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

    public List<Catalog> findByPubblishedDate(String date) {
        try {
            LocalDate pubblishedDate = LocalDate.parse(date);
            TypedQuery<Catalog> query = em.createQuery("SELECT c FROM Catalog c WHERE c.publishedDate = :date", Catalog.class);
            query.setParameter("date", pubblishedDate);
            return query.getResultList();
        } catch (DateTimeParseException ex) {
            // Gestione dell'errore nel caso in cui la stringa non sia un formato valido per LocalDate
            System.out.println("Errore: la data fornita non è in un formato valido. Usa il formato 'YYYY-MM-DD'.");
            return null;
        }
    }


    public List<Catalog> findByAuthor(String author){
        TypedQuery<Catalog> query = em.createQuery("SELECT c FROM Catalog c WHERE LOWER(c.author) LIKE LOWER(:author)", Catalog.class);
        query.setParameter("author", author);
        return query.getResultList();
    }

    public List<Catalog> findByTitleOrPArtOfIt(String str){
    TypedQuery<Catalog> query = em.createNamedQuery("findByTitleOrPArtOfIt", Catalog.class);
    query.setParameter("title", "%" + str + "%");
    return query.getResultList();
    }
}

package ageria;

import dao.CatalogDAO;
import entities.Book;
import entities.Magazines;
import entities.User;
import enums.Periodicity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.time.LocalDate;

public class Application {
    private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("u4s3L5");

    public static void main(String[] args) {

        EntityManager em = emf.createEntityManager();
        CatalogDAO cd = new CatalogDAO(em);



        Book harryPotter1 = new Book("Harry Potter and the Philosopher's Stone", LocalDate.of(1997, 6, 26), 223, "J.K. Rowling", "Fantasy");
        Book harryPotter2 = new Book("Harry Potter and the Chamber of Secrets", LocalDate.of(1998, 7, 2), 251, "J.K. Rowling", "Fantasy");
        Book harryPotter3 = new Book("Harry Potter and the Prisoner of Azkaban", LocalDate.of(1999, 7, 8), 317, "J.K. Rowling", "Fantasy");
        Book harryPotter4 = new Book("Harry Potter and the Goblet of Fire", LocalDate.of(2000, 7, 8), 636, "J.K. Rowling", "Fantasy");

        Magazines nationalGeographic = new Magazines("National Geographic", LocalDate.of(2024, 8, 1), 120, Periodicity.MONTHLY);
        Magazines timeMagazine = new Magazines("Time", LocalDate.of(2024, 8, 1), 80, Periodicity.HALF_YEARLY);
        Magazines vogue = new Magazines("Vogue", LocalDate.of(2024, 8, 1), 150, Periodicity.MONTHLY);
        Magazines economist = new Magazines("The Economist", LocalDate.of(2024, 8, 1), 100, Periodicity.WEEKLY);

        User frodo = new User( "Frodo", "Baggins", LocalDate.of(2968, 9, 22), 123456789L);
        User aragorn = new User( "Aragorn", "Elessar", LocalDate.of(2931, 3, 1), 987654321L);
        User legolas = new User( "Legolas", "Greenleaf", LocalDate.of(1000, 1, 1), 555555555L);
        User gandalf = new User( "Gandalf", "The Grey", LocalDate.of(2019, 1, 1), 111111111L);

        // book saved
       /* cd.save(harryPotter1);
        cd.save(harryPotter2);
        cd.save(harryPotter3);
        cd.save(harryPotter4);*/

        /*System.out.println("SEARCH BY AUTHOR");
        cd.findByAuthor("J.K. Rowling").forEach(System.out::println);*/


       /* cd.deleteByISBN("19b251b4-778a-49cb-ad5a-36aaf55fa214");*/

/*
        System.out.println("SEARCH BY ISBN");
        System.out.println(cd.findById("11cf0f4f-8616-497c-a373-be3e0cb220bf"));

        System.out.println("SEARCH BY PUBBLISHED DATE");
        cd.findByPubblishedDate("2024-08-01").forEach(System.out::println);
*/

        /*cd.save(nationalGeographic);
        cd.save(timeMagazine);
        cd.save(vogue);
        cd.save(economist);
*/


        System.out.println("TUTTO OK!");
    }
}

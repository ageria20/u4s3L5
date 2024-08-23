package ageria;

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


        System.out.println("TUTTO OK!");
    }
}

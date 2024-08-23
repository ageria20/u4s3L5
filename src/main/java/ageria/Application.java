package ageria;

import dao.CatalogDAO;
import dao.LoanDAO;
import dao.UserDAO;
import entities.*;
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
        UserDAO ud = new UserDAO(em);
        LoanDAO ld = new LoanDAO(em);



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

        User frodoFromDB = ud.getById("2cad3a86-1334-4f4d-ba0c-c2c4ff3e2362");
        User aragornFromDB = ud.getById("668ff292-8647-420e-904c-7e48adfc98af");
        User legolasFromDB = ud.getById("c4296c66-1fe1-49c0-b3c8-52b3306314f0");
        User gandalfFromDB = ud.getById("d8b62967-5c40-4c1a-acb6-0debdc7f940b");

        Catalog elementFromDb = cd.findById("11cf0f4f-8616-497c-a373-be3e0cb220bf");
        Catalog element2FromDb = cd.findById("16d19a5b-99d2-4660-9d6a-e45463570cb3");
        Catalog element3FromDb = cd.findById("19a6d8f8-60a5-472e-a4f3-03dbe9c39c44");
        Catalog element4FromDb = cd.findById("c0b7d98c-a6db-477b-99df-16f7189c0f78");
        Catalog element5FromDb = cd.findById("35a90236-f1f5-4fba-ae86-9694e9e8d557");
        Catalog element6FromDb = cd.findById("5421c2f8-4c66-4dd7-bf01-afec208785ed");
        Catalog element7FromDb = cd.findById("68a97ebf-1da8-48e4-b3a4-a077d1381e9f");
        Catalog element8FromDb = cd.findById("76b2a445-90b1-4543-830e-1842ab4f6754");

        Loan loan1 = new Loan(
                element7FromDb,
                LocalDate.of(2024, 1, 10),
                LocalDate.of(2024, 1, 10).plusMonths(1),
                LocalDate.of(2024, 2, 9), // Returned on time
                frodoFromDB
        );


        Loan loan2 = new Loan(
                elementFromDb,
                LocalDate.of(2024, 2, 15),
                LocalDate.of(2024, 1, 10).plusMonths(1),
                LocalDate.of(2024, 3, 16), // Returned 1 day late
                frodoFromDB
        );

        Loan loan3 = new Loan(
                element3FromDb,
                LocalDate.of(2024, 3, 20),
                LocalDate.of(2024, 1, 10).plusMonths(1),
                null, // Returned early
                frodoFromDB
        );

        Loan loan4 = new Loan(
                element4FromDb,
                LocalDate.of(2024, 4, 25),
                LocalDate.of(2024, 1, 10).plusMonths(1),
                LocalDate.of(2024, 5, 25), // Returned on time
                frodoFromDB
        );

        Loan loan5 = new Loan(
                element8FromDb,
                LocalDate.of(2024, 1, 5),
                LocalDate.of(2024, 1, 10).plusMonths(1),
                null, // Returned 1 day late
                aragornFromDB
        );


        Loan loan6 = new Loan(
                element6FromDb,
                LocalDate.of(2024, 2, 10),
                LocalDate.of(2024, 1, 10).plusMonths(1),
                LocalDate.of(2024, 3, 8), // Returned early
                aragornFromDB
        );


        Loan loan7 = new Loan(
                element2FromDb,
                LocalDate.of(2024, 3, 15),
                LocalDate.of(2024, 1, 10).plusMonths(1),
                LocalDate.of(2024, 4, 15), // Returned on time
                aragornFromDB
        );


        Loan loan8 = new Loan(
                element5FromDb,
                LocalDate.of(2024, 4, 20),
                LocalDate.of(2024, 4, 20).plusMonths(1),
                null, // Returned 2 days late
                aragornFromDB
        );
       /* Loan loan9 = new Loan(
                elementFromDb,
                LocalDate.of(2024, 1, 1),
                LocalDate.of(2024, 1, 10).plusMonths(1),
                LocalDate.of(2024, 2, 1), // Returned on time
                legolasFromDB
        );


        Loan loan10 = new Loan(
                element2FromDb,
                LocalDate.of(2024, 2, 5),
                LocalDate.of(2024, 2, 5).plusMonths(1),
                LocalDate.of(2024, 3, 7), // Returned 2 days late
                legolasFromDB
        );

        Loan loan11 = new Loan(
                element3FromDb,
                LocalDate.of(2024, 3, 10),
                LocalDate.of(2024, 3, 10).plusMonths(1),
                LocalDate.of(2024, 4, 10), // Returned on time
                legolasFromDB
        );


        Loan loan12 = new Loan(
                element7FromDb,
                LocalDate.of(2024, 4, 15),
                LocalDate.of(2024, 5, 15).plusMonths(1),
                LocalDate.of(2024, 5, 16), // Returned 1 day late
                legolasFromDB
        );

        Loan loan13 = new Loan(
                element4FromDb,
                LocalDate.of(2024, 1, 15),
                LocalDate.of(2024, 1, 15).plusMonths(1),
                LocalDate.of(2024, 2, 15), // Returned on time
                gandalfFromDB
        );


        Loan loan14 = new Loan(
                element6FromDb,
                LocalDate.of(2024, 2, 20),
                LocalDate.of(2024, 2, 20).plusMonths(1),
                LocalDate.of(2024, 3, 21), // Returned 1 day late
                gandalfFromDB
        );


        Loan loan15 = new Loan(
                element8FromDb,
                LocalDate.of(2024, 3, 25),
                LocalDate.of(2024, 3, 25).plusMonths(1),
                LocalDate.of(2024, 4, 25), // Returned on time
                gandalfFromDB
        );

        Loan loan16 = new Loan(
                elementFromDb,
                LocalDate.of(2024, 4, 30),
                LocalDate.of(2024, 4, 30).plusMonths(1),
                LocalDate.of(2024, 6, 1), // Returned 2 days late
                gandalfFromDB
        );*/

        // loan save
   /*     ld.saveLoan(loan1);
        ld.saveLoan(loan2);*/



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
  /*      ud.saveUser(frodo);
        ud.saveUser(aragorn);
        ud.saveUser(legolas);
        ud.saveUser(gandalf);*/

     /*   System.out.println("SEARCH BY TITLE OR PART OF IT");
        cd.findByTitleOrPArtOfIt("time").forEach(System.out::println);


*/
       /* ld.getLoanByCardNumber(111111111L).forEach(System.out::println);*/


        System.out.println("Expired Loan RESULTS");
        System.out.println(ld);
        ld.getExpiredLoan().forEach(System.out::println);
        /*cd.save(nationalGeographic);
        cd.save(timeMagazine);
        cd.save(vogue);
        cd.save(economist);
*/


        System.out.println("TUTTO OK!");
    }
}

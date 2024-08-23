package ageria;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class Application {
    private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("u4s3L5");

    public static void main(String[] args) {

        EntityManager em = emf.createEntityManager();

        System.out.println("Hello World!");
    }
}

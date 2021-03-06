package au.com.polly.yikes;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.Arrays;

public class Main {
  public static void main(String[] args) {
    System.out.println("Hello World!");
    System.out.flush();
    EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("sandbox");
    EntityManager entityManager = entityManagerFactory.createEntityManager();

    Account polly = new Account();
    polly.setCode("POLLY");
    polly.setCreated(new java.util.Date());

    User david = new User();
    david.setAccount(polly);
    david.setCreated(new java.util.Date());
    david.setLogin("david");
    david.setMobile("0439464812");
    david.setEmail("transitdave@gmail.com");
    david.setFirstName("David");
    david.setSurname("Young");

    User alan = new User();
    alan.setAccount(polly);
    alan.setCreated(new java.util.Date());
    alan.setLogin("alan");
    alan.setFirstName("Alan");
    alan.setSurname("Phillips");

    polly.setUsers(Arrays.asList(david, alan));

    EntityTransaction transaction = entityManager.getTransaction();
    try {
      transaction.begin();
      entityManager.persist(polly);
      transaction.commit();
    } catch (Exception e) {
      System.err.println("Failed to persist account");
      System.err.println(e.getClass().getName() + " - " + e.getMessage());
      e.printStackTrace(System.err);
      System.err.flush();
    }

    System.exit(0);
  }
}

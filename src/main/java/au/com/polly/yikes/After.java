package au.com.polly.yikes;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.Arrays;
import java.util.Collection;

public class After {
  public static void main(String[] args) {
    System.out.println("Hello World!");
    System.out.flush();
    EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("sandbox");
    EntityManager entityManager = entityManagerFactory.createEntityManager();

    EntityTransaction transaction = entityManager.getTransaction();
    try {
      transaction.begin();
      Account polly = entityManager.find(Account.class, 1001);
      Collection<User> users = polly.getUsers();
      User mashnew = new User();
      mashnew.setLogin("mashnew");
      mashnew.setAccount(polly);
      mashnew.setFirstName("Matthew");
      mashnew.setSurname("Phillips");
      mashnew.setDescription("Mashy child");
      users.add(mashnew);
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

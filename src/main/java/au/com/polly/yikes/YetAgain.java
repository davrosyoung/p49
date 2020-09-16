package au.com.polly.yikes;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.Collection;

public class YetAgain {
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
      User david = polly.getUsers().stream().filter(user -> "Young".equals(user.getSurname())).findFirst().orElse(null);
      david.setDescription("Brock Boy");
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

package au.com.polly.yikes;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="user")
public class User {
  @Id
  private int id;

  @ManyToOne
  @JoinColumn(name = "account_id")
  private Account account;

  @Column(name = "login")
  private String login;

  @Column(name="first_name")
  private String firstName;

  @Column(name="surname")
  private String surname;

  @Column(name="description")
  private String description;

  @Column(name="email")
  private String email;

  @Column(name="mobile")
  private String mobile;

  @Column(name="created")
  private Date created;

  @Column(name="updated")
  private Date updated;
}

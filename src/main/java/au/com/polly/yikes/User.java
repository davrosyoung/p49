package au.com.polly.yikes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.TableGenerator;
import java.util.Date;

@Entity
@Table(name="account_user")
public class User {
  @Id
  @GeneratedValue(generator="IDGenerator")
  @TableGenerator(name="IDGenerator", table="id_generation",
          pkColumnName="id_name", valueColumnName="id_value",
          pkColumnValue="base", allocationSize = 1000)
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

  public User() {
  }

  public User(
          int id,
          Account account,
          String login,
          String firstName,
          String surname,
          String description,
          String email,
          String mobile,
          Date created,
          Date updated) {
    this.id = id;
    this.account = account;
    this.login = login;
    this.firstName = firstName;
    this.surname = surname;
    this.description = description;
    this.email = email;
    this.mobile = mobile;
    this.created = created;
    this.updated = updated;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public Account getAccount() {
    return account;
  }

  public void setAccount(Account account) {
    this.account = account;
  }

  public String getLogin() {
    return login;
  }

  public void setLogin(String login) {
    this.login = login;
  }

  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public String getSurname() {
    return surname;
  }

  public void setSurname(String surname) {
    this.surname = surname;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getMobile() {
    return mobile;
  }

  public void setMobile(String mobile) {
    this.mobile = mobile;
  }

  public Date getCreated() {
    return created;
  }

  public void setCreated(Date created) {
    this.created = created;
  }

  public Date getUpdated() {
    return updated;
  }

  public void setUpdated(Date updated) {
    this.updated = updated;
  }

  @Override
  public String toString() {
    return "User{" + "id=" + id + ", account.id=" + (account != null ? account.getId() : null) + ", login='" + login + '\'' + ", firstName='" + firstName + '\'' + ", surname='" + surname + '\'' + ", description='" + description + '\'' + ", email='" + email + '\'' + ", mobile='" + mobile + '\'' + ", created=" + created + ", updated=" + updated + '}';
  }
}

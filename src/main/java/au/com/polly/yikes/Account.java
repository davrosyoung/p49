package au.com.polly.yikes;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.TableGenerator;
import java.util.Collection;
import java.util.Date;

@Entity
@Table(name = "account")
public class Account {
  @Id
  @GeneratedValue(generator="IDGenerator")
  @TableGenerator(name="IDGenerator", table="id_generation",
          pkColumnName="id_name", valueColumnName="id_value",
          pkColumnValue="base", allocationSize = 1000)
  private int id;

  @Column(name = "code")
  private String code;

  @Column(name = "parent_id")
  private int parentId;

  @Column(name="created")
  private Date created;

  @Column(name="updated")
  private Date updated;

  @OneToMany(mappedBy = "account", cascade = CascadeType.ALL)
  private Collection<User> users;

  public Account() {

  }

  public Account(int id, String code, int parentId, Date created, Date updated, Collection<User> users) {
    this.id = id;
    this.code = code;
    this.parentId = parentId;
    this.created = created;
    this.updated = updated;
    this.users = users;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getCode() {
    return code;
  }

  public void setCode(String code) {
    this.code = code;
  }

  public int getParentId() {
    return parentId;
  }

  public void setParentId(int parentId) {
    this.parentId = parentId;
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

  public Collection<User> getUsers() {
    return users;
  }

  public void setUsers(Collection<User> users) {
    this.users = users;
  }

  @Override
  public String toString() {
    return "Account{" + "id=" + id + ", code='" + code + '\'' + ", parentId=" + parentId + ", created=" + created + ", updated=" + updated + ", users=" + users + '}';
  }
}

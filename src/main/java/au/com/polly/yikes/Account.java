package au.com.polly.yikes;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.Id;

@Entity
@Table(name = "Account")
public class Account {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  private int id;

  @Column(name = "code")
  private String code;

  @Column(name = "parent_id")
  private int parentId;

  @Column(name="created")
  private Date created;

  @Column(name="upated")
  private Date updated;
}

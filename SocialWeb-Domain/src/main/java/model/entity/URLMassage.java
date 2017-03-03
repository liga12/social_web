package model.entity;

import java.io.Serializable;
import javax.persistence.*;

@Entity
@Table(name = "url_message")
public class URLMassage implements Serializable {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Basic(optional = false)
  @Column(name = "id")
  private Integer id;
  @Basic(optional = false)
  @Column(name = "url")
  private String url;

  @JoinColumn(name = "id_user", referencedColumnName = "id", unique = false, nullable = false, insertable = true, updatable = true)
  @OneToOne(optional = false)
  private User user;

  public URLMassage() {
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getUrl() {
    return url;
  }

  public void setUrl(String url) {
    this.url = url;
  }

  public User getUser() {
    return user;
  }

  public void setUser(User user) {
    this.user = user;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }

    URLMassage that = (URLMassage) o;

    if (!id.equals(that.id)) {
      return false;
    }
    return url.equals(that.url);
  }

  @Override
  public int hashCode() {
    int result = id.hashCode();
    result = 31 * result + url.hashCode();
    return result;
  }


  @Override
  public String toString() {
    return "URLMassage{" +
            "id=" + id +
            ", url='" + url + '\'' +
            '}';
  }
}

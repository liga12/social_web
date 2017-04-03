package socit.domain;

import javax.persistence.*;
import java.io.Serializable;

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

  @JoinColumn(name = "id_user", referencedColumnName = "id")
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
  public boolean equals(Object object) {
    // TODO: Warning - this method won't work in the case the id fields are not set
    if (!(object instanceof URLMassage)) {
      return false;
    }
    URLMassage other = (URLMassage) object;
    if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
      return false;
    }
    return true;
  }

  @Override
  public int hashCode() {
    int hash = 0;
    hash += (id != null ? id.hashCode() : 0);
    return hash;
  }

  @Override
  public String toString() {
    return "URLMassage{" +
            "id=" + id +
            ", url='" + url + '\'' +
            '}';
  }
}

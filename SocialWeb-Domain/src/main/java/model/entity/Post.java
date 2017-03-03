package model.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "post")
public class Post implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "likes")
    private int like;
    @Basic(optional = false)
    @Column(name = "date",  insertable = false, updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date date;
    @Column(name = "status")
    private boolean status;
    @Column(name = "comment")
    private String comment;

    @Column(name = "all_user", columnDefinition = "bit(1) default true")
    private boolean allUser;

    @OneToMany( cascade = {CascadeType.ALL, CascadeType.PERSIST, CascadeType.MERGE},mappedBy = "post")
    private List<PhotoPost> photoPostList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "post")
    private List<Bookmark> bookmarkList;
    @JoinColumn(name = "id_user", referencedColumnName = "id", unique = false, nullable = false, insertable = true, updatable = true)
    @ManyToOne(optional = false)
    private User user;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "post")
    private List<Comment> commentList;


    public Post() {
    }

    public Post(Integer id) {
        this.id = id;
    }

    public Post(Integer id, int like, Date date) {
        this.id = id;
        this.like = like;
        this.date = date;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getLike() {
        return like;
    }

    public void setLike(int like) {
        this.like = like;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public boolean getStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public boolean getAllUser() {
        return allUser;
    }

    public void setAllUser(boolean allUser) {
        this.allUser = allUser;
    }

    public List<PhotoPost> getPhotoPostList() {
        return photoPostList;
    }

    public void setPhotoPostList(List<PhotoPost> photoPostList) {
        this.photoPostList = photoPostList;
    }

    public List<Bookmark> getBookmarkList() {
        return bookmarkList;
    }

    public void setBookmarkList(List<Bookmark> bookmarkList) {
        this.bookmarkList = bookmarkList;
    }
//
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Comment> getCommentList() {
        return commentList;
    }

    public void setCommentList(List<Comment> commentList) {
        this.commentList = commentList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Post)) {
            return false;
        }
        Post other = (Post) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Post{" +
                "id=" + id +
                ", like=" + like +
                ", date=" + date +
                ", status=" + status +
                ", comment='" + comment + '\'' +
                ", photoPostList=" + photoPostList +
                ", bookmarkList=" + bookmarkList +
                ", commentList=" + commentList +
                '}';
    }
}

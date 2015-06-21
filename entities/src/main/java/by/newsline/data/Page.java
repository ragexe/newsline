package by.newsline.data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;


@Entity
@Table(name = "t_page", schema = "", catalog = "newsbase")
public class Page extends CustomEntity implements Serializable {
    private static final long serialVersionUID = -373183010734040393L;

    @Id
    @Column(name = "F_PAGE_ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "F_CATEGORY_ID", nullable = false)
    private Category category;

    @Basic
    @Column(name = "F_TITLE")
    private String title;

    @Basic
    @Column(name = "F_TITLE4MENU")
    private String title4menu;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "F_USER_ID", nullable = false)
    private User author;

    @Basic
    @Column(name = "F_DATE", nullable = false, insertable = true, updatable = true)
    private java.sql.Date date;

    @Basic
    @Column(name = "F_MAINTEXT", nullable = false, insertable = true, updatable = true, length = 65535)
    private String maintext;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "page")
    private Set<Comment> comments;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

//    public long getCategory() {
//        return category;
//    }
//
//    public void setCategory(long category) {
//        this.category = category;
//    }
    public Category getCategory() {
    return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle4menu() {
        return title4menu;
    }

    public void setTitle4menu(String title4menu) {
        this.title4menu = title4menu;
    }

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }

    public java.sql.Date getDate() {
        return date;
    }

    public void setDate(java.sql.Date date) {
        this.date = date;
    }

    public String getMaintext() {
        return maintext;
    }

    public void setMaintext(String maintext) {
        this.maintext = maintext;
    }

    public void setComments(Set<Comment> comments) {
        this.comments = comments;
    }

    public Set<Comment> getComments() {
        return comments;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Page that = (Page) o;

        if (author != that.author) return false;
        if (date != null ? !date.equals(that.date) : that.date != null) return false;
        if (id != 0 ? id!=that.id : that.id != 0) return false;
        if (maintext != null ? !maintext.equals(that.maintext) : that.maintext != null) return false;
//        if (category != 0 ? category!=that.category : that.category != 0) return false;
        if (title != null ? !title.equals(that.title) : that.title != null) return false;
        return !(title4menu != null ? !title4menu.equals(that.title4menu) : that.title4menu != null);

    }

    @Override
    public int hashCode() {
        int result = (int) id;
//        result = 31 * result + (int) category;
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + (title4menu != null ? title4menu.hashCode() : 0);
//        result = 31 * result + (int) author;
        result = 31 * result + (date != null ? date.hashCode() : 0);
        result = 31 * result + (maintext != null ? maintext.hashCode() : 0);
        return result;
    }
}

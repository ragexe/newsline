package data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;


/**
 * Created by ragexe on 27.05.2015.
 */
@Entity
@Table(name = "T_PAGE", schema = "", catalog = "newsbase")
public class Page extends CustomEntity implements Serializable {
    private static final long serialVersionUID = -3731830107340403944L;

    @Id
    @Column(name = "F_ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Basic
    @Column(name = "F_PARENTID")
    private long parentid;

    @Basic
    @Column(name = "F_TITLE")
    private String title;

    @Basic
    @Column(name = "F_TITLE4MENU")
    private String title4menu;

    @ManyToOne
    @JoinColumn(name = "F_AUTHOR")
    private User author;

    @Basic
    @Column(name = "F_DATE", nullable = false, insertable = true, updatable = true)
    private Date date;

    @Basic
    @Column(name = "F_MAINTEXT", nullable = false, insertable = true, updatable = true, length = 65535)
    private String maintext;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getParentid() {
        return parentid;
    }

    public void setParentid(long parentid) {
        this.parentid = parentid;
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

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getMaintext() {
        return maintext;
    }

    public void setMaintext(String maintext) {
        this.maintext = maintext;
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
        if (parentid != 0 ? parentid!=that.parentid : that.parentid != 0) return false;
        if (title != null ? !title.equals(that.title) : that.title != null) return false;
        if (title4menu != null ? !title4menu.equals(that.title4menu) : that.title4menu != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) id;
        result = 31 * result + (int) parentid;
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + (title4menu != null ? title4menu.hashCode() : 0);
//        result = 31 * result + (int) author;
        result = 31 * result + (date != null ? date.hashCode() : 0);
        result = 31 * result + (maintext != null ? maintext.hashCode() : 0);
        return result;
    }
}

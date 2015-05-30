package data;

import javax.persistence.*;

/**
 * Created by ragexe on 27.05.2015.
 */
@Entity
@Table(name = "T_PAGE", schema = "", catalog = "newsbase")
public class Page {
    private long id;
    private long parentid;
    private String title;
    private String title4menu;
    private int user;
    private String date;
    private String maintext;

    @Id
    @Column(name = "id", nullable = false, insertable = true, updatable = true, length = 10)
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "parentid", nullable = false, insertable = true, updatable = true, length = 10)
    public long getParentid() {
        return parentid;
    }

    public void setParentid(long parentid) {
        this.parentid = parentid;
    }

    @Basic
    @Column(name = "title", nullable = false, insertable = true, updatable = true, length = 80)
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Basic
    @Column(name = "title4menu", nullable = false, insertable = true, updatable = true, length = 50)
    public String getTitle4menu() {
        return title4menu;
    }

    public void setTitle4menu(String title4menu) {
        this.title4menu = title4menu;
    }

    @Basic
    @Column(name = "user", nullable = false, insertable = true, updatable = true)
    public int getUser() {
        return user;
    }

    public void setUser(int user) {
        this.user = user;
    }

    @Basic
    @Column(name = "date", nullable = false, insertable = true, updatable = true)
    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Basic
    @Column(name = "maintext", nullable = false, insertable = true, updatable = true, length = 65535)
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

        if (user != that.user) return false;
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
        result = 31 * result + user;
        result = 31 * result + (date != null ? date.hashCode() : 0);
        result = 31 * result + (maintext != null ? maintext.hashCode() : 0);
        return result;
    }
}

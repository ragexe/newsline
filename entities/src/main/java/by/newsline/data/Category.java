package by.newsline.data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;


/**
* Created by ragexe on 27.05.2015.
*/
@Entity
@Table(name = "t_category", schema = "", catalog = "newsbase")
public class Category extends CustomEntity implements Serializable {
    private static final long serialVersionUID = -373183010734040395L;

    @Id
    @Column(name = "F_CATEGORY_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Basic
    @Column(name = "F_TITLE")
    private String title;

    @Basic
    @Column(name = "F_TITLE4MENU")
    private String title4menu;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "category")
    private Set<Page> pages;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    public Set<Page> getPages() {
        return pages;
    }

    public void setPages(Set<Page> pages) {
        this.pages = pages;
    }

   /* public Category(String title, StatusEnum status) {
        super(status);
        this.title = title;
    }*/

    @Override
    public String toString() {
        return this.getTitle();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Category that = (Category) o;
        if (id != 0 ? id!=that.id : that.id != 0) return false;
        if (title != null ? !title.equals(that.title) : that.title != null) return false;
        if (title4menu != null ? !title4menu.equals(that.title4menu) : that.title4menu != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) id;
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + (title4menu != null ? title4menu.hashCode() : 0);
        return result;
    }
}

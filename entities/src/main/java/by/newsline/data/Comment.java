package by.newsline.data;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;

/**
* Created by ragexe on 27.05.2015.
*/
@Entity
@Table(name = "t_comment", schema = "", catalog = "newsbase")
public class Comment extends CustomEntity implements Serializable {
    private static final long serialVersionUID = -373183010734040394L;

    @Id
    @Column(name = "F_COMMENT_ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "F_PAGE_ID", nullable = false)
    private Page page;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "F_USER_ID", nullable = false)
    private User user;

    @Basic
    @Column(name = "F_TEXT", nullable = false, insertable = true, updatable = true, length = 65535)
    private String maintext;

    @Basic
    @Column(name = "F_DATE", nullable = false, insertable = true, updatable = true)
    private java.sql.Date date;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Page getPage() {
        return page;
    }

    public void setPage(Page page) {
        this.page = page;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getMaintext() {
        return maintext;
    }

    public void setMaintext(String maintext) {
        this.maintext = maintext;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Comment)) return false;

        Comment comment = (Comment) o;

        if (id != comment.id) return false;
        if (!date.equals(comment.date)) return false;
        if (!maintext.equals(comment.maintext)) return false;
        if (!page.equals(comment.page)) return false;
        return user.equals(comment.user);

    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + page.hashCode();
        result = 31 * result + user.hashCode();
        result = 31 * result + maintext.hashCode();
        result = 31 * result + date.hashCode();
        return result;
    }
}

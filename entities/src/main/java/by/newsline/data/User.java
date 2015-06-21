package by.newsline.data;

import by.newsline.data.util.RoleEnum;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name = "T_USER")
public class User extends CustomEntity implements Serializable {
    private static final long serialVersionUID = -373183010734040392L;
    
    @Id
    @Column(name = "F_USER_ID", nullable = false, insertable = true, updatable = true)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "F_NAME", nullable = false, insertable = true, updatable = true, length = 20)
    private String name;

    @Column(name = "F_LASTNAME", nullable = false, insertable = true, updatable = true, length = 30)
    private String lastname;

    @Column(name = "F_EMAIL", nullable = false, insertable = true, updatable = true, length = 30)
    private String email;

    @Column(name = "F_PASSWORD", nullable = false, insertable = true, updatable = true, length = 20)
    private String password;

//    @Column(name = "F_ROLE", nullable = true, insertable = true, updatable = true, columnDefinition = "TEXT")
    @Column(name = "F_ROLE", nullable = true, insertable = true, updatable = true)
    private int role;



    @Column(name = "F_ACCESS", nullable = true, insertable = true, updatable = true)
    @Enumerated(EnumType.STRING)
    private RoleEnum access;

//    @OneToMany(mappedBy = "author", cascade = CascadeType.ALL, fetch = FetchType.LAZY)1
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "author")
    private Set<Page> pages;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "user")
    private Set<Comment> comments;

    public long getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }

    public Set<Page> getPages() {
        return pages;
    }

    public void setPages(Set<Page> pages) {
        this.pages = pages;
    }

    public void setComments(Set<Comment> comments) {
        this.comments = comments;
    }

    public RoleEnum getAccess() {
        return access;
    }

    public void setAccess(RoleEnum access) {
        this.access = access;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User that = (User) o;

        if (id != that.id) return false;
        if (email != null ? !email.equals(that.email) : that.email != null) return false;
        if (lastname != null ? !lastname.equals(that.lastname) : that.lastname != null) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (password != null ? !password.equals(that.password) : that.password != null) return false;
//        if (role != null ? !role.equals(that.role) : that.role != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) id;
        int var = 28;
        result = var * result + (name != null ? name.hashCode() : 0);
        result = var * result + (lastname != null ? lastname.hashCode() : 0);
        result = var * result + (email != null ? email.hashCode() : 0);
        result = var * result + (password != null ? password.hashCode() : 0);
//        result = var * result + (role != null ? role.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return name;
    }
}

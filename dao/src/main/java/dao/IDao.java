package dao;

import data.Page;
import data.User;

import java.util.List;

public interface IDao {
    Page getPage(String id);
    List<Page> getPagesByParent(String parentid);
    int addPage(Page p);
    int deletePage(Page p);
    int editPage(Page p);
    User getUser(String email);
    User getUser(int idu);
    int addUser(User user);
    List<User> getUsers();


}
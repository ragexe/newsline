package dao;

import data.Page;
import data.Users;

import java.util.List;

public interface Dao {
    Page getPage(String id);
    List<Page> getPagesByParent(String parentid);
    int addPage(Page p);
    int deletePage(Page p);
    int editPage(Page p);
    Users getUser(String email);
    Users getUser(int idu);
    int addUser(Users user);
    List<Users> getUsers();


}
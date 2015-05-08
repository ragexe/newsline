package dao;

import data.Page;
import data.Users;

import java.util.List;

/**
 * Created by ragexe on 08.05.2015.
 */
public interface Dao {
    Page getPage(String id);
    List<Page> getPagesByParent(String parentid);
    int addPage(Page p);
    int deletePage(Page p);
    int editPage(Page p);
    Users getUser(String email);
    List<Users> getUsers();

}
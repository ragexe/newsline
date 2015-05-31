package util;

import data.Page;
import data.User;

import java.util.List;

/**
 * Created by ragexe on 09.05.2015.
 */
public interface Service {
    Page getPage(long id);
    List<Page> getPagesByParent(long parentid);
    int addPage(Page p);
    int deletePage(Page p);
    int editPage(Page p);
    User getUser(String email);
    User getUser(int idu);
    List<User> getUsers();
}


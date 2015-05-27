import data.Page;
import data.User;

import java.util.List;

/**
 * Created by ragexe on 09.05.2015.
 */
public interface Service {
    Page getPage(String id);
    List<Page> getPagesByParent(String parentid);
    int addPage(Page p);
    int deletePage(Page p);
    int editPage(Page p);
    User getUser(String email);
    User getUser(int idu);
    List<User> getUsers();
}


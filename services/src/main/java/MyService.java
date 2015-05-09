import dao.Dao;
import dao.MyDao;
import data.Page;
import data.Users;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertSame;

/**
 * Created by ragexe on 09.05.2015.
 */
public class MyService implements Service {
    private Dao dao;// = MyDao.getDao();

    public MyService() {
        dao = MyDao.getDao();
    }

    @Override
    public Page getPage(String id) {
        return dao.getPage(id);
    }

    @Override
    public List<Page> getPagesByParent(String parentid) {
        return dao.getPagesByParent(parentid);
    }

    @Override
    public int addPage(Page p) {
        return dao.addPage(p);
    }

    @Override
    public int deletePage(Page p) {
        return dao.deletePage(p);
    }

    @Override
    public int editPage(Page p) {
        return dao.editPage(p);
    }

    @Override
    public Users getUser(String email) {
        return dao.getUser(email);
    }

    @Override
    public  List<Users> getUsers() {
        return dao.getUsers();
    }



}

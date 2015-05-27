import dao.IDao;
import dao.MyDao;
import data.Page;
import data.User;

import java.util.List;

import static org.junit.Assert.assertSame;
/**
 * Created by ragexe on 09.05.2015.
 */
public class MyService implements Service {
    private IDao dao;// = MyDao.getDao();

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
    public User getUser(String email) {
        return dao.getUser(email);
    }

    @Override
    public User getUser(int idu) {
        return dao.getUser(idu);
    }

    @Override
    public List<User> getUsers() {
        return dao.getUsers();
    }
}

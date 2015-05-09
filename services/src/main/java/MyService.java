import dao.Dao;
import data.Page;
import data.Users;

import java.util.List;

/**
 * Created by ragexe on 09.05.2015.
 */
public class MyService implements  Service{
    private Dao MyDao;

    public MyService(Dao myDao) {
        MyDao = myDao;
    }

    @Override
    public Page getPage(String id) {
        return MyDao.getPage(id);
    }

    @Override
    public List<Page> getPagesByParent(String parentid) {
        return MyDao.getPagesByParent(parentid);
    }

    @Override
    public int addPage(Page p) {
        return MyDao.addPage(p);
    }

    @Override
    public int deletePage(Page p) {
        return MyDao.deletePage(p);
    }

    @Override
    public int editPage(Page p) {
        return MyDao.editPage(p);
    }

    @Override
    public Users getUser(String email) {
        return MyDao.getUser(email);
    }

    @Override
    public List<Users> getUsers() {
        return MyDao.getUsers();
    }
}

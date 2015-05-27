import dao.IDao;

import dao.MyDao;
import org.junit.Test;

import static org.junit.Assert.assertNotNull;

/**
 * Created by HappyQ on 10.05.2015.
 */
public class TestGetUsers {
    @Test
    public void TestGetUsers(){
        IDao dao = MyDao.getDao();
        dao.getUsers();
        assertNotNull("Users not null", dao.getUsers());
    }

}

import dao.Dao;

import dao.MyDao;
import org.junit.Test;

import static org.junit.Assert.assertNotNull;

public class TestGetPage {
    @Test
    public void TestGetPage(){
        Dao dao = MyDao.getDao();
        dao.getPage("main");
        assertNotNull("Page not null", dao.getPage("main"));//
    }
}

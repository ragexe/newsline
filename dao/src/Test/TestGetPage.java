import dao.IDao;

import dao.MyDao;
import org.junit.Test;

import static org.junit.Assert.assertNotNull;

public class TestGetPage {
    @Test
    public void TestGetPage(){
        IDao dao = MyDao.getDao();
        dao.getPage("main");
        assertNotNull("Page not null", dao.getPage("main"));
    }
}

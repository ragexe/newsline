package commands;

//import dao.IDao;
//import dao.MyDao;
import data.Page;

import org.apache.log4j.Logger;
import util.IPageService;
import util.PageService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class AddWriteCommand extends Command {
    private static final Logger log = Logger.getLogger(AddWriteCommand.class);
    private IPageService pageService;

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) {
        Page page = new Page();
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date date = new Date();
        System.out.println(dateFormat.format(date));
//        IDao dao = MyDao.getDao();
        try {
            pageService = PageService.getInstance();
//            page.setId(Long.parseLong(request.getParameter("id")));
            page.setParentid(Long.parseLong(request.getParameter("parentid")));
            page.setTitle(request.getParameter("title"));
            page.setTitle4menu(request.getParameter("title4menu"));
//            page.setAuthor(Long.parseLong(request.getParameter("author")));
//            page.setDate((request.getParameter("date")));
            page.setDate(date);
            page.setMaintext(request.getParameter("maintext"));
            pageService.savePage(page);
//            dao.addPage(page);
            response.sendRedirect("/main.jsp");
        } catch (IOException e) {
            log.error("IOException � ������ execute ������ AddWriteCommand! -- " + e); // ������ � ���-����
            e.printStackTrace();
        } catch (NumberFormatException e2) {
            log.error("NumberFormatException � ������ execute ������ AddWriteCommand! -- " + e2); // ������ � ���-����
            e2.printStackTrace();
        } catch (NullPointerException e1) {
            log.error("NullPointerException � ������ execute ������ AddWriteCommand! -- " + e1); // ������ � ���-����
            e1.printStackTrace();
        }
    }
}

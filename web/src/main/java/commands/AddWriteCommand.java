package commands;

//import dao.IDao;
//import dao.MyDao;
import data.Page;
import org.apache.log4j.Logger;
import util.IPageService;
import util.IUserService;
import util.PageService;
import util.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;

public class AddWriteCommand extends Command {
    private static final Logger log = Logger.getLogger(AddWriteCommand.class);
    private IPageService pageService;
    private IUserService userService;

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) {
        Page page = new Page();
        java.util.Date utilDate = new java.util.Date();
        java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
        try {
            pageService = PageService.getInstance();
            userService = UserService.getInstance();
            page.setParentid(Long.parseLong(request.getParameter("parentid")));
            page.setTitle(request.getParameter("title"));
            page.setTitle4menu(request.getParameter("title4menu"));
            page.setAuthor(userService.getUserById(Long.parseLong(request.getParameter("author"))));
//            page.setAuthor(userService.getUserByEmail("ragexe"));
            page.setDate(sqlDate);
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

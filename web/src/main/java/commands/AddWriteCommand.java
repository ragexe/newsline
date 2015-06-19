package commands;

//import dao.IDao;
//import dao.MyDao;
import by.newsline.service.ICategoryService;
import by.newsline.service.IPageService;
import by.newsline.service.IUserService;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AddWriteCommand extends Command {
    private static final Logger log = Logger.getLogger(AddWriteCommand.class);
    private IPageService pageService;
    private IUserService userService;
    private ICategoryService categoryService;

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) {
        /*Page page = new Page();
        java.util.Date utilDate = new java.util.Date();
        java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
        try {
            pageService = PageService.getInstance();
            userService = UserService.getInstance();
            categoryService = CategoryService.getInstance();
//            page.setParentid(Long.parseLong(request.getParameter("parentid")));
            page.setParentid(categoryService.getCategoryById(Long.parseLong(request.getParameter("parentid"))));
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
        }*/
    }
}

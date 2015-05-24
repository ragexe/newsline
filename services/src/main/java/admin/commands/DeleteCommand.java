package admin.commands;

import dao.Dao;
import dao.MyDao;
import data.Page;
import org.apache.log4j.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class DeleteCommand extends Command {
    private static final Logger log = Logger.getLogger(DeleteCommand.class);
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) {
        response.setContentType("text/html; charset=UTF-8");
//        Page page = new Page();
        Page page;
        page = (Page)request.getAttribute("pageBean");
        Dao dao = MyDao.getDao();
        try {
//            page.setId(request.getParameter("id"));
//            page.setParentid(request.getParameter("parentid"));
//            page.setTitle(request.getParameter("title"));
//            page.setTitle4menu(request.getParameter("title4menu"));
////            page.setUser(request.getParameter("user"));
//            page.setDate(request.getParameter("date"));
//            page.setMaintext(request.getParameter("maintext"));
            dao.deletePage(page);
//            RequestDispatcher dispatcher = request.getRequestDispatcher("admpanel.jsp");
//            try {
//                dispatcher.forward(request, response);
//            } catch (ServletException e) {
//                e.printStackTrace();
//                log.error(e.getMessage());
//            }


            response.sendRedirect("admpanel.jsp");
        } catch (IOException e) {
            log.error("IOException � ������ execute ������ DeleteCommand! -- " + e); // ������ � ���-����
            e.printStackTrace();
        } catch (NumberFormatException e2) {
            log.error("NumberFormatException � ������ execute ������ DeleteCommand! -- " + e2); // ������ � ���-����
            e2.printStackTrace();
        } catch (NullPointerException e1) {
            log.error("NullPointerException � ������ execute ������ DeleteCommand! -- " + e1); // ������ � ���-����
            e1.printStackTrace();
        }
    }

}

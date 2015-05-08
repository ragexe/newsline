package admin.commands;

import dao.Dao;
import dao.MyDao;
import data.Page;
import logger.LogApp;
import logger.TrueLogger;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

public class EditWriteCommand extends Command {
    private static final Logger log = Logger.getLogger(EditWriteCommand.class);

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) {
        Page Page = new Page();
        Dao dao = MyDao.getDao();
//        try {
//            request.setCharacterEncoding("Cp1251");
//        } catch (UnsupportedEncodingException e) {
//            e.printStackTrace();
//        }
        //response.setCharacterEncoding("Cp1251");
        response.setContentType("text/html; charset=UTF-8");
        try {
            Page.setId(request.getParameter("id"));
            Page.setParentid(request.getParameter("parentid"));
            Page.setTitle(request.getParameter("title"));
            Page.setTitle4menu(request.getParameter("title4menu"));
            Page.setUser(Integer.parseInt(request.getParameter("user")));
            Page.setDate(request.getParameter("date"));
            Page.setMaintext(request.getParameter("maintext"));
            dao.editPage(Page);

            response.sendRedirect("adminController");
        } catch (IOException e) {
            log.error("IOException � ������ execute ������ EditWriteCommand! -- " + e); // ������ � ���-����
            e.printStackTrace();
        } catch (NumberFormatException e2) {
            log.error("NumberFormatException � ������ execute ������ EditWriteCommand! -- " + e2); // ������ � ���-����
            e2.printStackTrace();
        } catch (NullPointerException e1) {
            log.error("NullPointerException � ������ execute ������ EditWriteCommand! -- " + e1); // ������ � ���-����
            e1.printStackTrace();
        }

    }

}

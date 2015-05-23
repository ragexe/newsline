package admin;

import admin.commands.*;
import dao.Dao;
import dao.MyDao;
import data.Page;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//import javax.servlet.http.HttpSession;
import java.io.IOException;


public class adminPanel extends HttpServlet {
    private static final long serialVersionUID = 1L;

    Dao dao;

    public adminPanel() {
        super();
        dao = MyDao.getDao();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
//        HttpSession session = request.getSession();
        Command com = null;
        Page page = dao.getPage(request.getParameter("id"));
        request.setAttribute("pageBean", page);
        if ((request.getParameter("operation") != null)) {
            String operation = request.getParameter("operation");
            switch (operation){
                case "add":
                    com = new AddCommand();
                    break;
                case "addwrite":
                    com = new AddWriteCommand();
                    break;
                case "delete":
                    com = new DeleteCommand();
                    break;
                case "edit":
                    com = new EditCommand();
                    break;
                case "editwrite":
                    com = new EditWriteCommand();
                    break;
                default:
                    com = new ShowCommand();
            }
            com.execute(request, response);
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        doGet(request, response);
    }
}

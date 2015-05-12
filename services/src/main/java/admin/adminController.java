package admin;

import admin.commands.*;
import dao.Dao;
import dao.MyDao;
import data.Page;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;


//@WebServlet("/adminController")
public class adminController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    Dao dao;

    public adminController() {
        super();
        dao = MyDao.getDao();
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        HttpSession session = request.getSession();
        Command com = null;
        //String operation = request.getParameter("operation");

        Page Page = dao.getPage(request.getParameter("id"));
        request.setAttribute("Page", Page);

        if (session.getAttribute("loginStatus") == null)/*((session.getAttribute("loginStatus") == null) || !(session.getAttribute("loginStatus").equals("ON")) || (session.getAttribute("login") == null))*/ {
            com = new ToStartCommand();
            //LogApp.log(e);
        } else {
            if ((request.getParameter("operation") != null)) {
                String operation = request.getParameter("operation");

                if ("add".equals(operation)) {
                    com = new AddCommand();
                } else if ("addwrite".equals(operation)) {
                    com = new AddWriteCommand();
                } else if ("delete".equals(operation)) {
                    com = new DeleteCommand();
                } else if ("edit".equals(operation)) {
                    com = new EditCommand();
                } else if ("editwrite".equals(operation)) {
                    com = new EditWriteCommand();
                }
            } else {
                com = new ShowCommand();
                //LogApp.log(e);
            }
        }
        com.execute(request, response);
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        doGet(request, response);
    }

}

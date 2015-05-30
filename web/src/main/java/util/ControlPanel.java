package util;


import commands.*;
import dao.IDao;
import dao.MyDao;
//import data.Page;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet (name = "ControlPanel", urlPatterns = "/control")
public class ControlPanel extends HttpServlet {
    private static final long serialVersionUID = 1L;

    IDao dao;

    public ControlPanel() {
        super();
        dao = MyDao.getDao();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
//        HttpSession session = request.getSession();
//        String id = null;
        Command com;
//        Page page = dao.getPage(request.getParameter("id"));
//        request.setAttribute("pageBean", page);
//
//        if (request.getParameter("subsect") != null)
//            id = request.getParameter("subsect");
//        else
//            id = request.getParameter("sect");
//        Page page = dao.getPage(id);
//        request.setAttribute("pageBean", page);

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
                case "registration":
                    com = new RegCommand();
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
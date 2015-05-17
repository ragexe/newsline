package admin;

import dao.Dao;
import dao.MyDao;
import data.Users;
import org.apache.log4j.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class authoriz extends HttpServlet {
    private static final Logger log = Logger.getLogger(logincorrect.class);

    private static final long serialVersionUID = 2L;

    public authoriz() {
        super();
    }

    @Override
    public void init() throws ServletException {
        super.init();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
//        String target;
        Dao dao = MyDao.getDao();
        HttpSession session = request.getSession();
        if (!request.getParameter("email").equals("")&!request.getParameter("password").equals("")){
            String email = request.getParameter("email");
            String password = request.getParameter("password");
            Users user = dao.getUser(email);
            if (user != null && (user.getPassword().equals(password) && user.getEmail().equals(email))) {
                session.setAttribute("login", user.getName());
                RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
                response.reset();
                dispatcher.forward(request, response);
            }
        }
        else{
            RequestDispatcher dispatcher = request.getRequestDispatcher("incorrectInfo.html");
            dispatcher.include(request, response);
        }
//        if (!request.getParameter("email").equals("")) {
//            String email = request.getParameter("email");
//            String password = request.getParameter("password");
//            Users user = dao.getUser(email);
//            if (user != null && (user.getPassword().equals(password) && user.getEmail().equals(email))) {
//                session.setAttribute("login", user.getIdu());
//                session.setAttribute("loginStatus", "ON");
//                if (request.getParameter("adm") != null)
//                    target = "adminController";
//                else
//                    target = "PageControlPanel";
//
//            } else target = "incorrectInfo.html";
//        } else target = "incorrectInfo.html";//else target = "PageContlorPanel"";
//
//        RequestDispatcher dispatcher = request.getRequestDispatcher(target);
//        try {
//            dispatcher.include(request, response);
//        } catch (IOException e) {
//            log.error(e.getMessage());
//            e.printStackTrace();
//        } catch (Exception e1) {
//            log.error(e1.getMessage());
//            e1.printStackTrace();
//        }
    }


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        doGet(request, response);
    }

}

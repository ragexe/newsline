package admin;

import dao.Dao;
import dao.MyDao;
import data.Users;
import org.apache.log4j.Logger;

import javax.servlet.RequestDispatcher;
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
        Dao dao = MyDao.getDao();
        HttpSession session = request.getSession();
        if (!request.getParameter("email").equals("") & !request.getParameter("password").equals("")) {
            String email = request.getParameter("email");
            String password = request.getParameter("password");
            Users user = dao.getUser(email);
            if (user != null && (user.getPassword().equals(password) && user.getEmail().equals(email))) {
                session.setAttribute("login", user.getName());
                session.setAttribute("role", user.getRole());
//                RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
//                response.reset();
//                dispatcher.forward(request, response);
                response.sendRedirect("/");
            }
        } else {
            RequestDispatcher dispatcher = request.getRequestDispatcher("incorrectInfo.html");
            dispatcher.include(request, response);
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        doGet(request, response);
    }

}

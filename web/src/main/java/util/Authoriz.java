package util;

import data.User;
import org.apache.log4j.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet (name = "Authoriz", urlPatterns = "/authoriz")
public class Authoriz extends HttpServlet {
    private static final Logger log = Logger.getLogger(Authoriz.class);

    private static final long serialVersionUID = 2L;

    public Authoriz() {
        super();
    }

    @Override
    public void init() throws ServletException {
        super.init();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
//        IDao dao = MyDao.getDao();
        UserService userService = UserService.getInstance();
        HttpSession session = request.getSession();
        RequestDispatcher dispatcher = request.getRequestDispatcher("login.jsp");
        if (!request.getParameter("email").equals("") & !request.getParameter("password").equals("")) {
            String email = request.getParameter("email");
            String password = request.getParameter("password");
//            User user = dao.getUser(email);
            User user = userService.getUserByEmail(email);
            if (null != user && (user.getPassword().equals(password) && user.getEmail().equals(email))) {
                session.setAttribute("login", user.getName());
                session.setAttribute("role", user.getRole());
                response.sendRedirect("/");
            } else {
                request.setAttribute("message", "wrong login or password");
                dispatcher.forward(request, response);
            }
        } else {
            request.setAttribute("message", "incorrect login or password");
            dispatcher.forward(request, response);
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        doGet(request, response);
    }

}

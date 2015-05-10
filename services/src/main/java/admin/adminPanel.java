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

/**
 * Servlet implementation class logincorrect
 */
public class adminPanel extends HttpServlet {
    private static final Logger log = Logger.getLogger(adminPanel.class);

    private static final long serialVersionUID = 2L;

    /**
     * @see javax.servlet.http.HttpServlet#HttpServlet()
     */
    public adminPanel() {
        super();
    }

    @Override
    public void init() throws ServletException {
        super.init();
    }

    /**
     * @see javax.servlet.http.HttpServlet#doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //response.setContentType("text/html; charset=cp1251");
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        String target;
        Dao dao = MyDao.getDao();
        HttpSession session = request.getSession();
        if (!request.getParameter("email").equals("")) {
            //LogApp.log(e1);
            //System.out.println("Идентификация - 1");
            String email = request.getParameter("email");
            String password = request.getParameter("password");
            Users user = dao.getUser(email);
            if (user != null && (user.getPassword().equals(password) && user.getEmail().equals(email))) {
                session.setAttribute("login", user.getIdu());
                session.setAttribute("loginStatus", "ON");
                //if (user.getRole() > 0){
                if (request.getParameter("adm") != null)
                    target = "adminController";
                else
                    target = "PageControlPanel";
                //LogApp.log(e1);
                //System.out.println("Идентификация - 2");
            } else target = "incorrectInfo.html";
            //LogApp.log(e1);
            //System.out.println("Идентификация пройдена");
        } else target = "incorrectInfo.html";//else target = "PageContlorPanel"";

        RequestDispatcher dispatcher = request.getRequestDispatcher("adminController");
        try {
            dispatcher.include(request, response);
        } catch (IOException e) {
            log.error(e.getMessage());
            e.printStackTrace();
        } catch (Exception e1) {
            log.error(e1.getMessage());
            e1.printStackTrace();
        }
    }

    /**
     * @see javax.servlet.http.HttpServlet#doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        doGet(request, response);
    }

}

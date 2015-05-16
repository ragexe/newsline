/**
 * Created by ragexe on 16.05.2015.
 */
import data.Page;
import data.Users;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;


public class menu extends HttpServlet {
    private static final long serialVersionUID = 3L;
    //Dao dao;
    private Service service;
    public menu() {}

    public void init() throws ServletException {
        super.init();
        service = new MyService();
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");

        String section = request.getParameter("sect");        //
        String subsection = request.getParameter("subsect");

        //String email = request.getParameter("email");
        //String pass = request.getParameter("password");

        String id;
        if (section == null) {
            id = "main";
        } else if (subsection == null) {
            id = section;
        } else {
            id = subsection;
        }

        Page Page = service.getPage(id);
        //request.setAttribute("Page", Page);
        //StringBuffer menutext = new StringBuffer();
        //menutext.append("<ul>");
        //List<Page> mpages = service.getPagesByParent("main");
        List<Page> mpages = service.getPagesByParent(id);
        List<Page> spages = service.getPagesByParent(id);
        request.setAttribute("result1", mpages);
        request.setAttribute("result2", spages);
        //this.forward("/index.html", request, response);
        //RequestDispatcher dispatcher = request.getRequestDispatcher("/index.jsp");
        //dispatcher.forward(request, response);

//        for (data.Page mpage : mpages) {
//            menutext.append("<li><a href=\"PageControlPanel?email=");
//            menutext.append(email);
//            menutext.append("&sect=");
//            menutext.append(mpage.getId());
//            menutext.append("\">");
//            menutext.append(mpage.getTitle4menu());
//            menutext.append("</a>");
//            List<Page> spages = service.getPagesByParent(mpage.getId());
//            menutext.append("<ul>");
//            if (mpage.getId().equals(section) || section == null) {
//                for (data.Page spage : spages) {
//                    menutext.append("<li><a href=\"PageControlPanel?email=");
//                    menutext.append(email);
//                    menutext.append("&sect=");
//                    menutext.append(mpage.getId());
//                    menutext.append("&subsect=");
//                    menutext.append(spage.getId());
//                    menutext.append("\">");
//                    menutext.append(spage.getTitle4menu());
//                    menutext.append(" - ");
//                    menutext.append(spage.getDate());
//                    menutext.append(" - ");
//                    menutext.append("</a></li>");
//                }
//            }
//            menutext.append("</ul>");
//            menutext.append("</li>");
//        }
//        menutext.append("</ul>");
//        request.setAttribute("pagemenu", menutext.toString());
//        StringBuffer auth = new StringBuffer();
//        String idu = request.getSession().getAttribute("login")+"";
//        Users user = service.getUser(Integer.parseInt(request.getSession().getAttribute("login").toString())); //получаем юзера по idu
//        auth.append("Привет, " + user.getName());//получаем имя пользователя по idu
//        auth.append("<br>");
//        auth.append("<a href=\"mylogin.jsp\">Relogin</a>");
//        if (user.getRole() > 0) {
//            auth.append("<br>");
//            auth.append("<a href=\"adminController\">AdminControl</a>");
//            auth.append("<a href=\"logincorrect?adm=x&email=");
//            auth.append(email);
//            auth.append("&password=");
//            auth.append(pass);
//            auth.append("\">Админк1а</a>");
//        }
//        request.setAttribute("auth", auth.toString());
//        String onmain = "<a href=\"PageControlPanel?email=\"" + email + "\">На главную</a>";
//        request.setAttribute("onmain", onmain);
//        RequestDispatcher dispatcher = request.getRequestDispatcher("/pages.jsp");
//        dispatcher.forward(request, response);
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        doGet(request, response);
    }
//    protected void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//
//        response.setContentType("text/html;charset=UTF-8");
//        request.setCharacterEncoding("UTF-8");
//
//        String section = request.getParameter("sect");        //
//        String subsection = request.getParameter("subsect");
//
//        //String email = request.getParameter("email");
//        //String pass = request.getParameter("password");
//
//        String id;
//        if (section == null) {
//            id = "main";
//        } else if (subsection == null) {
//            id = section;
//        } else {
//            id = subsection;
//        }
//
//        Page Page = service.getPage(id);
//        //request.setAttribute("Page", Page);
//        //StringBuffer menutext = new StringBuffer();
//        //menutext.append("<ul>");
//        List<Page> mpages = service.getPagesByParent("main");
//        request.setAttribute("result", mpages);
//
//        request.getRequestDispatcher("/index.jsp").forward(request, response);
//        return;
//    }
}
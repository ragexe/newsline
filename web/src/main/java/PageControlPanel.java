import data.Page;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;


public class PageControlPanel extends HttpServlet {
    private static final long serialVersionUID = 3L;
    //Dao dao;
    private Service service;
    public PageControlPanel() {

    }

//    @Override
//    public void init() throws ServletException {
//        super.init();
//        dao = MyDao.getDao();
//    }
        @Override
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
        String email = request.getParameter("email");
        String id;
        if (section == null)
        {
            id = "main";
        } else if (subsection == null)
        {
            id = section;
        } else
        {
            id = subsection;
        }

        Page Page = service.getPage(id);
        request.setAttribute("Page", Page);
        StringBuffer menutext = new StringBuffer();
        menutext.append("<ul>");
        List<Page> mpages = service.getPagesByParent("main");
        for (data.Page mpage : mpages) {
            menutext.append("<li><a href=\"PageControlPanel?email=");
            menutext.append(email);
            menutext.append("&sect=");
            menutext.append(mpage.getId());
            menutext.append("\">");
            menutext.append(mpage.getTitle4menu());
            menutext.append("</a>");
            List<Page> spages = service.getPagesByParent(mpage.getId());
            menutext.append("<ul>");
            if (mpage.getId().equals(section) || section == null) {
                for (data.Page spage : spages) {
                    menutext.append("<li><a href=\"PageControlPanel?email=");
                    menutext.append(email);
                    menutext.append("&sect=");
                    menutext.append(mpage.getId());
                    menutext.append("&subsect=");
                    menutext.append(spage.getId());
                    menutext.append("\">");
                    menutext.append(spage.getTitle4menu());
                    menutext.append(" - ");
                    menutext.append(spage.getDate());
                    menutext.append(" - ");
                    menutext.append("</a></li>");

                }
            }
            menutext.append("</ul>");
            menutext.append("</li>");
        }
        menutext.append("</ul>");
        request.setAttribute("pagemenu", menutext.toString());
        StringBuffer auth = new StringBuffer();
        auth.append("Привет, " + email);
        auth.append("<br>");
        auth.append("<a href=\"mylogin.jsp\">Relogin</a>");
        auth.append("<br>");
        auth.append("<a href=\"adminController\">Админка</a>");

        request.setAttribute("auth", auth.toString());
        String onmain = "<a href=\"PageControlPanel?email=\"" + email + "\">На главную</a>";
        request.setAttribute("onmain", onmain);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/pages.jsp");
        dispatcher.forward(request, response);
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


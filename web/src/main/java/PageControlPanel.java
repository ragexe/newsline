import dao.Dao;
import dao.MyDao;
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

    Dao dao;

    public PageControlPanel() {

    }

    @Override
    public void init() throws ServletException {
        super.init();
        dao = MyDao.getDao();
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");

        String section = request.getParameter("sect");        //

        String subsection = request.getParameter("subsect");  //
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
        Page Page = dao.getPage(id);
        request.setAttribute("Page", Page);
        StringBuffer menutext = new StringBuffer();
        menutext.append("<ul>");
        List<Page> mpages = dao.getPagesByParent("main");
        for (int i = 0; i < mpages.size(); i++)
        {
            menutext.append("<li><a href=\"PageControlPanel?sect=");
            menutext.append(mpages.get(i).getId());
            menutext.append("\">");
            menutext.append(mpages.get(i).getTitle4menu());
            menutext.append("</a>");
            List<Page> spages = dao.getPagesByParent(mpages.get(i).getId());
            menutext.append("<ul>");
            if (mpages.get(i).getId().equals(section) || section == null){
                for (int j = 0; j < spages.size(); j++) {
                    menutext.append("<li><a href=\"PageControlPanel?sect=");
                    menutext.append(mpages.get(i).getId());
                    menutext.append("&subsect=");
                    menutext.append(spages.get(j).getId());
                    menutext.append("\">");
                    menutext.append(spages.get(j).getTitle4menu());
                    menutext.append(" - ");
                    menutext.append(spages.get(j).getDate());
                    menutext.append(" - ");
                    menutext.append("</a></li>");

                }
            }
            menutext.append("</ul>");
            menutext.append("</li>");
        }
        menutext.append("</ul>");
        request.setAttribute("pagemenu", menutext.toString());
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


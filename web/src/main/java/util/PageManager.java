package util;

import data.Page;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by ragexe on 17.05.2015.
 */
@WebServlet (name = "util.PageManager", urlPatterns = "/page")
public class PageManager extends HttpServlet {
    private static final long serialVersionUID = 4L;
//    private util.Service service;
    private PageService pageService;
    private Page page;
    public PageManager() {}

    public void init() throws ServletException {
        super.init();
//        service = new util.MyService();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        pageService = PageService.getInstance();
        String sect = request.getParameter("sect");
        String subsect = request.getParameter("subsect");
        String id;
        if (sect.equals("")){
            id = "0";
        } else if (subsect.equals("")){
            id = sect;
        } else{
            id = subsect;
        }
//        page = service.getPage(Long.parseLong(id));
        page = pageService.getPageByPageId(Long.parseLong(id));
        request.setAttribute("pageBean", page);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        doGet(request, response);
    }
}

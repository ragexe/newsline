package util;

import data.Page;
import data.Pages;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;

/**
 * Created by HappyQ on 11.06.2015.
 */
@WebServlet(name="util.PagesManager",urlPatterns = "/pages")
public class PagesManager extends HttpServlet {
    private static final long serialVersionUID = 5L;
    private PageService pagesService;
    private List<Page> pages;

    public PagesManager(){

    }

    public void init() throws ServletException {
        super.init();
    }
    protected void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException{
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        pagesService = PageService.getInstance();
        String sect = request.getParameter("sect");
        //String subsect = request.getParameter("subsect");
        String id;
        if (sect.equals("")) {
            id = "-1";
        }else{
            id = sect;
        }
        pages = pagesService.getListPageByParentid(Long.parseLong(id));
        request.setAttribute("resulty", pages);

    }
    protected void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        doGet(request, response);
    }

}

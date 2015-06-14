package util;

import data.Category;
import data.Page;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by HappyQ on 11.06.2015.
 */
@WebServlet(name="util.PagesManager",urlPatterns = "/test")
public class PagesManager extends HttpServlet {
    private static final long serialVersionUID = 5L;
    private PageService pageService;
    private CategoryService categoryService;
    private List<Page> pages;

    public PagesManager(){

    }

    public void init() throws ServletException {
        super.init();
    }
    protected void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException{
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        categoryService = CategoryService.getInstance();
        pageService = PageService.getInstance();
        String id = request.getParameter("sect");
        if (id.equals("")) {
            id = "0";
        }

        pages = pageService.getListOfPageByCategoryId(Long.parseLong(id));
//        pages = pageService.getAllPages();

        request.setAttribute("page", pages);

    }
    protected void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        doGet(request, response);
    }

}

package util;


import data.Category;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet (name = "util.MenuManager", urlPatterns = "/menu")
public class MenuManager extends HttpServlet {
    //private PageService pageService;
    private CategoryService categoryService;
    private static final long serialVersionUID = 3L;
//    private Service service;
    public MenuManager() {}

    public void init() throws ServletException {
        super.init();
//        service = new MyService();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        categoryService = CategoryService.getInstance();
        //pageService = PageService.getInstance();
        //List<Page> pages = pageService.getListPageByParentid(Long.parseLong(request.getParameter("sect")));
        List<Category> categories = categoryService.getList();
        request.setAttribute("result", categories);
        //request.setAttribute("result", pages);
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

package util;

import data.Page;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by HappyQ on 16.06.2015.
 */
@WebServlet(name="util.Pagination",urlPatterns = "/pagination")
public class Pagination extends HttpServlet{
    private static final long serialVersionUID = 7L;

    private List<Page> pages;

    public Pagination() {
        super();
    }
    public void init() throws ServletException {
        super.init();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int page = 1;
        int recordsPerPage = 5;
        if(request.getParameter("page") != null)
            page = Integer.parseInt(request.getParameter("page"));
        //EmployeeDAO dao = new EmployeeDAO();
        //List<Employe> list = dao.viewAllEmployees((page-1)*recordsPerPage,
       //         recordsPerPage);
        //int noOfRecords = dao.getNoOfRecords();
       // int noOfPages = (int) Math.ceil(noOfRecords * 1.0 / recordsPerPage);
        //request.setAttribute("employeeList", list);
       // request.setAttribute("noOfPages", noOfPages);
        request.setAttribute("currentPage", page);
        RequestDispatcher view = request.getRequestDispatcher("displayEmployee.jsp");
        view.forward(request, response);


    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        doGet(request, response);
    }


}

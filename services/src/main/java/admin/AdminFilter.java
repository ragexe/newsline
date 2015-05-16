package admin;
import dao.Dao;
import dao.MyDao;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.io.PrintWriter;

public class AdminFilter implements Filter{
    Dao dao = MyDao.getDao();

    public void init(FilterConfig arg0) throws ServletException {}

    public void doFilter(ServletRequest req, ServletResponse resp,
                         FilterChain chain) throws IOException, ServletException {
        PrintWriter out=resp.getWriter();
        HttpServletRequest request = (HttpServletRequest) req;
        if (request.getSession()!= null){
            int idu = Integer.parseInt(request.getSession().getAttribute("login").toString());
            if (dao.getUser(idu).getRole() > 0){
                chain.doFilter(req, resp);
        }

        }
        else{
            out.print("username or password error!");
            RequestDispatcher rd=req.getRequestDispatcher("mylogin.jsp");
            rd.include(req, resp);
        }
    }
    public void destroy() {
    }
}

//        public void init(FilterConfig arg0) throws ServletException {}
//
//        public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws IOException, ServletException {
//            chain.doFilter(req, resp);
//        }
//        public void destroy() {}

//}

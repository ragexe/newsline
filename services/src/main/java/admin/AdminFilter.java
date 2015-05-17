package admin;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

public class AdminFilter implements Filter{

    public void init(FilterConfig arg0) throws ServletException {}

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws IOException, ServletException {
        resp.setContentType("text/html;charset=UTF-8");
        req.setCharacterEncoding("UTF-8");
        PrintWriter out = resp.getWriter();
        HttpSession session = ((HttpServletRequest) req).getSession();
        if (session.getAttribute("role").toString().equals("1")){
            chain.doFilter(req, resp);
        }else{
            out.println("username or password error!");
            out.println(session.getAttribute("role").toString());
            out.println("/login.jsp");
//            RequestDispatcher rd = req.getRequestDispatcher("login.jsp");
//            rd.include(req, resp);
        }
    }

    public void destroy() {
    }

}

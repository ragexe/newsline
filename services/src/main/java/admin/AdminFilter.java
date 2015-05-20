package admin;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;
//import java.io.PrintWriter;

public class AdminFilter implements Filter{

    public void init(FilterConfig arg0) throws ServletException {}
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws IOException, ServletException {
        resp.setContentType("text/html;charset=UTF-8");
        req.setCharacterEncoding("UTF-8");
        HttpSession session = ((HttpServletRequest) req).getSession();
//        PrintWriter out = resp.getWriter();
//        out.println("атрибут отсутствует");
        if (null != session.getAttribute("role") && session.getAttribute("role").toString().equals("1")) {
            chain.doFilter(req, resp);
        } else {
            RequestDispatcher rd = req.getRequestDispatcher("login.jsp");
            rd.include(req, resp);
        }
    }
    public void destroy() {
    }
}

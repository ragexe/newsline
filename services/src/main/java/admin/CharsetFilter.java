package admin;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.http.HttpServlet;
import java.io.IOException;

///**
// * Servlet Filter implementation class CharsetFilter
// */
////@WebFilter("/CharsetFilter")
//@WebFilter(
//        urlPatterns = {"/*"},
//        initParams = {
//                @WebInitParam(name = "requestEncoding", value = "UTF-8")
//        })
//public class CharsetFilter implements Filter {
//    private String encoding;
//
//    /**
//     * Default constructor.
//     */
//    public CharsetFilter() {
//    }
//
//    public void destroy() {
//    }
//
//    public void doFilter(ServletRequest request, ServletResponse response, FilterChain next) throws IOException, ServletException {
//        request.setCharacterEncoding(encoding);
//        next.doFilter(request, response);
//    }
//
//    /**
//     * @see Filter#init(FilterConfig)
//     */
//    public void init(FilterConfig fConfig) throws ServletException {
//        encoding = fConfig.getInitParameter("requestEncoding");
//        if (encoding == null) {
//            encoding = "UTF-8";
//        }
//    }
//}


//public class CharsetFilter extends HttpServlet implements Filter {
//
//    private FilterConfig filterConfig;
//
//    public void init(FilterConfig filterConfig) {
//        this.filterConfig = filterConfig;
//    }
//
//    public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain) {
//        try {
//            //request.setCharacterEncoding("Cp1251");
//            request.setCharacterEncoding("UTF-8");
//            filterChain.doFilter(request, response);
//        }
//        catch(ServletException sx) {
//            filterConfig.getServletContext().log(sx.getMessage());
//        }
//        catch(IOException iox) {
//            filterConfig.getServletContext().log(iox.getMessage());
//        }
//    }
//
//}

public class CharsetFilter implements Filter
{
    // кодировка
    private String encoding;

    public void init(FilterConfig config) throws ServletException
    {
        // читаем из конфигурации
        encoding = config.getInitParameter("requestEncoding");

        // если не установлена — устанавливаем Cp1251
        //if( encoding==null ) encoding="Cp1251";
        if( encoding==null ) encoding="UTF-8";
    }

    public void doFilter(ServletRequest request,
                         ServletResponse response, FilterChain next)
            throws IOException, ServletException
    {
        request.setCharacterEncoding(encoding);
        next.doFilter(request, response);
    }
    public void destroy(){}
}



//public class CharsetFilter implements Filter {
//
//    private String encoding = "utf-8";
//
//    public void doFilter(ServletRequest request,
//
//                         ServletResponse response, FilterChain filterChain) throws IOException, ServletException {
//        request.setCharacterEncoding(encoding);
//        filterChain.doFilter(request, response);
//    }
//
//    public void init(FilterConfig filterConfig) throws ServletException {
//        String encodingParam = filterConfig.getInitParameter("encoding");
//        if (encodingParam != null) {
//            encoding = encodingParam;
//        }
//    }
//
//    public void destroy() {
//        // nothing todo
//    }
//
//}

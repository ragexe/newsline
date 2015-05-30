package filters;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import java.io.IOException;

@WebFilter (filterName = "CharsteFilter", urlPatterns = {"/*"}, initParams = {
        @WebInitParam (name= "requestEncoding", value = "UTF-8")
})
public class CharsetFilter implements Filter {
    private String encoding;

    public void init(FilterConfig config) throws ServletException {
        // читаем из конфигурации
        encoding = config.getInitParameter("requestEncoding");
        // если не установлена — устанавливаем UTF-8
        //if( encoding==null ) encoding="UTF-8";
        if(encoding == null) encoding = "UTF-8";
    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain next) throws IOException, ServletException {
        request.setCharacterEncoding(encoding);
        next.doFilter(request, response);
    }

    public void destroy(){
    }
}

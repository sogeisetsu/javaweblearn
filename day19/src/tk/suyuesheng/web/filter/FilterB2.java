package tk.suyuesheng.web.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

@WebFilter("/FilterB2")
public class FilterB2 implements Filter {

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        chain.doFilter(request, response);
    }

    public void init(FilterConfig config) throws ServletException {

    }

    public void destroy() {

    }
}

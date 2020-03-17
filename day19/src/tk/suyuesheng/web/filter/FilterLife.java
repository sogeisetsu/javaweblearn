package tk.suyuesheng.web.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

@WebFilter("/shiyan.jsp")
public class FilterLife implements Filter {

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        System.out.println("filter.......");
        chain.doFilter(request, response);
        System.out.println("after filter..........");
    }

    public void init(FilterConfig config) throws ServletException {
        System.out.println("服务器连接");
    }

    public void destroy() {
        System.out.println("服务器关闭");
    }
}

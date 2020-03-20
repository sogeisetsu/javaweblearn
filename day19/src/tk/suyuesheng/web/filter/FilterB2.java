package tk.suyuesheng.web.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebFilter("/sequence.jsp")
public class FilterB2 implements Filter {

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss.S");
        System.out.println("FilterB2--放行之前--"+dateFormat.format(new Date()));
        chain.doFilter(request, response);
        System.out.println("FilterB2--放行之后--"+dateFormat.format(new Date()));
    }

    public void init(FilterConfig config) throws ServletException {

    }

    public void destroy() {

    }
}

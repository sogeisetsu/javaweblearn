package tk.suyuesheng.web.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 实验设置拦截方式
 * @author 苏月晟
 */
//@WebFilter(value = "/InterceptModeTest.jsp",dispatcherTypes = DispatcherType.FORWARD)//默认是DispatcherType.REQUEST 即只接受正常访问，不接受转发访问
@WebFilter(value = "/*" ,dispatcherTypes = {DispatcherType.REQUEST,DispatcherType.FORWARD})
public class FilterInterceptMode implements Filter {
    //重定向来的也会被拦截
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {

        System.out.println("进入  FilterInterceptModeTestFILTER");
        chain.doFilter(request, response);
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.S");
        String format = dateFormat.format(new Date());
        System.out.println("被拦截成功>------------------------------------"+format);
    }

    public void init(FilterConfig config) throws ServletException {

    }

    public void destroy() {

    }
}

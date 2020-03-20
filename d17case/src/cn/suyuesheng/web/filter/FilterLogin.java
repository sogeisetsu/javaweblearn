package cn.suyuesheng.web.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * 判断是否登录
 */
@WebFilter(urlPatterns = "/*",dispatcherTypes = DispatcherType.REQUEST)//对所有此虚拟目录下的页面进行拦截
public class FilterLogin implements Filter {

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        //强制转换
        HttpServletRequest servletRequest = (HttpServletRequest) request;
        String uri = servletRequest.getRequestURI();
        if(uri.contains("/login.jsp") || uri.contains("/CheckOutDemo") || uri.contains("/ServletLogin") || uri.contains("/css/") || uri.contains("/js/") || uri.contains("/fonts/")){
            //如果是登录页面需要的，就放行
            chain.doFilter(servletRequest, response);
            System.out.println("如果是登录页面需要的，就放行");
        }else{
            //不是登录页面相关就检查是否登录
            if(servletRequest.getSession().getAttribute("user")==null){
                //如果没有登录就跳转到登录页面
                request.setAttribute("loginError", "您还未登录");
                request.getRequestDispatcher("/login.jsp").forward(servletRequest, response);
            }else {
                //如果已经登录，就放行
                chain.doFilter(servletRequest, response);
                System.out.println("如果已经登录，就放行");
            }
        }
    }

    public void init(FilterConfig config) throws ServletException {

    }

    public void destroy() {

    }
}

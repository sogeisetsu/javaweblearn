package tk.suyuesheng.web.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * 检查敏感词汇
 */
@WebFilter("/*")
public class FilterCheckWord implements Filter {
    private List<String> list = new ArrayList<String>();//词汇集合
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        //增强方法

        //增强getParameter方法
        Object proxyRequest = Proxy.newProxyInstance(request.getClass().getClassLoader(), request.getClass().getInterfaces(), new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                if (method.getName().equals("getParameter")) {
                    Object invoke = method.invoke(request, args);
                    String s = (String) invoke;
                    if (s != null) {
                        for (String str : list) {
                            if (s.contains(str)) {
                                String s1 = s.replaceAll(str, "***");
                                System.out.println(s);
                                System.out.println(s1);
                                s=s1;
                            }
                        }
                    }
                    return s;
                }
                return method.invoke(request, args);
            }
        });
        chain.doFilter((HttpServletRequest)proxyRequest, response);
    }

    public void init(FilterConfig config) throws ServletException {
        //导入敏感词汇
        String realPath = config.getServletContext().getRealPath("/WEB-INF/敏感词汇.txt");
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(realPath));
            String str=null;
            while ((str=bufferedReader.readLine())!=null){
                list.add(str);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void destroy() {

    }
}

package cn.itcast.travel.web.servlet;

import cn.itcast.travel.domain.PageBean;
import cn.itcast.travel.domain.Route;
import cn.itcast.travel.service.RouteService;
import cn.itcast.travel.service.impl.RouteServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/route/*")
public class RouteServlet extends BaseServlet {
    private RouteService routeService = new RouteServiceImpl();

    public void pageQuery(HttpServletRequest request,HttpServletResponse response) throws IOException{
        String cid = request.getParameter("cid");
        String currentPageStr = request.getParameter("currentPage");
        String pageSizeStr = request.getParameter("pageSize");
        int ccid =0;
        if(cid!=null && cid.length()>0){
            ccid=Integer.parseInt(cid);
        }else {
            ccid=1;
        }
        int currentPage=0;
        if(currentPageStr!=null && currentPageStr.length()>0){
            currentPage=Integer.parseInt(currentPageStr);
        }else{
            currentPage=1;//默认1
        }
        int pageSize =0 ;
        if(pageSizeStr!=null && pageSizeStr.length()>0){
            pageSize=Integer.parseInt(pageSizeStr);
        }else{
            pageSize=5;//默认5
        }
        PageBean<Route> routePageBean = routeService.pageQuery(ccid, currentPage, pageSize);

        response.setContentType("application/json;charset=utf-8");

        writeValue(routePageBean, response);


    }
}

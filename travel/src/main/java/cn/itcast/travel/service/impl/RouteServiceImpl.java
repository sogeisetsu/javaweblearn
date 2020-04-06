package cn.itcast.travel.service.impl;

import cn.itcast.travel.dao.RouteDao;
import cn.itcast.travel.dao.impl.RouteDaoImpl;
import cn.itcast.travel.domain.PageBean;
import cn.itcast.travel.domain.Route;
import cn.itcast.travel.service.RouteService;

import java.util.List;

public class RouteServiceImpl implements RouteService {
    private RouteDao routeDao = new RouteDaoImpl();
    @Override
    public PageBean<Route> pageQuery(int cid, int currentPage, int pageSize) {
        PageBean<Route> pageBean = new PageBean<Route>();
        int totalCount = routeDao.count(cid);//总计数
        int start = (currentPage-1)*pageSize;
        List<Route> byPage = routeDao.findByPage(cid, start, pageSize);
        pageBean.setCurrentPage(currentPage);
        pageBean.setList(byPage);
        pageBean.setPageSize(pageSize);
        pageBean.setTotalCount(totalCount);
        int totalPage = totalCount%pageSize==0? totalCount/pageSize : (totalCount/pageSize)+1;
        pageBean.setTotalPage(totalPage);
        return pageBean;
    }
}

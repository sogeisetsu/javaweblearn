package cn.itcast.travel.dao;

import cn.itcast.travel.domain.PageBean;
import cn.itcast.travel.domain.Route;

import java.util.List;

public interface RouteDao {
    /**
     * 获得总记录
     * @param cid
     * @return
     */
    int count(int cid);

    /**
     * 获取List<Route>集合
     * @param cid
     * @param start
     * @param pageSize
     * @return
     */
    List<Route> findByPage(int cid, int start, int pageSize);
}

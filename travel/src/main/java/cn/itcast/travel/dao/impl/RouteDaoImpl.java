package cn.itcast.travel.dao.impl;

import cn.itcast.travel.dao.RouteDao;
import cn.itcast.travel.domain.Route;
import cn.itcast.travel.util.JDBCUtils;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RouteDaoImpl implements RouteDao {
    private JdbcTemplate template=new JdbcTemplate(JDBCUtils.getDataSource());
    @Override
    public int count(int cid,String rname) {
        String sql = "SELECT COUNT(*) FROM tab_route WHERE 1=1 ";
        StringBuffer bufSql = new StringBuffer(sql);
        List<Object> params = new ArrayList<Object>();
        if(cid!=0){
            bufSql.append(" AND cid = ? ");
            params.add(cid);
        }
        if(rname!=null && rname.length()>0){
            bufSql.append(" AND rname LIKE ? ");
            params.add("%"+rname+"%");
        }
        sql = bufSql.toString();
        Integer count = template.queryForObject(sql, Integer.class, params.toArray());
        System.out.println(sql);
//        return template.queryForObject(sql, Integer.class, cid);
        return count;
    }

    @Override
    public List<Route> findByPage(int cid, int start, int pageSize,String rname) {
        String sql = "SELECT * FROM tab_route WHERE 1=1 ";
        StringBuffer stringBuffer = new StringBuffer(sql);
        List<Object> list = new ArrayList<Object>();
        if(cid!=0){
            stringBuffer.append(" AND cid = ? ");
            list.add(cid);
        }
        if(rname!=null && rname.length()>0){
            stringBuffer.append(" AND rname LIKE ? ");
            list.add("%"+rname+"%");

        }
        stringBuffer.append(" LIMIT ?,? ");
        list.add(start);
        list.add(pageSize);
        sql=stringBuffer.toString();
        System.out.println(list);
//        return template.query(sql, new BeanPropertyRowMapper<Route>(Route.class), cid, start, pageSize);
        List<Route> routes = template.query(sql, new BeanPropertyRowMapper<Route>(Route.class), list.toArray());
        System.out.println(sql);
        return routes;
    }
}

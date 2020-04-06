package cn.itcast.travel.service.impl;

import cn.itcast.travel.dao.impl.CategoryDaoImpl;
import cn.itcast.travel.domain.Category;
import cn.itcast.travel.service.CategoryService;
import cn.itcast.travel.util.JedisUtil;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.Tuple;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class CategoryServiceImpl implements CategoryService {
    private CategoryDaoImpl categoryDao=new CategoryDaoImpl();
    @Override
    public List<Category> findAll() throws Exception {
        Jedis jedis = JedisUtil.getJedis();
//        Set<String> category = jedis.zrange("category", 0, -1);
        Set<Tuple> category = jedis.zrangeWithScores("category", 0, -1);
//        System.out.println(category);
        List<Category> cc = null;

        if(category==null||category.size()==0){
            System.out.println("从数据库获取");
            List<Category> all = categoryDao.findAll();
            for (Category category1 : all) {
                jedis.zadd("category", category1.getCid(), category1.getCname());
            }
//            System.out.println(jedis.zrange("category", 0, -1));
            return all;
        }else{
            System.out.println("从缓存读取");
            cc=new ArrayList<Category>();
            for (Tuple tuple : category) {
                Category category2 = new Category();
                category2.setCname(tuple.getElement());
                category2.setCid((int)tuple.getScore());
                cc.add(category2);
            }
            return cc;
        }
    }
}

package cn.itcast.travel.dao;

import cn.itcast.travel.domain.Category;

import java.util.List;

public interface CategoryDao {
    /**
     * 查找所有的分类
     * @return
     * @throws Exception
     */
    public List<Category> findAll() throws Exception;
}

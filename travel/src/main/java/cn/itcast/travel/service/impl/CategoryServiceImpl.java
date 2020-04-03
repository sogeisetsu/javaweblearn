package cn.itcast.travel.service.impl;

import cn.itcast.travel.dao.impl.CategoryDaoImpl;
import cn.itcast.travel.domain.Category;
import cn.itcast.travel.service.CategoryService;

import java.util.List;

public class CategoryServiceImpl implements CategoryService {
    private CategoryDaoImpl categoryDao=new CategoryDaoImpl();
    @Override
    public List<Category> findAll() throws Exception {
        return categoryDao.findAll();
    }
}

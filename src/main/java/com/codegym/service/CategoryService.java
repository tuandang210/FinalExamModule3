package com.codegym.service;

import com.codegym.dao.CategoryDAO;
import com.codegym.dao.ICategoryDAO;
import com.codegym.model.Category;

import java.sql.SQLException;
import java.util.List;

public class CategoryService implements ICategoryService{
    ICategoryDAO categoryDAO = new CategoryDAO();
    @Override
    public List<Category> selectAll() throws SQLException {
        return categoryDAO.selectAll();
    }
}
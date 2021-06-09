package com.codegym.dao;

import com.codegym.model.Category;

import java.sql.SQLException;
import java.util.List;

public interface ICategoryDAO {
    List<Category> selectAll() throws SQLException;
}
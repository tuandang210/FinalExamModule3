package com.codegym.service;

import com.codegym.model.Category;

import java.sql.SQLException;
import java.util.List;

public interface ICategoryService {
    List<Category> selectAll() throws SQLException;
}
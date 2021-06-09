package com.codegym.dao.product;

import com.codegym.dao.SQLConnection;
import com.codegym.model.Product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductDAO implements IProductDAO {
    public static final String INSERT_PRODUCT = "insert into product (name, price, number, color, intro, idCate) value (?,?,?,?,?,?)";
    public static final String SELECT_PRODUCT = "select * from product where id= ?";

    @Override
    public boolean create(Product product) throws SQLException {
        Connection connection = SQLConnection.getConnection();
        int isCreate = 0;
        PreparedStatement preparedStatement = connection.prepareStatement(INSERT_PRODUCT);
        preparedStatement.setString(1, product.getName());
        preparedStatement.setFloat(2, product.getPrice());
        preparedStatement.setInt(3, product.getNumber());
        preparedStatement.setString(4, product.getColor());
        preparedStatement.setString(5, product.getIntro());
        preparedStatement.setInt(6, product.getIdCate());
        isCreate = preparedStatement.executeUpdate();
        return isCreate != 0;
    }

    @Override
    public Product select(int id) throws SQLException {
        Product product = new Product();
        Connection connection = SQLConnection.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(SELECT_PRODUCT);
        preparedStatement.setInt(1, id);
        ResultSet rs = preparedStatement.executeQuery();
        while (rs.next()) {
            String name = rs.getString("name");
            float price = rs.getFloat("price");
            int number = rs.getInt("number");
            String color = rs.getString("color");
            String intro = rs.getString("intro");
            int idCate = rs.getInt("idCate");
            product = new Product(name, price, number, color, intro, idCate);
        }
        return product;
    }

    @Override
    public List<Product> selectAll() throws SQLException {
        List<Product> products = new ArrayList<>();
        Connection connection = SQLConnection.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("select * from product");
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                String name = rs.getString("name");
                float price = rs.getFloat("price");
                int number = rs.getInt("number");
                String color = rs.getString("color");
                String intro = rs.getString("intro");
                int idCate = rs.getInt("idCate");
                products.add(new Product(name, price, number, color, intro, idCate));
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return products;
    }

    @Override
    public boolean delete(int id) throws SQLException {
        return false;
    }

    @Override
    public boolean update(int id, Product product) throws SQLException {
        return false;
    }
}

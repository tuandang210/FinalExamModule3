package com.codegym.controler;

import com.codegym.dao.product.IProductDAO;
import com.codegym.dao.product.ProductDAO;
import com.codegym.model.Product;
import jdk.nashorn.internal.ir.RuntimeNode;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "ProductServlet", value = "/products")
public class ProductServlet extends HttpServlet {
    public ProductDAO productDAO = new ProductDAO();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                showCreate(request, response);
                break;
            default:
                try {
                    showList(request, response);
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
                break;
        }
    }

    private void showCreate(HttpServletRequest request, HttpServletResponse response) {
        RequestDispatcher dispatcher = request.getRequestDispatcher("create.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
        List<Product> products = productDAO.selectAll();
        request.setAttribute("products", products);
        RequestDispatcher dispatcher =request.getRequestDispatcher("list.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                createProduct(request, response);
                break;
            default:
                try {
                    showList(request, response);
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
                break;
        }
    }

    private void createProduct(HttpServletRequest request, HttpServletResponse response) {
        String name = request.getParameter("name");

    }
}

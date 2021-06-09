package com.codegym.controler;

import com.codegym.dao.IProductDAO;
import com.codegym.dao.ProductDAO;
import com.codegym.model.Category;
import com.codegym.model.Product;
import com.codegym.service.CategoryService;
import com.codegym.service.ICategoryService;
import com.codegym.service.IProductService;
import com.codegym.service.ProductService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "ProductServlet", value = "/products")
public class ProductServlet extends HttpServlet {
    private final IProductService productService = new ProductService();
    private final IProductDAO productDAO = new ProductDAO();
    private final ICategoryService categoryService = new CategoryService();
    String action = "";

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                createNewForm(request, response);
                break;
            case "edit":
                editForm(request, response);
                break;
            case "delete":
                deleteProduct(request, response);
                break;
            default:
                showListForm(request, response);
                break;
        }

    }

    private void showListForm(HttpServletRequest request, HttpServletResponse response) {
        try {
            List<Product> products = productService.selectAll();
            request.setAttribute("products", products);
            RequestDispatcher dispatcher = request.getRequestDispatcher("product/list.jsp");
            dispatcher.forward(request, response);
        } catch (SQLException | ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    private void createNewForm(HttpServletRequest request, HttpServletResponse response) {
        try {
            List<Category> categories = categoryService.selectAll();
            request.setAttribute("categories", categories);
            RequestDispatcher dispatcher = request.getRequestDispatcher("product/create.jsp");
            dispatcher.forward(request, response);
        } catch (SQLException | ServletException | IOException throwables) {
            throwables.printStackTrace();
        }
    }


    private void editForm(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        try {
            Product product = productService.select(id);
            List<Category> categories = categoryService.selectAll();
            RequestDispatcher dispatcher = request.getRequestDispatcher("product/edit.jsp");
            if (product == null) {
                dispatcher = request.getRequestDispatcher("error-404.jsp");
            }
            request.setAttribute("product", product);
            request.setAttribute("categories", categories);
            dispatcher.forward(request, response);

        } catch (SQLException | ServletException | IOException throwables) {
            throwables.printStackTrace();
        }

    }

    private void deleteProduct(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        boolean isDelete = false;
        try {
            isDelete = productDAO.delete(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if (!isDelete) {
            request.setAttribute("message", "Error!");
        } else {
            request.setAttribute("message", "Success!");
            try {
                response.sendRedirect("/products");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                createNew(request, response);
                break;
            case "edit":
                edit(request, response);
                break;
            default:
                try {
                    showListSearch(request, response);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                break;
        }
    }

    private void edit(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        int price = Integer.parseInt(request.getParameter("price"));
        int amount = Integer.parseInt(request.getParameter("amount"));
        String detail = request.getParameter("detail");
        int cat_id = Integer.parseInt(request.getParameter("cat_id"));

        Product product = new Product(id, name, price, amount, detail, cat_id);

        try {
            List<Category> categories = categoryService.selectAll();

            boolean isEdit = productService.update(product.getId(), product);
            if (!isEdit) {
                request.setAttribute("message", "Error!");
            } else {
                request.setAttribute("message", "Success!");
            }
            RequestDispatcher dispatcher = request.getRequestDispatcher("product/edit.jsp");
            request.setAttribute("product", product);
            request.setAttribute("categories", categories);
            dispatcher.forward(request, response);
        } catch (SQLException | ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    private void createNew(HttpServletRequest request, HttpServletResponse response) {
        String name = request.getParameter("name");
        int price = Integer.parseInt(request.getParameter("price"));
        int amount = Integer.parseInt(request.getParameter("amount"));
        String detail = request.getParameter("detail");
        int cat_id = Integer.parseInt(request.getParameter("cat_id"));
        Product product = new Product(name, price, amount, detail, cat_id);

        try {
            boolean isCreate = productService.create(product);
            if (!isCreate) {
                request.setAttribute("message", "Error!");
            } else {
                request.setAttribute("message", "Success!");
            }
            List<Category> categories = categoryService.selectAll();
            request.setAttribute("categories", categories);

            RequestDispatcher dispatcher = request.getRequestDispatcher("product/create.jsp");

            dispatcher.forward(request, response);
        } catch (SQLException | ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    private void showListSearch(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        String search = request.getParameter("search");
        List<Product> list = productDAO.showSearch(search);
        request.setAttribute("products", list);
        if (search.equals("")) {
            showListForm(request, response);
        } else {
            request.setAttribute("products", list);
        }
        RequestDispatcher dispatcher = request.getRequestDispatcher("product/list.jsp");
        dispatcher.forward(request, response);
    }
}
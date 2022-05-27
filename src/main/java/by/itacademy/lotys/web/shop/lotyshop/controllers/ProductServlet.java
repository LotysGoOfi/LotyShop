package by.itacademy.lotys.web.shop.lotyshop.controllers;


import by.itacademy.lotys.web.shop.lotyshop.entities.Product;
import by.itacademy.lotys.web.shop.lotyshop.services.products.ImplementProductService;
import by.itacademy.lotys.web.shop.lotyshop.services.products.ProductService;
import lombok.extern.java.Log;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Log
@WebServlet(urlPatterns = "/product")
public class ProductServlet extends HttpServlet {

    private final ProductService productService= new ImplementProductService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        Product product = productService.getProduct(id).orElseGet(()->Product.builder().name("null").build());

        req.setAttribute("product",product);
        req.getRequestDispatcher("/pages/product.jsp").forward(req,resp);
    }
}

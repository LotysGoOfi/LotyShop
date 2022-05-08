package by.itacademy.lotys.web.shop.lotyshop.controllers.servlets;

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
import java.util.List;

@Log
@WebServlet(urlPatterns = "")
public class MainPageServlet extends HttpServlet {

    private final ProductService productService = new ImplementProductService();


    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        List<Product> allProducts = productService.getAllProducts();

        req.setAttribute("products",allProducts);
        req.getRequestDispatcher("/pages/main.jsp").forward(req,resp);
        log.info("products ="+allProducts);
    }
}

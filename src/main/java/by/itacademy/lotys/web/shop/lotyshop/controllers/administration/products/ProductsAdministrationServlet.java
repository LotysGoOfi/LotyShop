package by.itacademy.lotys.web.shop.lotyshop.controllers.administration.products;

import by.itacademy.lotys.web.shop.lotyshop.entities.Product;
import by.itacademy.lotys.web.shop.lotyshop.properties.Config;
import by.itacademy.lotys.web.shop.lotyshop.services.products.ImplementProductService;
import by.itacademy.lotys.web.shop.lotyshop.services.products.ProductService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = "/administration/products")
public class ProductsAdministrationServlet extends HttpServlet {

    private final ProductService productService = new ImplementProductService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Product> allProducts = productService.getAllProducts();
        req.setAttribute("products",allProducts);
        req.getRequestDispatcher(Config.URL_ADMINISTRATION_PRODUCTS_JSP).forward(req,resp);
    }
}

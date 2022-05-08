package by.itacademy.lotys.web.shop.lotyshop.services.products;

import by.itacademy.lotys.web.shop.lotyshop.entities.Product;

import java.util.List;

public interface ProductService {
    Product getProduct(int id);
    Product addProduct();
    List<Product> getAllProducts();
}

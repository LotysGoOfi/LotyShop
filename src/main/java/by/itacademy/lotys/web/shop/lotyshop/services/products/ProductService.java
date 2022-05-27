package by.itacademy.lotys.web.shop.lotyshop.services.products;

import by.itacademy.lotys.web.shop.lotyshop.entities.Product;

import java.util.List;
import java.util.Optional;

public interface ProductService {
    Optional<Product> getProduct(int id);
    void addProduct(Product product);
    List<Product> getAllProducts();
}

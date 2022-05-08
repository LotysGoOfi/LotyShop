package by.itacademy.lotys.web.shop.lotyshop.repositories.products;

import by.itacademy.lotys.web.shop.lotyshop.entities.Product;

import java.util.List;

public interface ProductRepository {
    Product getProduct(int id);
    Product addProduct();
    List<Product> getAllProducts();
}

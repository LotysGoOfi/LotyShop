package by.itacademy.lotys.web.shop.lotyshop.repositories.products;

import by.itacademy.lotys.web.shop.lotyshop.entities.Company;
import by.itacademy.lotys.web.shop.lotyshop.entities.Product;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

public interface ProductRepository {

    Optional<Product> getProduct(int id);

    void createProduct(Product product);

    Optional<Product> updateProduct(Product product);

    void deleteProduct(int id);

    List<Product> getAllProducts();

    Optional<String> getCategory(int id);
    int getIDCategoryByName(String name);
}

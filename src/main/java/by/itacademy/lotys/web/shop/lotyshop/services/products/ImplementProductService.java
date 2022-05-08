package by.itacademy.lotys.web.shop.lotyshop.services.products;

import by.itacademy.lotys.web.shop.lotyshop.entities.Product;
import by.itacademy.lotys.web.shop.lotyshop.repositories.products.ImplementProductRepository;
import by.itacademy.lotys.web.shop.lotyshop.repositories.products.ProductRepository;

import java.util.List;

public class ImplementProductService implements ProductService {

    private final ProductRepository productRepository = new ImplementProductRepository();

    @Override
    public Product getProduct(int id) {
        return productRepository.getProduct(id);
    }

    @Override
    public Product addProduct() {
        return null;
    }

    @Override
    public List<Product> getAllProducts() {
        return productRepository.getAllProducts();
    }
}

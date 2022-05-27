package by.itacademy.lotys.web.shop.lotyshop.services.products;

import by.itacademy.lotys.web.shop.lotyshop.entities.Product;
import by.itacademy.lotys.web.shop.lotyshop.repositories.products.ImplementProductRepository;
import by.itacademy.lotys.web.shop.lotyshop.repositories.products.ProductRepository;

import java.util.List;
import java.util.Optional;

public class ImplementProductService implements ProductService {

    private final ProductRepository productRepository = new ImplementProductRepository();

    @Override
    public Optional<Product> getProduct(int id) {
        return productRepository.getProduct(id);
    }

    @Override
    public void addProduct(Product product) {
        productRepository.createProduct(product);
    }

    @Override
    public List<Product> getAllProducts() {
        return productRepository.getAllProducts();
    }
}

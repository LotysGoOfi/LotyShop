package by.itacademy.lotys.web.shop.lotyshop.repositories.products;


import by.itacademy.lotys.web.shop.lotyshop.entities.Product;


import java.util.List;
import java.util.Optional;

public class ImplementProductRepository implements ProductRepository {


    @Override
    public Optional<Product> getProduct(int id) {
        return Optional.empty();
    }

    @Override
    public void createProduct(Product product) {

    }

    @Override
    public Optional<Product> updateProduct(Product product) {
        return Optional.empty();
    }

    @Override
    public void deleteProduct(int id) {

    }

    @Override
    public List<Product> getAllProducts() {
        return null;
    }

    @Override
    public Optional<String> getCategory(int id) {
        return Optional.empty();
    }

    @Override
    public int getIDCategoryByName(String name) {
        return 0;
    }
}

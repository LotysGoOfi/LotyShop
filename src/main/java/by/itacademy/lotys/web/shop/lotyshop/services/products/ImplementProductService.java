package by.itacademy.lotys.web.shop.lotyshop.services.products;

import by.itacademy.lotys.web.shop.lotyshop.entities.Product;


import java.util.List;
import java.util.Optional;

public class ImplementProductService implements ProductService {

    @Override
    public Optional<Product> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public Optional<Product> update(Product entity) {
        return Optional.empty();
    }

    @Override
    public void create(Product entity) {

    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public List<Product> getAll() {
        return null;
    }
}

package by.itacademy.lotys.web.shop.lotyshop.services.products;

import by.itacademy.lotys.web.shop.lotyshop.entities.Product;
import by.itacademy.lotys.web.shop.lotyshop.repositories.product.ImplementProductRepository;
import by.itacademy.lotys.web.shop.lotyshop.repositories.product.ProductRepository;
import lombok.extern.java.Log;


import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Log
public class ImplementProductService implements ProductService {

    private final ProductRepository productRepository =  new ImplementProductRepository();

    @Override
    public Product findById(Long id) {
        return productRepository.findById(id).orElseThrow(()->new NoSuchElementException(""+id));
    }

    @Override
    public Product update(Product product) {
        return productRepository.update(product).orElseThrow(()->new NoSuchElementException(""+product));
    }

    @Override
    public void create(Product product) {
        productRepository.create(product);
    }

    @Override
    public void delete(Long id) {
        try {
            productRepository.delete(id);
        }catch (NoSuchElementException noSuchElementException){
            log.info(noSuchElementException.getMessage());
        }
    }

    @Override
    public List<Product> getAll() {
        return productRepository.getAll();
    }
}

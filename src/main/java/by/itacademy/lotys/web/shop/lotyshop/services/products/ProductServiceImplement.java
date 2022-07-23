package by.itacademy.lotys.web.shop.lotyshop.services.products;

import by.itacademy.lotys.web.shop.lotyshop.entities.Product;
import by.itacademy.lotys.web.shop.lotyshop.repositories.products.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.UUID;


@Service
@RequiredArgsConstructor
public class ProductServiceImplement implements ProductService{

    private final ProductRepository productRepository;

    @Override
    public Product getByID(UUID uuid) {
        return getProduct(uuid);
    }

    @Override
    @Transactional
    public Product update(Product request) {
        if(productRepository.existsById(request.getId())){
            productRepository.save(request);
        }
        return request;
    }

    @Override
    @Transactional
    public Product delete(UUID uuid) {
        Product product = getProduct(uuid);
        productRepository.delete(product);
        return product;
    }

    @Override
    @Transactional
    public Product create(Product request) {
        return productRepository.save(request);
    }

    @Override
    public List<Product> getAll() {
        return productRepository.findAll();
    }

    private Product getProduct(UUID id) {
        return productRepository.findById(id).
                orElseThrow(() -> new NoSuchElementException("no product by " + id));
    }
}

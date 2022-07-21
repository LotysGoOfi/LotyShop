package by.itacademy.lotys.web.shop.lotyshop.services.products;

import by.itacademy.lotys.web.shop.lotyshop.entities.Product;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;


@Service
@RequiredArgsConstructor
public class ProductAPIService implements ProductService{

    @Override
    public Product getByID(UUID uuid) {
        return null;
    }

    @Override
    public Product update(Product request, UUID uuid) {
        return null;
    }

    @Override
    public Product delete(UUID uuid) {
        return null;
    }

    @Override
    public Product create(Product request) {
        return null;
    }

    @Override
    public List<Product> getAll() {
        return null;
    }
}

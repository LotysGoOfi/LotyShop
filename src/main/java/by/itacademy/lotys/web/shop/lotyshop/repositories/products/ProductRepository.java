package by.itacademy.lotys.web.shop.lotyshop.repositories.products;

import by.itacademy.lotys.web.shop.lotyshop.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ProductRepository extends JpaRepository<UUID, Product> {
}

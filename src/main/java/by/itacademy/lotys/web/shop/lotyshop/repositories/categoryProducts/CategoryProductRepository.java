package by.itacademy.lotys.web.shop.lotyshop.repositories.categoryProducts;

import by.itacademy.lotys.web.shop.lotyshop.entities.CategoryProduct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface CategoryProductRepository extends JpaRepository<CategoryProduct,UUID> {
}

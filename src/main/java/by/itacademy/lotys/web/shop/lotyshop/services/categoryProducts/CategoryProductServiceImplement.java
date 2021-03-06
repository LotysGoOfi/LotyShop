package by.itacademy.lotys.web.shop.lotyshop.services.categoryProducts;

import by.itacademy.lotys.web.shop.lotyshop.entities.CategoryProduct;
import by.itacademy.lotys.web.shop.lotyshop.repositories.categoryProducts.CategoryProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;


@Service
@RequiredArgsConstructor
public class CategoryProductServiceImplement implements CategoryProductService {

    private final CategoryProductRepository categoryProductRepository;

    @Override
    public CategoryProduct findById(UUID id) {
        return getCategoryProduct(id);
    }

    @Override
    @Transactional
    public CategoryProduct update(CategoryProduct request) {
        if(categoryProductRepository.existsById(request.getId())){
            categoryProductRepository.save(request);
        }
        return request;
    }

    @Override
    @Transactional
    public CategoryProduct delete(UUID id) {
        CategoryProduct categoryProduct = getCategoryProduct(id);
        categoryProductRepository.delete(categoryProduct);
        return categoryProduct;
    }

    @Override
    @Transactional
    public CategoryProduct create(CategoryProduct request) {
        return categoryProductRepository.save(request);
    }

    @Override
    public List<CategoryProduct> getAll() {
        return categoryProductRepository.findAll();
    }

    private CategoryProduct getCategoryProduct(UUID id) {
        return categoryProductRepository.findById(id)
                .orElseThrow(() -> new NullPointerException("" + id));
    }
}

package by.itacademy.lotys.web.shop.lotyshop.services.categoryProduct;

import by.itacademy.lotys.web.shop.lotyshop.dtos.categoryProduct.CategoryProductRequest;
import by.itacademy.lotys.web.shop.lotyshop.dtos.categoryProduct.CategoryProductResponse;
import by.itacademy.lotys.web.shop.lotyshop.entities.CategoryProduct;
import by.itacademy.lotys.web.shop.lotyshop.repositories.categoryProduct.CategoryProductRepository;
import by.itacademy.lotys.web.shop.lotyshop.transformers.user.CategoryProductTransformers;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Slf4j
@Service
@RequiredArgsConstructor
public class CategoryProductAPIService implements CategoryProductService {

    private final CategoryProductRepository categoryProductRepository;
    private final CategoryProductTransformers categoryProductTransformers;

    @Override
    public CategoryProductResponse getByID(UUID id) {
        return categoryProductTransformers.getResponse(
                getCategoryProduct(id));
    }

    @Override
    @Transactional
    public CategoryProductResponse update(CategoryProductRequest request, UUID id) {
        CategoryProduct categoryProduct = getCategoryProduct(id);
        categoryProduct.setName(request.getName());
        return categoryProductTransformers.getResponse(
                categoryProductRepository.save(categoryProduct));
    }

    @Override
    @Transactional
    public CategoryProductResponse delete(UUID id) {
        CategoryProduct categoryProduct = getCategoryProduct(id);
        categoryProductRepository.delete(categoryProduct);
        return categoryProductTransformers.getResponse(categoryProduct);
    }

    @Override
    @Transactional
    public CategoryProductResponse create(CategoryProductRequest request) {
        return categoryProductTransformers.getResponse(
                categoryProductRepository.save(
                        categoryProductTransformers.getEntity(request)));
    }

    @Override
    public List<CategoryProductResponse> getAll() {
        return categoryProductTransformers.getResponses(
                categoryProductRepository.findAll());
    }

    private CategoryProduct getCategoryProduct(UUID id) {
        return categoryProductRepository.findById(id)
                .orElseThrow(() -> new NullPointerException("" + id));
    }
}

package by.itacademy.lotys.web.shop.lotyshop.transformers.user;

import by.itacademy.lotys.web.shop.lotyshop.dtos.categoryProduct.CategoryProductRequest;
import by.itacademy.lotys.web.shop.lotyshop.dtos.categoryProduct.CategoryProductResponse;
import by.itacademy.lotys.web.shop.lotyshop.entities.CategoryProduct;
import by.itacademy.lotys.web.shop.lotyshop.transformers.Transformers;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CategoryProductTransformers implements Transformers<CategoryProductRequest, CategoryProductResponse, CategoryProduct> {
    @Override
    public CategoryProduct getEntity(CategoryProductRequest request) {
        return null;
    }

    @Override
    public CategoryProductResponse getResponse(CategoryProduct entity) {
        return null;
    }

    @Override
    public List<CategoryProductResponse> getResponses(List<CategoryProduct> entities) {
        return null;
    }
}

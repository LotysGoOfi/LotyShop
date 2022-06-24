package by.itacademy.lotys.web.shop.lotyshop.services.categoryProduct;

import by.itacademy.lotys.web.shop.lotyshop.entities.CategoryProduct;
import by.itacademy.lotys.web.shop.lotyshop.repositories.categoryProduct.CategoryProductRepository;
import by.itacademy.lotys.web.shop.lotyshop.repositories.categoryProduct.ImplementCategoryProductRepository;
import lombok.extern.java.Log;

import java.util.List;
import java.util.NoSuchElementException;

@Log
public class ImplementCategoryProductService implements CategoryProductService{

    private final CategoryProductRepository categoryProductRepository = new ImplementCategoryProductRepository();

    @Override
    public CategoryProduct findById(Long id) {
        return categoryProductRepository.findById(id).orElseThrow(()-> new NoSuchElementException(""+id));
    }

    @Override
    public CategoryProduct update(CategoryProduct categoryProduct) {
        return categoryProductRepository.update(categoryProduct).orElseThrow(()-> new NoSuchElementException(""+categoryProduct));
    }

    @Override
    public void create(CategoryProduct categoryProduct) {
        categoryProductRepository.create(categoryProduct);
    }

    @Override
    public void delete(Long id) {
        try {
            categoryProductRepository.delete(id);
        }catch (NoSuchElementException noSuchElementException){
            log.info(noSuchElementException.getMessage());
        }
    }

    @Override
    public List<CategoryProduct> getAll() {
        return categoryProductRepository.getAll();
    }
}

package by.itacademy.lotys.web.shop.lotyshop.controllers;

import by.itacademy.lotys.web.shop.lotyshop.entities.CategoryProduct;
import by.itacademy.lotys.web.shop.lotyshop.services.categoryProducts.CategoryProductService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;


import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/categoryProduct")
public class CategoryProductController{

    private final CategoryProductService categoryProductService;

    @GetMapping("id/{id}")
    @ResponseStatus(value = HttpStatus.OK)
    public CategoryProduct get(@PathVariable UUID id) {
        return categoryProductService.getByID(id);
    }

    @GetMapping("all")
    @ResponseStatus(value = HttpStatus.OK)
    public List<CategoryProduct> getAll() {
        return categoryProductService.getAll();
    }

    @GetMapping("update/{id}")
    @ResponseStatus(value = HttpStatus.OK)
    public CategoryProduct update(@Valid @RequestBody CategoryProduct request, @PathVariable UUID id) {
        return categoryProductService.update(request);
    }

    @GetMapping("create")
    @ResponseStatus(value = HttpStatus.OK)
    public CategoryProduct create(@RequestBody CategoryProduct request) {
        return categoryProductService.create(request);
    }

    @GetMapping("delete/{id}")
    @ResponseStatus(value = HttpStatus.OK)
    public CategoryProduct delete(@PathVariable UUID id) {
        return categoryProductService.delete(id);
    }
}

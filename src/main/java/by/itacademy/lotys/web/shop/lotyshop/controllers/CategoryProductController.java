package by.itacademy.lotys.web.shop.lotyshop.controllers;

import by.itacademy.lotys.web.shop.lotyshop.dtos.categoryProduct.CategoryProductRequest;
import by.itacademy.lotys.web.shop.lotyshop.dtos.categoryProduct.CategoryProductResponse;
import by.itacademy.lotys.web.shop.lotyshop.services.categoryProduct.CategoryProductService;
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
    public CategoryProductResponse get(@PathVariable UUID id) {
        return categoryProductService.getByID(id);
    }

    @GetMapping("all")
    @ResponseStatus(value = HttpStatus.OK)
    public List<CategoryProductResponse> getAll() {
        return categoryProductService.getAll();
    }

    @GetMapping("update/{id}")
    @ResponseStatus(value = HttpStatus.OK)
    public CategoryProductResponse update(@Valid @RequestBody CategoryProductRequest request, @PathVariable UUID id) {
        return categoryProductService.update(request,id);
    }

    @GetMapping("create")
    @ResponseStatus(value = HttpStatus.OK)
    public CategoryProductResponse create(@RequestBody CategoryProductRequest request) {
        return categoryProductService.create(request);
    }

    @GetMapping("delete/{id}")
    @ResponseStatus(value = HttpStatus.OK)
    public CategoryProductResponse delete(UUID id) {
        return categoryProductService.delete(id);
    }
}

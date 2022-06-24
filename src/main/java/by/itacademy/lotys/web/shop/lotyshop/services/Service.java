package by.itacademy.lotys.web.shop.lotyshop.services;

import java.util.List;

public interface Service<T> {
    T findById(Long id);
    T update(T entity);
    void create(T entity);
    void delete(Long id);
    List<T> getAll();
}

package by.itacademy.lotys.web.shop.lotyshop.services;

import java.util.List;
import java.util.Optional;

public interface Service<T> {
    Optional<T> findById(Long id);
    Optional<T> update(T entity);
    void create(T entity);
    void delete(Long id);
    List<T> getAll();
}

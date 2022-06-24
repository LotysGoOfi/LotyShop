package by.itacademy.lotys.web.shop.lotyshop.repositories;


import java.util.List;
import java.util.Optional;

public interface Repository<T> {
    Optional<T> findById(Long id);
    Optional<T> update(T entity);
    void create(T entity);
    void delete(Long id);
    List<T> getAll();
}

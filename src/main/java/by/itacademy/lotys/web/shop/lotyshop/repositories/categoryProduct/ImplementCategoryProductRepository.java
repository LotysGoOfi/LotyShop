package by.itacademy.lotys.web.shop.lotyshop.repositories.categoryProduct;

import by.itacademy.lotys.web.shop.lotyshop.entities.CategoryProduct;
import by.itacademy.lotys.web.shop.lotyshop.repositories.Repository;
import by.itacademy.lotys.web.shop.lotyshop.util.JPAUtil;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

public class ImplementCategoryProductRepository implements CategoryProductRepository{

    private final EntityManager entityManager = JPAUtil.getEntityManager();

    @Override
    public Optional<CategoryProduct> findById(Long id) {
        final CategoryProduct categoryProduct = entityManager.find(CategoryProduct.class,id);
        return Optional.of(categoryProduct);
    }

    @Override
    public Optional<CategoryProduct> update(CategoryProduct categoryProduct) {
        entityManager.getTransaction().begin();

        entityManager.merge(categoryProduct);

        entityManager.getTransaction().commit();
        return Optional.of(entityManager.find(CategoryProduct.class,categoryProduct.getId()));
    }

    @Override
    public void create(CategoryProduct categoryProduct) {
        entityManager.getTransaction().begin();

        entityManager.persist(categoryProduct);

        entityManager.getTransaction().commit();
    }

    @Override
    public void delete(Long id) {
        entityManager.getTransaction().begin();

        CategoryProduct categoryProduct = findById(id).orElseThrow(()-> new NoSuchElementException(""+id));

        entityManager.remove(categoryProduct);

        entityManager.getTransaction().commit();
    }

    @Override
    public List<CategoryProduct> getAll() {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<CategoryProduct> query = criteriaBuilder.createQuery(CategoryProduct.class);
        query.from(CategoryProduct.class);
        return entityManager.createQuery(query).getResultList();
    }
}
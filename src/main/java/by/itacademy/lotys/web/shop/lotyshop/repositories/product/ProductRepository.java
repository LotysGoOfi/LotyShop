package by.itacademy.lotys.web.shop.lotyshop.repositories.product;

import by.itacademy.lotys.web.shop.lotyshop.entities.Product;
import by.itacademy.lotys.web.shop.lotyshop.repositories.InterfaceRepository;
import by.itacademy.lotys.web.shop.lotyshop.util.JPAUtil;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

public class ProductRepository implements InterfaceRepository<Product> {

    private final EntityManager entityManager = JPAUtil.getEntityManager();

    @Override
    public Optional<Product> findById(Long id) {
        final Product product = entityManager.find(Product.class,id);
        return Optional.of(product);
    }

    @Override
    public Optional<Product> update(Product product) {
        entityManager.getTransaction().begin();

        entityManager.merge(product);

        entityManager.getTransaction().commit();
        return Optional.of(entityManager.find(Product.class,product.getId()));
    }

    @Override
    public void create(Product product) {
        entityManager.getTransaction().begin();

        entityManager.persist(product);

        entityManager.getTransaction().commit();
    }

    @Override
    public void delete(Long id) {
        entityManager.getTransaction().begin();

        Product product = findById(id).orElseThrow(()->new NoSuchElementException(""+id));
        entityManager.remove(product);

        entityManager.getTransaction().commit();
    }

    @Override
    public List<Product> getAll() {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Product> query = criteriaBuilder.createQuery(Product.class);
        query.from(Product.class);
        return entityManager.createQuery(query).getResultList();
    }
}

package by.itacademy.lotys.web.shop.lotyshop.repositories.user;

import by.itacademy.lotys.web.shop.lotyshop.entities.User;
import by.itacademy.lotys.web.shop.lotyshop.entities.enums.UserRole;
import by.itacademy.lotys.web.shop.lotyshop.util.JPAUtil;


import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;


public class ImplementUserRepository implements UserRepository {

    private final EntityManager entityManager = JPAUtil.getEntityManager();

    @Override
    public Optional<User> findById(Long id) {

        final User user = entityManager.find(User.class, id);

        return Optional.of(user);
    }

    @Override
    public Optional<User> update(User user) {

        entityManager.getTransaction().begin();

        entityManager.merge(user);

        entityManager.getTransaction().commit();

        return Optional.of(entityManager.find(User.class, user.getId()));
    }

    @Override
    public void create(User user) {

        entityManager.getTransaction().begin();

        entityManager.persist(user);

        entityManager.getTransaction().commit();
    }

    @Override
    public void delete(Long id) {

        entityManager.getTransaction().begin();

        User user = findById(id).
                orElseThrow(() -> new NoSuchElementException("" + id));

        entityManager.remove(user);

        entityManager.getTransaction().commit();
    }

    @Override
    public List<User> getAll() {

        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();

        CriteriaQuery<User> query = criteriaBuilder.createQuery(User.class);

        query.from(User.class);

        return entityManager.createQuery(query).getResultList();
    }

    @Override
    public List<User> findByRole(UserRole userRole) {

        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();

        CriteriaQuery<User> query = criteriaBuilder.createQuery(User.class);

        Root<User> root = query.from(User.class);

        query.where(criteriaBuilder.
                equal(root.get("userRole"), userRole.toString()));

        return entityManager.createQuery(query).getResultList();
    }
}
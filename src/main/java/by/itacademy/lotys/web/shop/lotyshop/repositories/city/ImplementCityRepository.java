package by.itacademy.lotys.web.shop.lotyshop.repositories.city;

import by.itacademy.lotys.web.shop.lotyshop.entities.City;
import by.itacademy.lotys.web.shop.lotyshop.repositories.Repository;
import by.itacademy.lotys.web.shop.lotyshop.util.JPAUtil;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

public class ImplementCityRepository implements CityRepository {

    private final EntityManager entityManager = JPAUtil.getEntityManager();

    @Override
    public Optional<City> findById(Long id) {
        final City city = entityManager.find(City.class,id);
        return Optional.of(city);
    }

    @Override
    public Optional<City> update(City city) {
        entityManager.getTransaction().begin();

        entityManager.merge(city);

        entityManager.getTransaction().commit();
        return Optional.of(entityManager.find(City.class,city.getId()));
    }

    @Override
    public void create(City city) {
        entityManager.getTransaction().begin();

        entityManager.persist(city);

        entityManager.getTransaction().commit();
    }

    @Override
    public void delete(Long id) {
        entityManager.getTransaction().begin();

        City city = findById(id).orElseThrow(()-> new NoSuchElementException(""+id));

        entityManager.remove(city);

        entityManager.getTransaction().commit();
    }

    @Override
    public List<City> getAll() {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<City> query = criteriaBuilder.createQuery(City.class);
        query.from(City.class);
        return entityManager.createQuery(query).getResultList();
    }
}

package by.itacademy.lotys.web.shop.lotyshop.repositories.company;


import by.itacademy.lotys.web.shop.lotyshop.entities.Company;
import by.itacademy.lotys.web.shop.lotyshop.repositories.Repository;
import by.itacademy.lotys.web.shop.lotyshop.util.JPAUtil;
import lombok.extern.java.Log;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;


import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Log
public class ImplementCompanyRepository implements CompanyRepository {

    private final EntityManager entityManager = JPAUtil.getEntityManager();


    @Override
    public Optional<Company> findById(Long id) {
        final Company company = entityManager.find(Company.class,id);
        return Optional.of(company);
    }

    @Override
    public Optional<Company> update(Company company) {
        entityManager.getTransaction().begin();

        entityManager.merge(company);

        entityManager.getTransaction().commit();
        return Optional.of(entityManager.find(Company.class,company.getId()));
    }

    @Override
    public void create(Company company) {
        entityManager.getTransaction().begin();

        entityManager.persist(company);

        entityManager.getTransaction().commit();
    }

    @Override
    public void delete(Long id) {
        entityManager.getTransaction().begin();
        Company company = findById(id).orElseThrow(()->new NoSuchElementException(""+id));
        entityManager.remove(company);
        entityManager.getTransaction().commit();
    }

    @Override
    public List<Company> getAll() {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Company> query = criteriaBuilder.createQuery(Company.class);
        query.from(Company.class);
        return entityManager.createQuery(query).getResultList();
    }

}
package by.itacademy.lotys.web.shop.lotyshop.repositories.companies;


import by.itacademy.lotys.web.shop.lotyshop.entities.Company;
import by.itacademy.lotys.web.shop.lotyshop.util.JPAUtil;
import lombok.Cleanup;
import lombok.extern.java.Log;

import javax.persistence.EntityManager;
import java.sql.ResultSet;


import java.util.List;
import java.util.Optional;

@Log
public class ImplementCompanyRepository implements CompanyRepository {

    @Override
    public Optional<Company> findById(Long id) {
        @Cleanup
        final EntityManager entityManager = JPAUtil.getEntityManager();
        final Company company = entityManager.find(Company.class,id);
        return Optional.of(company);
    }

    @Override
    public Optional<Company> getCompany(String name) {
        return null;
    }

    @Override
    public Optional<Company> updateCompany(Company company) {
        return null;
    }

    @Override
    public Optional<Company> createCompany(String name, String urlLogo, List<String> countries) {
        return null;
    }

    @Override
    public void deleteCompany(Long id) {
    }

    @Override
    public List<Company> getAllCompanies() {
        return null;
    }

    public static void main(String[] args) {
        ImplementCompanyRepository implementCompanyRepository = new ImplementCompanyRepository();
        Optional<Company> byId = implementCompanyRepository.findById(1L);
        System.out.println(byId+" "+byId.get().getProducts());
    }

}
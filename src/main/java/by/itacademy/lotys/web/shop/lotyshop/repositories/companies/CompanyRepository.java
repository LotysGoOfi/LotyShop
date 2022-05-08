package by.itacademy.lotys.web.shop.lotyshop.repositories.companies;

import by.itacademy.lotys.web.shop.lotyshop.entities.Company;

import java.util.List;

public interface CompanyRepository {
    Company getCompany(int id);
    Company getCompany(String name);
    Company updateCompany(int id,String name);
    Company createCompany(String name);
    void deleteCompany(int id);
    List<Company> getAllCompanies();
}

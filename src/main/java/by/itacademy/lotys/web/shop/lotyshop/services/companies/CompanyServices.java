package by.itacademy.lotys.web.shop.lotyshop.services.companies;

import by.itacademy.lotys.web.shop.lotyshop.entities.Company;

import java.util.List;
import java.util.Optional;

public interface CompanyServices {
    Optional<Company> getCompany(int id);
    Optional<Company> getCompany(String name);
    Optional<Company> updateCompany(Company company);
    Optional<Company> createCompany(String name,String urlLogo,List<String> countries);
    void deleteCompany(int id);
    List<Company> getAllCompanies();
}

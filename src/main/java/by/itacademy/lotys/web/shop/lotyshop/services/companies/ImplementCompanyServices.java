package by.itacademy.lotys.web.shop.lotyshop.services.companies;

import by.itacademy.lotys.web.shop.lotyshop.entities.Company;
import by.itacademy.lotys.web.shop.lotyshop.repositories.companies.CompanyRepository;
import by.itacademy.lotys.web.shop.lotyshop.repositories.companies.ImplementCompanyRepository;

import java.util.List;
import java.util.Optional;

public class ImplementCompanyServices implements CompanyServices {

    private final CompanyRepository companyRepository = new ImplementCompanyRepository();


    @Override
    public Optional<Company> getCompany(int id) {
        return companyRepository.getCompany(id);
    }

    @Override
    public Optional<Company> getCompany(String name) {
        return companyRepository.getCompany(name);
    }

    @Override
    public Optional<Company> updateCompany(Company company) {
        return companyRepository.updateCompany(company);
    }

    @Override
    public Optional<Company> createCompany(String name,String urlLogo,List<String> countries) {
        return companyRepository.createCompany(name,urlLogo,countries);
    }

    @Override
    public void deleteCompany(int id) {
        companyRepository.deleteCompany(id);
    }

    @Override
    public List<Company> getAllCompanies() {
        return companyRepository.getAllCompanies();
    }
}

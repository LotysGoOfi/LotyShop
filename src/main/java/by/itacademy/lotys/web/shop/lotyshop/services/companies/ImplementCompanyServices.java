package by.itacademy.lotys.web.shop.lotyshop.services.companies;

import by.itacademy.lotys.web.shop.lotyshop.entities.Company;
import by.itacademy.lotys.web.shop.lotyshop.repositories.companies.CompanyRepository;
import by.itacademy.lotys.web.shop.lotyshop.repositories.companies.ImplementCompanyRepository;

import java.util.List;

public class ImplementCompanyServices implements CompanyServices {

    private final CompanyRepository companyRepository = new ImplementCompanyRepository();


    @Override
    public Company getCompany(int id) {
        return companyRepository.getCompany(id);
    }

    @Override
    public Company getCompany(String name) {
        return companyRepository.getCompany(name);
    }

    @Override
    public Company updateCompany(int id, String name) {
        return companyRepository.updateCompany(id,name);
    }

    @Override
    public Company createCompany(String name) {
        return companyRepository.createCompany(name);
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

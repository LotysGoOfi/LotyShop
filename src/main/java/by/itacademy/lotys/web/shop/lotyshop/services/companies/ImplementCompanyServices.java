package by.itacademy.lotys.web.shop.lotyshop.services.companies;

import by.itacademy.lotys.web.shop.lotyshop.entities.Company;
import by.itacademy.lotys.web.shop.lotyshop.repositories.InterfaceRepository;
import by.itacademy.lotys.web.shop.lotyshop.repositories.company.CompanyRepository;

import java.util.List;
import java.util.Optional;

public class ImplementCompanyServices implements CompanyServices {

    private final InterfaceRepository<Company> companyRepository = new CompanyRepository();


    @Override
    public Optional<Company> findById(Long id) {
        return companyRepository.findById(id);
    }

    @Override
    public Optional<Company> updateCompany(Company company) {
        return companyRepository.update(company);
    }

    @Override
    public void createCompany(Company company) {
        companyRepository.create(company);
    }

    @Override
    public void deleteCompany(Long id) {
        companyRepository.delete(id);
    }

    @Override
    public List<Company> getAllCompanies() {
        return companyRepository.getAll();
    }
}

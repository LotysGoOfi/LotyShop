package by.itacademy.lotys.web.shop.lotyshop.services.companies;

import by.itacademy.lotys.web.shop.lotyshop.entities.Company;
import by.itacademy.lotys.web.shop.lotyshop.repositories.Repository;
import by.itacademy.lotys.web.shop.lotyshop.repositories.company.ImplementCompanyRepository;

import java.util.List;
import java.util.Optional;

public class ImplementCompanyServices implements CompanyService {

    private final Repository<Company> companyRepository = new ImplementCompanyRepository();

    @Override
    public Optional<Company> findById(Long id) {
        return companyRepository.findById(id);
    }

    @Override
    public Optional<Company> update(Company company) {
        return companyRepository.update(company);
    }

    @Override
    public void create(Company company) {
        companyRepository.create(company);
    }

    @Override
    public void delete(Long id) {
        companyRepository.delete(id);
    }

    @Override
    public List<Company> getAll() {
        return companyRepository.getAll();
    }
}

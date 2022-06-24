package by.itacademy.lotys.web.shop.lotyshop.services.companies;

import by.itacademy.lotys.web.shop.lotyshop.entities.Company;
import by.itacademy.lotys.web.shop.lotyshop.repositories.Repository;
import by.itacademy.lotys.web.shop.lotyshop.repositories.company.ImplementCompanyRepository;
import lombok.extern.java.Log;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Log
public class ImplementCompanyService implements CompanyService {

    private final Repository<Company> companyRepository = new ImplementCompanyRepository();

    @Override
    public Company findById(Long id) {
        return companyRepository.findById(id).orElseThrow(() -> new NoSuchElementException("" + id));
    }

    @Override
    public Company update(Company company) {
        return companyRepository.update(company).orElseThrow(() -> new NoSuchElementException("" + company));
    }

    @Override
    public void create(Company company) {
        companyRepository.create(company);
    }

    @Override
    public void delete(Long id) {
        try {
            companyRepository.delete(id);
        } catch (NoSuchElementException noSuchElementException) {
            log.info(noSuchElementException.getMessage());
        }
    }

    @Override
    public List<Company> getAll() {
        return companyRepository.getAll();
    }
}

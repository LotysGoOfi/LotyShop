package by.itacademy.lotys.web.shop.lotyshop.services.company;

import by.itacademy.lotys.web.shop.lotyshop.entities.Company;
import by.itacademy.lotys.web.shop.lotyshop.repositories.companies.CompanyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CompanyAPIService implements CompanyService{

    private final CompanyRepository companyRepository;

    @Override
    public Company getByID(UUID uuid) {
        return companyRepository.getReferenceById(uuid);
    }

    @Override
    @Transactional
    public Company update(Company request) {
        if(companyRepository.existsById(request.getId())){
            companyRepository.save(request);
        }
        return request;
    }

    @Override
    @Transactional
    public Company delete(UUID uuid) {
        Company byID = getByID(uuid);
        companyRepository.delete(byID);
        return byID;
    }

    @Override
    @Transactional
    public Company create(Company request) {
        return companyRepository.save(request);
    }

    @Override
    public List<Company> getAll() {
        return companyRepository.findAll();
    }
}

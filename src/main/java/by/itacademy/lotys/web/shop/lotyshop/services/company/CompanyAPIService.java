package by.itacademy.lotys.web.shop.lotyshop.services.company;

import by.itacademy.lotys.web.shop.lotyshop.entities.Company;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CompanyAPIService implements CompanyService{


    @Override
    public Company getByID(UUID uuid) {
        return null;
    }

    @Override
    public Company update(Company request, UUID uuid) {
        return null;
    }

    @Override
    public Company delete(UUID uuid) {
        return null;
    }

    @Override
    public Company create(Company request) {
        return null;
    }

    @Override
    public List<Company> getAll() {
        return null;
    }
}

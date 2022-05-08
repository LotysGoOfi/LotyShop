package by.itacademy.lotys.web.shop.lotyshop.repositories.companies;

import by.itacademy.lotys.web.shop.lotyshop.dao.DAO;
import by.itacademy.lotys.web.shop.lotyshop.dao.DAOLocalDataBase;
import by.itacademy.lotys.web.shop.lotyshop.entities.Company;

import java.util.List;

public class ImplementCompanyRepository implements CompanyRepository {

    private final DAO dao = new DAOLocalDataBase();

    @Override
    public Company getCompany(int id) {
        return dao.getCompany(id);
    }

    @Override
    public Company getCompany(String name) {
        return dao.getCompany(name);
    }

    @Override
    public Company updateCompany(int id,String name) {
        return dao.updateCompany(id,name);
    }

    @Override
    public Company createCompany(String name) {
        return dao.createCompany(name);
    }

    @Override
    public void deleteCompany(int id) {
        dao.deleteCompany(id);
    }

    @Override
    public List<Company> getAllCompanies() {
        return dao.getAllCompanies();
    }
}

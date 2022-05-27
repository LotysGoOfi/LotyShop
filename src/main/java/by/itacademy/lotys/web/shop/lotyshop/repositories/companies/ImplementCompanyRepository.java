package by.itacademy.lotys.web.shop.lotyshop.repositories.companies;


import by.itacademy.lotys.web.shop.lotyshop.entities.Company;
import by.itacademy.lotys.web.shop.lotyshop.repositories.JDBCRepository;
import by.itacademy.lotys.web.shop.lotyshop.repositories.countries.CountriesRepository;
import by.itacademy.lotys.web.shop.lotyshop.repositories.countries.ImplementCountryRepository;
import lombok.extern.java.Log;


import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Log
public class ImplementCompanyRepository extends JDBCRepository implements CompanyRepository {


    private static final String TABLE_COMPANY = "table_company";
    private static final String ID_COMPANY = "id_company";
    private static final String NAME_COMPANY = "name_company";
    private static final String URL_LOGO_COMPANY = "url_logo_company";

    private static final String SQL_GET_ALL_COMPANIES = "SELECT * FROM " + TABLE_COMPANY;
    private static final String SQL_GET_COMPANY_BY_ID = "SELECT * FROM " + TABLE_COMPANY + " WHERE " + ID_COMPANY + "='%s'";
    private static final String SQL_GET_COMPANY_BY_NAME = "SELECT * FROM " + TABLE_COMPANY + " WHERE " + NAME_COMPANY + "='%s'";
    private static final String SQL_CREATE_COMPANY = "INSERT INTO " + TABLE_COMPANY + "(" + NAME_COMPANY + "," + URL_LOGO_COMPANY + ") VALUES ('%s','%s');";
    private static final String SQL_UPDATE_COMPANY_NAME = "UPDATE " + TABLE_COMPANY + " SET " + NAME_COMPANY + "='%s' WHERE " + ID_COMPANY + "=%s";
    private static final String SQL_UPDATE_COMPANY_URL_LOGO = "UPDATE " + TABLE_COMPANY + " SET " + URL_LOGO_COMPANY + "='%s' WHERE " + ID_COMPANY + "=%s";
    private static final String SQL_DELETE_COMPANY = "DELETE FROM " + TABLE_COMPANY + " WHERE " + ID_COMPANY + "=%s";


    @Override
    public Optional<Company> getCompany(int id) {
        String sql = String.format(SQL_GET_COMPANY_BY_ID, id);
        return Optional.of(execute(sql, this::setCompany));
    }

    @Override
    public Optional<Company> getCompany(String name) {
        String sql = String.format(SQL_GET_COMPANY_BY_NAME, name);
        return Optional.of(execute(sql, this::setCompany));
    }

    @Override
    public Optional<Company> updateCompany(Company company) {
        execute(String.format(SQL_UPDATE_COMPANY_NAME, company.getName(), company.getId()));
        execute(String.format(SQL_UPDATE_COMPANY_URL_LOGO, company.getUrlLogo(), company.getId()));
        return getCompany(company.getId());
    }

    @Override
    public Optional<Company> createCompany(String name, String urlLogo, List<String> countries) {
        execute(String.format(SQL_CREATE_COMPANY, name, urlLogo));
        return getCompany(name);
    }

    @Override
    public void deleteCompany(int id) {
        execute(String.format(SQL_DELETE_COMPANY, id));
    }

    @Override
    public List<Company> getAllCompanies() {
        List<Company> companies = new ArrayList<>();
        executeEach(SQL_GET_ALL_COMPANIES, (resultSet) -> companies.add(setCompany(resultSet)));
        return companies;
    }


    private Company setCompany(ResultSet resultSet) {
        try {
            return Company.builder()
                    .id(resultSet.getInt(ID_COMPANY))
                    .name(resultSet.getString(NAME_COMPANY))
                    .urlLogo(resultSet.getString(NAME_COMPANY))
                    .build();
        } catch (SQLException exception) {
            throw new RuntimeException(exception);
        }
    }
}

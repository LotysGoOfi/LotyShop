package by.itacademy.lotys.web.shop.lotyshop.repositories.countries;

import by.itacademy.lotys.web.shop.lotyshop.entities.Company;
import by.itacademy.lotys.web.shop.lotyshop.entities.Product;
import by.itacademy.lotys.web.shop.lotyshop.repositories.JDBCRepository;
import by.itacademy.lotys.web.shop.lotyshop.repositories.products.ImplementProductRepository;
import by.itacademy.lotys.web.shop.lotyshop.repositories.products.ProductRepository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class ImplementCountryRepository extends JDBCRepository implements CountriesRepository {


    private static final String TABLE_COUNTRIES = "table_countries";

    public static final String ID_COUNTY = "id_country";
    public static final String NAME_COUNTY = "name_country";
    public static final String TABLE_COMPANIES_IN_COUNTRIES = "table_companies_in_countries";

    public static final String SQL_GET_ALL_COUNTRIES = "SELECT * FROM " + TABLE_COUNTRIES;
    public static final String SQL_GET_BY_ID = "SELECT * FROM " + TABLE_COUNTRIES+ " WHERE "+ ID_COUNTY +"=%s";
    public static final String SQL_GET_BY_NAME = "SELECT * FROM " + TABLE_COUNTRIES+ " WHERE "+ NAME_COUNTY+"='%s'";
    public static final String SQL_GET_COUNTRIES_BY_ID_COMPANIES = "SELECT * FROM "+TABLE_COMPANIES_IN_COUNTRIES+" WHERE id_company='%s'";
    public static final String SQL_SET_COUNTRY_IN_COMPANIES = "INSERT INTO " + TABLE_COMPANIES_IN_COUNTRIES +" VALUES ('%s','%s')";

    private static final String SQL_CREATE_COMPANY = "INSERT INTO " + TABLE_COUNTRIES + " (" + NAME_COUNTY +") VALUES ('%s');";
    private static final String SQL_UPDATE_COMPANY_NAME  = "UPDATE " + TABLE_COUNTRIES + " SET " + NAME_COUNTY + "='%s' WHERE " + NAME_COUNTY + "='%s'";
    private static final String SQL_DELETE_COUNTRIES = "DELETE FROM " + TABLE_COUNTRIES + " WHERE " + NAME_COUNTY+ "='%s'";

    private final ProductRepository productRepository = new ImplementProductRepository();


    @Override
    public Optional<String> getCountry(String name) {
        String sql = String.format(SQL_GET_BY_NAME, name);
        return Optional.of(execute(sql,this::SetCountries));
    }

    @Override
    public List<String> getCountryByIDCompany(int id) {

        List<Integer> idCountries = new ArrayList<>();

        String sql = String.format(SQL_GET_COUNTRIES_BY_ID_COMPANIES,id);

        executeEach(sql, (resultSet) -> idCountries.add(getIDCountry(resultSet)));

        return idCountries.stream()
                .map(this::getCountry)
                .collect(Collectors.toList());
    }

    @Override
    public List<String> getCountryByIDProduct(int id) {

        Product product = productRepository.getProduct(id);
        Company company = product.getCompany();

        return getCountryByIDCompany(company.getId());
    }

    @Override
    public void setCountryInCompany(String country, int idCompany) {
        Integer idCountry = execute(String.format(SQL_GET_BY_NAME,country),this::getIDCountry);
        String sql = String.format(SQL_SET_COUNTRY_IN_COMPANIES, idCountry, idCompany);
        execute(sql);
    }

    @Override
    public Optional<String> updateCountry(String name,String newName) {
        execute(String.format(SQL_UPDATE_COMPANY_NAME,newName,name));
        return getCountry(newName);
    }

    @Override
    public Optional<String> createCountry(String name) {
        execute(String.format(SQL_CREATE_COMPANY,name));
        return getCountry(name);
    }

    @Override
    public void deleteCountry(String name) {
        execute(String.format(SQL_DELETE_COUNTRIES,name));
    }

    @Override
    public List<String> getAllCountries() {
        List<String> countries = new ArrayList<>();
        executeEach(SQL_GET_ALL_COUNTRIES,(resultSet) ->  countries.add(SetCountries(resultSet)));
        return countries;
    }

    private String getCountry(int id) {
        String sql = String.format(SQL_GET_BY_ID, id);
        return execute(sql,this::SetCountries);
    }

    private int getIDCountry(ResultSet resultSet){
        try {
            return resultSet.getInt(ID_COUNTY);
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }


    private String SetCountries(ResultSet resultSet){
        try {
            return resultSet.getString(NAME_COUNTY);
        } catch (SQLException e) {
           throw new RuntimeException(e);
        }
    }
}

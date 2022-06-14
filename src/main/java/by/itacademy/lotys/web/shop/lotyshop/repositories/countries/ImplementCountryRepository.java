package by.itacademy.lotys.web.shop.lotyshop.repositories.countries;

import by.itacademy.lotys.web.shop.lotyshop.entities.Company;
import by.itacademy.lotys.web.shop.lotyshop.entities.Product;
import by.itacademy.lotys.web.shop.lotyshop.repositories.products.ImplementProductRepository;
import by.itacademy.lotys.web.shop.lotyshop.repositories.products.ProductRepository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class ImplementCountryRepository implements CountriesRepository {


    @Override
    public Optional<String> getCountry(String name) {
        return Optional.empty();
    }

    @Override
    public List<String> getCountryByIDCompany(int id) {
        return null;
    }

    @Override
    public List<String> getCountryByIDProduct(int id) {
        return null;
    }

    @Override
    public void setCountryInCompany(String country, int idCompany) {

    }

    @Override
    public Optional<String> updateCountry(String name, String newName) {
        return Optional.empty();
    }

    @Override
    public Optional<String> createCountry(String name) {
        return Optional.empty();
    }

    @Override
    public void deleteCountry(String name) {

    }

    @Override
    public List<String> getAllCountries() {
        return null;
    }
}

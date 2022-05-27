package by.itacademy.lotys.web.shop.lotyshop.repositories.countries;

import java.util.List;
import java.util.Optional;

public interface CountriesRepository {


    Optional<String> getCountry(String name);
    List<String> getCountryByIDCompany(int id);
    List<String> getCountryByIDProduct(int id);



    void setCountryInCompany(String country, int idCompany);
    Optional<String> updateCountry(String name,String newName);
    Optional<String> createCountry(String name);
    void deleteCountry(String name);
    List<String> getAllCountries();


}

package by.itacademy.lotys.web.shop.lotyshop;


import by.itacademy.lotys.web.shop.lotyshop.repositories.countries.CountriesRepository;
import by.itacademy.lotys.web.shop.lotyshop.repositories.countries.ImplementCountryRepository;

import java.util.concurrent.SynchronousQueue;


public class Main {
    public static void main(String[] args) {
        CountriesRepository countriesRepository = new ImplementCountryRepository();

        countriesRepository.setCountryInCompany("Zhlobin",4);

        System.out.println(countriesRepository.getCountryByIDCompany(4));
    }
}

package by.itacademy.lotys.web.shop.lotyshop.services.city;

import by.itacademy.lotys.web.shop.lotyshop.entities.City;
import by.itacademy.lotys.web.shop.lotyshop.repositories.city.CityRepository;
import by.itacademy.lotys.web.shop.lotyshop.repositories.city.ImplementCityRepository;
import lombok.extern.java.Log;

import java.util.List;
import java.util.NoSuchElementException;

@Log
public class ImplementCityService implements CityService {

    private final CityRepository cityRepository = new ImplementCityRepository();

    @Override
    public City findById(Long id) {
        return cityRepository.findById(id).orElseThrow(()->new NoSuchElementException(""+id));
    }

    @Override
    public City update(City city) {
        return cityRepository.update(city).orElseThrow(()->new NoSuchElementException(""+city));
    }

    @Override
    public void create(City city) {
        cityRepository.create(city);
    }

    @Override
    public void delete(Long id) {
        try {
            cityRepository.delete(id);
        }catch (NoSuchElementException noSuchElementException){
            log.info(noSuchElementException.getMessage());
        }

    }

    @Override
    public List<City> getAll() {
        return cityRepository.getAll();
    }
}

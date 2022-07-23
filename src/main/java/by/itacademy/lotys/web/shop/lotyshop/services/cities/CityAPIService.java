package by.itacademy.lotys.web.shop.lotyshop.services.cities;

import by.itacademy.lotys.web.shop.lotyshop.entities.City;
import by.itacademy.lotys.web.shop.lotyshop.repositories.cities.CityRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CityAPIService implements CityService {

    private final CityRepository cityRepository;

    @Override
    public City getByID(UUID uuid) {
        return cityRepository.getReferenceById(uuid);
    }

    @Override
    @Transactional
    public City update(City request) {
        if(cityRepository.existsById(request.getId())){
            cityRepository.save(request);
        }
        return request;
    }

    @Override
    @Transactional
    public City delete(UUID uuid) {
        City byID = getByID(uuid);
        cityRepository.delete(byID);
        return byID;
    }

    @Override
    @Transactional
    public City create(City request) {
        return cityRepository.save(request);
    }

    @Override
    public List<City> getAll() {
        return cityRepository.findAll();
    }

}

package by.itacademy.lotys.web.shop.lotyshop.services.cities;

import by.itacademy.lotys.web.shop.lotyshop.entities.City;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CityAPIService implements CityService {

    @Override
    public City getByID(UUID uuid) {
        return null;
    }

    @Override
    public City update(City request, UUID uuid) {
        return null;
    }

    @Override
    public City delete(UUID uuid) {
        return null;
    }

    @Override
    public City create(City request) {
        return null;
    }

    @Override
    public List<City> getAll() {
        return null;
    }

}

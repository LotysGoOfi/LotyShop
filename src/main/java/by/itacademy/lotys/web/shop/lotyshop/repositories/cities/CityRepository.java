package by.itacademy.lotys.web.shop.lotyshop.repositories.cities;

import by.itacademy.lotys.web.shop.lotyshop.entities.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface CityRepository extends JpaRepository<City,UUID> {
}

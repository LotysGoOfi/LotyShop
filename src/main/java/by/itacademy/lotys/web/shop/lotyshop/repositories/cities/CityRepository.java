package by.itacademy.lotys.web.shop.lotyshop.repositories.cities;

import by.itacademy.lotys.web.shop.lotyshop.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CityRepository extends JpaRepository<UUID, User> {
}

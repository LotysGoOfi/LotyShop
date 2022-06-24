package by.itacademy.lotys.web.shop.lotyshop.repositories.user;

import by.itacademy.lotys.web.shop.lotyshop.entities.User;
import by.itacademy.lotys.web.shop.lotyshop.entities.enums.UserRole;
import by.itacademy.lotys.web.shop.lotyshop.repositories.Repository;

import java.util.List;

public interface UserRepository extends Repository<User> {
    List<User> findByRole(UserRole userRole);
}

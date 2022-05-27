package by.itacademy.lotys.web.shop.lotyshop.repositories.users;

import by.itacademy.lotys.web.shop.lotyshop.entities.User;

import java.util.List;
import java.util.Optional;

public interface UserRepository {

    Optional<User> getUser(String email);
    Optional<User> getUser(int id);
    Optional<User> addUser(String email, String nickName, String password);
    List<User> getAllUsers();
}

package by.itacademy.lotys.web.shop.lotyshop.services.users;

import by.itacademy.lotys.web.shop.lotyshop.entities.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    Optional<User> getUser(String email);
    Optional<User> getUser(int id);
    Optional<User> createUser(String email,String nickName,String password);
    List<User> getAllUsers();
}

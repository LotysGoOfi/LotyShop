package by.itacademy.lotys.web.shop.lotyshop.repositories.users;

import by.itacademy.lotys.web.shop.lotyshop.entities.User;

import java.util.List;

public interface UserRepository {
    User getUser(String email);
    User getUser(int id);
    User addUser(String email, String nickName, String password);
    List<User> getAllUsers();
}

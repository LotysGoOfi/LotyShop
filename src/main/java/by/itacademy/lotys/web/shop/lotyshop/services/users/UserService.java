package by.itacademy.lotys.web.shop.lotyshop.services.users;

import by.itacademy.lotys.web.shop.lotyshop.entities.User;

import java.util.List;

public interface UserService {
    User getUser(String email);
    User getUser(int id);
    User createUser(String email,String nickName,String password);
    List<User> getAllUsers();
}

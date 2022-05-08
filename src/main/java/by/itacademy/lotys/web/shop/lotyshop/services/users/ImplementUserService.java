package by.itacademy.lotys.web.shop.lotyshop.services.users;

import by.itacademy.lotys.web.shop.lotyshop.entities.User;
import by.itacademy.lotys.web.shop.lotyshop.repositories.users.ImplementUserRepository;
import by.itacademy.lotys.web.shop.lotyshop.repositories.users.UserRepository;

import java.util.List;

public class ImplementUserService implements UserService {

    private final UserRepository userRepository = new ImplementUserRepository();

    @Override
    public User getUser(String email) {
        return userRepository.getUser(email);
    }

    @Override
    public User getUser(int id) {
        return userRepository.getUser(id);
    }

    @Override
    public User createUser(String email, String nickName, String password) {
        return userRepository.addUser(email,nickName,password);
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.getAllUsers();
    }
}

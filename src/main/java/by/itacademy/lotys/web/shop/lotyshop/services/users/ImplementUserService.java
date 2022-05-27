package by.itacademy.lotys.web.shop.lotyshop.services.users;

import by.itacademy.lotys.web.shop.lotyshop.entities.User;
import by.itacademy.lotys.web.shop.lotyshop.repositories.users.ImplementUserRepository;
import by.itacademy.lotys.web.shop.lotyshop.repositories.users.UserRepository;

import java.util.List;
import java.util.Optional;

public class ImplementUserService implements UserService {

    private final UserRepository userRepository = new ImplementUserRepository();

    @Override
    public Optional<User> getUser(String email) {
        return userRepository.getUser(email);
    }

    @Override
    public Optional<User> getUser(int id) {
        return userRepository.getUser(id);
    }

    @Override
    public Optional<User> createUser(String email, String nickName, String password) {
        return userRepository.addUser(email,nickName,password);
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.getAllUsers();
    }


}

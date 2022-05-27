package by.itacademy.lotys.web.shop.lotyshop.repositories.users;

import by.itacademy.lotys.web.shop.lotyshop.entities.User;

import java.util.List;
import java.util.Optional;

public class ImplementUserRepository implements UserRepository {


    @Override
    public Optional<User> getUser(String email) {
        return null;
    }

    @Override
    public Optional<User> getUser(int id) {
        return null;
    }

    @Override
    public Optional<User> addUser(String email, String nickName, String password) {
        return null;
    }

    @Override
    public List<User> getAllUsers() {
        return null;
    }
}

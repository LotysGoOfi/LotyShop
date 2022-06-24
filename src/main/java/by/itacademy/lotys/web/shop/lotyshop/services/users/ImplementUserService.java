package by.itacademy.lotys.web.shop.lotyshop.services.users;

import by.itacademy.lotys.web.shop.lotyshop.entities.User;


import java.util.List;
import java.util.Optional;

public class ImplementUserService implements UserService {


    @Override
    public Optional<User> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public Optional<User> update(User entity) {
        return Optional.empty();
    }

    @Override
    public void create(User entity) {

    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public List<User> getAll() {
        return null;
    }
}

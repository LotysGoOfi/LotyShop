package by.itacademy.lotys.web.shop.lotyshop.services.users;

import by.itacademy.lotys.web.shop.lotyshop.entities.User;
import by.itacademy.lotys.web.shop.lotyshop.repositories.user.ImplementUserRepository;
import by.itacademy.lotys.web.shop.lotyshop.repositories.user.UserRepository;
import lombok.extern.java.Log;


import java.util.List;
import java.util.NoSuchElementException;

@Log
public class ImplementUserService implements UserService {

    private final UserRepository userRepository = new ImplementUserRepository();

    @Override
    public User findById(Long id) {
        return userRepository.findById(id).orElseThrow(()->new NoSuchElementException(""+id));
    }

    @Override
    public User update(User user) {
        return userRepository.update(user).orElseThrow(()->new NoSuchElementException(""+user));
    }

    @Override
    public void create(User user) {
        userRepository.create(user);
    }

    @Override
    public void delete(Long id) {
        try {
            userRepository.delete(id);
        }catch (NoSuchElementException noSuchElementException){
            log.info(noSuchElementException.getMessage());
        }

    }

    @Override
    public List<User> getAll() {
        return userRepository.getAll();
    }
}

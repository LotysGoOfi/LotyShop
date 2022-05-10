package by.itacademy.lotys.web.shop.lotyshop.repositories.users;

import by.itacademy.lotys.web.shop.lotyshop.dao.DAO;
import by.itacademy.lotys.web.shop.lotyshop.dao.DAOLocalDataBase;
import by.itacademy.lotys.web.shop.lotyshop.entities.User;

import java.util.List;

public class ImplementUserRepository implements UserRepository {

    private final DAO dao = new DAOLocalDataBase();

    @Override
    public User getUser(String email) {
        return dao.getUser(email);
    }

    @Override
    public User getUser(int id) {
        return dao.getUser(id);
    }

    @Override
    public User addUser(String email, String nickName, String password) {
        return dao.createUser(email,nickName,password);
    }

    @Override
    public List<User> getAllUsers() {
        return dao.getAllUsers();
    }
}

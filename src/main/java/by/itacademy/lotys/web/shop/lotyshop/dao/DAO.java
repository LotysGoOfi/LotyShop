package by.itacademy.lotys.web.shop.lotyshop.dao;

import by.itacademy.lotys.web.shop.lotyshop.entities.Company;
import by.itacademy.lotys.web.shop.lotyshop.entities.Product;
import by.itacademy.lotys.web.shop.lotyshop.entities.User;

import java.util.List;

public interface DAO {

    Company getCompany(int id);
    Company getCompany(String name);
    Company updateCompany(int id,String name);
    Company createCompany(String name);
    void deleteCompany(int id);
    List<Company> getAllCompanies();

    Product getProduct(int id);
    Product addProduct();
    List<Product> getAllProducts();

    User getUser(int id);
    User getUser(String email);
    User addUser(String email, String nickName, String password);
    List<User> getAllUsers();
}

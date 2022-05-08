package by.itacademy.lotys.web.shop.lotyshop.dao;

import by.itacademy.lotys.web.shop.lotyshop.connections.DBConnection;
import by.itacademy.lotys.web.shop.lotyshop.entities.Company;
import by.itacademy.lotys.web.shop.lotyshop.entities.Product;
import by.itacademy.lotys.web.shop.lotyshop.entities.User;
import by.itacademy.lotys.web.shop.lotyshop.entities.enumes.UserRole;
import by.itacademy.lotys.web.shop.lotyshop.properties.Config;
import lombok.extern.java.Log;


import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;

@Log
public class DAOLocalDataBase implements DAO {

    private final static Connection connection = new DBConnection().getConnection();



    @Override
    public Company getCompany(int id) {
        String sql = String.format(Config.SQL_GET_COMPANY_BY_ID, id);
        try {
            ResultSet resultSet = connection.createStatement().executeQuery(sql);
            if (resultSet.next()) {
                return setCompany(resultSet);
            } else {
                return null;
            }
        } catch (SQLException exception) {
            throw new RuntimeException(exception);
        }
    }

    @Override
    public Company getCompany(String name) {
        String sql = String.format(Config.SQL_GET_COMPANY_BY_NAME, name);
        try {
            ResultSet resultSet = connection.createStatement().executeQuery(sql);
            if (resultSet.next()) {
                return setCompany(resultSet);
            } else {
                return null;
            }
        } catch (SQLException exception) {
            throw new RuntimeException(exception);
        }
    }

    @Override
    public Company updateCompany(int id,String name) {
        String sql = String.format(Config.SQL_UPDATE_COMPANY, name,id);
        try {
            connection.createStatement().executeUpdate(sql);

            return getCompany(id);

        } catch (SQLException exception) {
            throw new RuntimeException(exception);
        }
    }

    @Override
    public Company createCompany(String name) {
        String sql = String.format(Config.SQL_CREATE_COMPANY, name);
        try {
            connection.createStatement().execute(sql);

            return getCompany(name);

        } catch (SQLException exception) {
            throw new RuntimeException(exception);
        }
    }

    @Override
    public void deleteCompany(int id) {
        String sql = String.format(Config.SQL_DELETE_COMPANY,id);
        try {
            connection.createStatement().execute(sql);

        } catch (SQLException exception) {
            throw new RuntimeException(exception);
        }
    }

    @Override
    public List<Company> getAllCompanies() {
        try {
            ResultSet resultSet = connection.createStatement().executeQuery(Config.SQL_GET_ALL_COMPANIES);
            List<Company> products = new ArrayList<>();
            while (resultSet.next()) {
                products.add(setCompany(resultSet));
            }
            return products;
        } catch (SQLException exception) {
            throw new RuntimeException(exception);
        }
    }

    @Override
    public Product getProduct(int id) {
        String sql = String.format(Config.SQL_GET_PRODUCT_BY_ID, id);
        try {
            ResultSet resultSet = connection.createStatement().executeQuery(sql);
            if (resultSet.next()) {
                return setProduct(resultSet);
            } else {
                return null;
            }
        } catch (SQLException exception) {
            throw new RuntimeException(exception);
        }
    }

    @Override
    public Product addProduct() {
        return null;
    }

    @Override
    public List<Product> getAllProducts() {
        try {
            ResultSet resultSet = connection.createStatement().executeQuery(Config.SQL_GET_ALL_PRODUCT);
            List<Product> products = new ArrayList<>();
            while (resultSet.next()) {
                products.add(setProduct(resultSet));
            }
            return products;
        } catch (SQLException exception) {
            throw new RuntimeException(exception);
        }
    }

    @Override
    public User getUser(int id) {
        String sql = String.format(Config.SQL_GET_USER_BY_ID, id);
        return execute(sql, this::setUser);
    }

    @Override
    public User getUser(String email) {
        String sql = String.format(Config.SQL_GET_USER_BY_EMAIL, email);
        return execute(sql,this::setUser);
    }

    @Override
    public User addUser(String email, String nickName, String password) {
        String sql = String.format(Config.SQL_CREATE_USER,email, nickName, password);
        try {
            connection.createStatement().execute(sql);
            return getUser(email);
        } catch (SQLException exception) {
            throw new RuntimeException(exception);
        }
    }

    @Override
    public List<User> getAllUsers() {
        List<User> users = new ArrayList<>();
        executeEach(Config.SQL_GET_ALL_USERS,resultSet -> users.add(setUser(resultSet)));
        return users;
    }

    private User setUser(ResultSet resultSet) {
        try {

            int id = resultSet.getInt("id");
            UserRole userRole = UserRole.valueOf(resultSet.getString("user_role"));
            String email = resultSet.getString("email");
            String nickName = resultSet.getString("nick_name");
            String password = resultSet.getString("password");

            return new User(id,userRole,email, nickName, password);
        } catch (SQLException exception) {
            throw new RuntimeException(exception);
        }
    }

    private Product setProduct(ResultSet resultSet) {
        try {
            int id = resultSet.getInt("id");
            int price = resultSet.getInt("price");
            int idCompany = resultSet.getInt("id_company");
            int appraisal = resultSet.getInt("appraisal");
            String name = resultSet.getString("name");
            int value = resultSet.getInt("value");
            String description = resultSet.getString("description");
            String url_image = resultSet.getString("url_image");
            Company company = getCompany(idCompany);
            return new Product(id,company,price,appraisal,name,value,description,url_image);
        } catch (SQLException exception) {
            throw new RuntimeException(exception);
        }
    }
    private Company setCompany(ResultSet resultSet) {
        try {
            int id = resultSet.getInt("id");
            String name = resultSet.getString("name");
            return new Company(id,name);
        } catch (SQLException exception) {
            throw new RuntimeException(exception);

        }
    }

    private<A> A execute(String sql, Function<ResultSet,A> method) {
        try {
            ResultSet resultSet = connection.createStatement().executeQuery(sql);
            if (resultSet.next()) {
                return method.apply(resultSet);
            } else {
                return null;
            }
        } catch (SQLException exception) {
            throw new RuntimeException(exception);
        }
    }

    private void executeEach(String sql, Consumer<ResultSet> method) {
        try {
            ResultSet resultSet = connection.createStatement().executeQuery(sql);
            while (resultSet.next()) {
                method.accept(resultSet);
            }
        } catch (SQLException exception) {
            throw new RuntimeException(exception);
        }
    }
}
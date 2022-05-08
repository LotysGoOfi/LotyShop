package by.itacademy.lotys.web.shop.lotyshop.connections;

import by.itacademy.lotys.web.shop.lotyshop.properties.Config;
import lombok.extern.java.Log;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@Log
public class DBConnection {


    public Connection getConnection() {
        try {
            Class.forName(Config.DB_DRIVER);
            log.info(": connection DB");
            return DriverManager.getConnection(Config.DB_URL,Config.DB_USERNAME,Config.DB_PASSWORD);
        } catch (SQLException | ClassNotFoundException exception) {
            throw new RuntimeException(exception);
        }
    }

}

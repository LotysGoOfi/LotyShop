package by.itacademy.lotys.web.shop.lotyshop.repositories;

import by.itacademy.lotys.web.shop.lotyshop.connections.DBConnection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.function.Consumer;
import java.util.function.Function;

public abstract class JDBCRepository {

    private static final Connection connection = new DBConnection().getConnection();


    protected void execute(String sql){
        try {
            connection.createStatement().execute(sql);
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

    protected  <A> A execute(String sql, Function<ResultSet,A> method) {
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


    protected void executeEach(String sql, Consumer<ResultSet> method) {
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

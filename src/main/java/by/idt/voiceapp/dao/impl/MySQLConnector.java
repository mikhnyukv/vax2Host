package by.idt.voiceapp.dao.impl;

import by.idt.voiceapp.bean.User;
import by.idt.voiceapp.dao.DBConnector;

import java.lang.reflect.InvocationTargetException;
import java.sql.*;

public class MySQLConnector implements DBConnector {
    private final String URL = "jdbc:mysql://localhost:3306/userdb?serverTimezone=UTC";
    private final String USERNAME = "root";
    private final String PASSWORD = "ivan";

    @Override
    public int save(User user, boolean status) {
        int rows;
        try {
            Class.forName("com.mysql.jdbc.Driver").getDeclaredConstructor().newInstance();
            Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            String sql = "INSERT INTO users (id, full_name, entrance_date, entance_status) VALUES (?, ?, ?, ?)";
            Date date = new Date(System.currentTimeMillis());
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, user.getId());
            preparedStatement.setString(2, user.getFullName());
            preparedStatement.setDate(3, date);
            preparedStatement.setBoolean(4, status);
            rows = preparedStatement.executeUpdate();
            connection.close();
            return rows;
        } catch (SQLException e) {
            e.printStackTrace();
            return 0;
        } catch (InstantiationException e) {
            e.printStackTrace();
            return 0;
        } catch (InvocationTargetException e) {
            e.printStackTrace();
            return 0;
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
            return 0;
        } catch (IllegalAccessException e) {
            e.printStackTrace();
            return 0;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return 0;
        }
    }
}

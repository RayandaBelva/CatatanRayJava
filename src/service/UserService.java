package service;

import java.sql.SQLException;

import src.entity.User;

public interface UserService {
    void registerUser(User user) throws SQLException;
    User findById(String UserID) throws SQLException;
    void deleteById(String id) throws SQLException;
    void updateUser(String id, User newUser) throws SQLException;
}


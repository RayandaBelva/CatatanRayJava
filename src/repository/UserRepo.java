package src.repository;

import java.sql.SQLException;
import java.util.List;

import src.entity.User;

public interface UserRepo {
    void create(User user) throws SQLException;
    User getUserByID(String UserID) throws SQLException;
    void updateUser(String UserID, User updatedUser) throws SQLException;
    void deleteUser(String UserID) throws SQLException;
    List<User> getAllUsers() throws SQLException;
}

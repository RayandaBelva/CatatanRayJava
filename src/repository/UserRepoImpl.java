package src.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import src.entity.User;

public class UserRepoImpl implements UserRepo {
    private final Connection db;

    public UserRepoImpl(Connection db) {
        this.db = db;
    }

      @Override
    public User getUserByID(String UserID) throws SQLException {
        src.entity.User user = new src.entity.User();
        String query = "SELECT user_id, user_name, address, email, phone_number, debt, kredit FROM users WHERE user_id = ?";
        try (PreparedStatement statement = db.prepareStatement(query)) {
            statement.setString(1, UserID);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                user.setUserID(resultSet.getString("user_id"));
                user.setUserName(resultSet.getString("user_name"));
                user.setAddress(resultSet.getString("address"));
                user.setEmail(resultSet.getString("email"));
                user.setPhoneNumber(resultSet.getInt("phone_number"));
                user.setDebt(resultSet.getInt("debt"));
                user.setKredit(resultSet.getInt("kredit"));
            }
        }
        return user;
    }

    @Override
    public void create(User user) throws SQLException {
        String query = "INSERT INTO users (user_name, password, address, email, phone_number, debt, kredit) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement statement = db.prepareStatement(query)) {
            statement.setString(1, user.getUserName());
            statement.setString(2, user.getPassword());
            statement.setString(3, user.getAddress());
            statement.setString(4, user.getEmail());
            statement.setInt(5, user.getPhoneNumber());
            statement.setInt(6, user.getDebt());
            statement.setInt(7, user.getKredit());
            statement.executeUpdate();
        }
    }

    @Override
    public void updateUser(String UserID, User updatedUser) throws SQLException {
        String query = "UPDATE users SET user_name = ?, password = ?, address = ?, email = ?, phone_number = ?, debt = ?, kredit = ? WHERE user_id = ?";
        try (PreparedStatement statement = db.prepareStatement(query)) {
            statement.setString(1, updatedUser.getUserName());
            statement.setString(2, updatedUser.getPassword());
            statement.setString(3, updatedUser.getAddress());
            statement.setString(4, updatedUser.getEmail());
            statement.setInt(5, updatedUser.getPhoneNumber());
            statement.setInt(6, updatedUser.getDebt());
            statement.setInt(7, updatedUser.getKredit());
            statement.setString(8, UserID);
            statement.executeUpdate();
        }
    }

    @Override
    public void deleteUser(String UserID) throws SQLException {
        String query = "DELETE FROM users WHERE id = ?";
        try (PreparedStatement statement = db.prepareStatement(query)) {
            statement.setString(1, UserID);
            statement.executeUpdate();
        }
    }

    @Override
    public List<User> getAllUsers() throws SQLException {
        List<User> users = new ArrayList<>();
        String query = "SELECT user_id, user_name, address, email, phone_number, debt, kredit FROM users";
        try (PreparedStatement statement = db.prepareStatement(query);
             ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                User user = new User();
                user.setUserID(resultSet.getString("user_id"));
                user.setUserName(resultSet.getString("user_name"));
                user.setAddress(resultSet.getString("address"));
                user.setEmail(resultSet.getString("email"));
                user.setPhoneNumber(resultSet.getInt("phone_number"));
                user.setDebt(resultSet.getInt("debt"));
                user.setKredit(resultSet.getInt("kredit"));
                users.add(user);
            }
        }
        return users;
    }
}
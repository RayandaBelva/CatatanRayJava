package service;

import java.sql.SQLException;

import src.entity.User;
import src.repository.*;

public class UserServiceImpl implements UserService {
    private final UserRepo userRepo;

    public UserServiceImpl(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    @Override
    public void registerUser(User user) throws SQLException {
        userRepo.create(user);
    }

    @Override
    public User findById(String UserID) throws SQLException {
        return userRepo.getUserByID(UserID);
    }

    @Override
    public void updateUser(String id, User newUser) throws SQLException {
        userRepo.updateUser(id, newUser);
    }
    
    @Override
    public void deleteById(String id) throws SQLException {
        userRepo.deleteUser(id);
    }
}
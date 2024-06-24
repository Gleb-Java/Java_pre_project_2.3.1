package CRUDApp.service;

import CRUDApp.model.User;

import java.util.List;

public interface UserService {
    void insertUser(User user);
    void updateUser(int id,User user);
    void deleteUser(User user);
    User getUserById(int id);
    List<User> getAllUsers();
}

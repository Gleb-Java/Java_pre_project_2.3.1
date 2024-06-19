package CRUDApp.service;

import CRUDApp.model.User;

import java.util.List;

public interface UserService {
    public void insertUser(User user);
    public void updateUser(int id,User user);
    public void deleteUserById(User user);
    public User getUserById(int id);
    public List<User> getAllUsers();
}

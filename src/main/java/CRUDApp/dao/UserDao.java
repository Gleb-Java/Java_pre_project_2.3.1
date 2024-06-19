package CRUDApp.dao;

import CRUDApp.model.User;
import java.util.List;

public interface UserDao {
    public void insertUser(User user);
    public void updateUser(User user);
    public void deleteUser(User user);
    public User getUserById(int id);
    public List<User> getAllUsers();
}

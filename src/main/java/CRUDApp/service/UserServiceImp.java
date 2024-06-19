package CRUDApp.service;

import CRUDApp.dao.UserDao;
import CRUDApp.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserServiceImp implements UserService {

    private final UserDao userDao;

    @Autowired
    public UserServiceImp(UserDao userDao) {
        this.userDao = userDao;
    }

    @Transactional
    @Override
    public void insertUser(User user){
        userDao.insertUser(user);
    }

    @Transactional
    @Override
    public void updateUser(int id,User updateUser){
        User existingUser = userDao.getUserById(id);
        if(existingUser != null){
            existingUser.setName(updateUser.getName());
            existingUser.setEmail(updateUser.getEmail());
            userDao.updateUser(existingUser);
        }
    }

    @Transactional
    @Override
    public void deleteUserById(User user){
        userDao.deleteUser(user);
    }

    @Transactional
    @Override
    public User getUserById(int id){
        return userDao.getUserById(id);
    }

    @Transactional
    @Override
    public List<User> getAllUsers(){
        return userDao.getAllUsers();
    }

}

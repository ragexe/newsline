package by.newsline.dao;

import data.User;
import java.util.List;



public interface IUserDao {
    void saveUser(User user);
    void deleteUserById(long id);
    User getById(long id);
    List<User> getAllUsers();
}

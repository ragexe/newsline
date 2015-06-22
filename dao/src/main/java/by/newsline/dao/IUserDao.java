package by.newsline.dao;

import by.newsline.dao.util.exception.DaoException;
import by.newsline.data.User;
import java.util.List;


public interface IUserDao {
    void saveUser(User user) throws DaoException;
    void deleteUserById(long id) throws DaoException;
    User getById(long id) throws DaoException;
    User getByEmail(String email) throws DaoException;
    List<User> getAllUsers() throws DaoException;
    List<User> getAllBannedUsers() throws DaoException;
    void unBannedUser(long id) throws DaoException;
}

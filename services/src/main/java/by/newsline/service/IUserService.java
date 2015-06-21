package by.newsline.service;


import by.newsline.service.util.exception.ServiceException;
import data.User;


public interface IUserService {
    boolean checkUser(String email, String password) throws ServiceException;
    boolean registerNewUser(User User) throws ServiceException;
    User getByEmail(String email) throws ServiceException;
    void saveUser(User user) throws ServiceException;
    void deleteUserById(long id) throws ServiceException;
    User getById(long id) throws ServiceException;
}

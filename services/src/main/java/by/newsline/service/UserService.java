package by.newsline.service;


import by.newsline.dao.IUserDao;
import by.newsline.dao.util.exception.DaoException;
import by.newsline.data.User;
import by.newsline.data.util.RoleEnum;
import by.newsline.data.util.StatusEnum;
import by.newsline.service.util.exception.ServiceException;
import com.mysql.jdbc.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


/**
 * Created by ragexe on 29.04.15.
 */

@Service
@Transactional(propagation = Propagation.REQUIRED)
public class UserService implements IUserService {
    private static final Logger logger = Logger.getLogger(UserService.class);

    @Autowired
    private IUserDao userDao;

    public boolean checkUser(String email, String password) throws ServiceException {
        if (!(StringUtils.isNullOrEmpty(email)) && !(StringUtils.isNullOrEmpty(password))) {
            try {
                List<User> userList = userDao.getAllUsers();
                for (User userElement : userList) {
                    if ((userElement.getEmail().equals(email))
                            && (userElement.getPassword().equals(password))) {
                        return true;
                    }
                }
            } catch (DaoException e) {
                logger.error(e.getMessage());
                throw new ServiceException(e);
            }
        }
        return false;
    }

    public boolean registerNewUser(User user) throws ServiceException {
        if (user != null) {
            try {
                List<User> users = userDao.getAllUsers();
                for (User element : users) {
                    if (element.getEmail().equals(user.getEmail())||
                                                    element.getName().equals(user.getName()))  {
                        return false;
                    }
                }
                userDao.saveUser(user);
                return true;
            } catch (DaoException e) {
                logger.error(e.getMessage());
                throw new ServiceException(e);
            }
        }
        return false;
    }

    public User getByEmail(String email) throws ServiceException {
        try {
            return userDao.getByEmail(email);
        } catch (DaoException e) {
            logger.error(e.getMessage());
            throw new ServiceException(e);
        }
    }

    public void saveUser(User user) throws ServiceException {
        user.setStatus(StatusEnum.SAVED);
        user.setAccess(RoleEnum.ROLE_USER);
        try {
            userDao.saveUser(user);
        } catch (DaoException e) {
            logger.error(e.getMessage());
            throw new ServiceException(e);
        }
    }

    public void deleteUserById(long id) throws ServiceException {
        try {
            userDao.deleteUserById(id);
        } catch (DaoException e) {
            logger.error(e.getMessage());
            throw new ServiceException(e);
        }
    }

    public User getById(long id) throws ServiceException {
        try {
            return userDao.getById(id);
        } catch (DaoException e) {
            logger.error(e.getMessage());
            throw new ServiceException(e);
        }
    }


    public List<User> getAllUser() throws ServiceException {
        try {
            return userDao.getAllUsers();
        } catch (DaoException e) {
            logger.error(e.getMessage());
            throw new ServiceException();
        }

    }


    public List<User> getAllBannedUsers() throws ServiceException {
        try {
            return userDao.getAllBannedUsers();
        } catch (DaoException e) {
            logger.error(e.getMessage());
            throw new ServiceException();
        }
    }

    public void unBannedUser(long id) throws ServiceException{
        try {
            userDao.unBannedUser(id);
        } catch (DaoException e) {
            logger.error(e.getMessage());
            throw new ServiceException(e);
        }
    }
}

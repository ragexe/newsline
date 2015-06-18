package util;


import com.mysql.jdbc.StringUtils;
import dao.UserDao;
import daofactory.DaoFactoryImpl;
import daofactory.IDaoFactory;
import data.User;
import exception.PersistException;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;


/**
 * Created by ragexe on 29.04.15.
 */

@Service
public class UserService implements IUserService {
    private static final Logger logger = Logger.getLogger(UserService.class);

    private static UserService userServiceInst;


    private UserDao userDao;


    private UserService() {
        IDaoFactory factory = DaoFactoryImpl.getInstance();
        try {
            userDao = (UserDao) factory.getDao(User.class);
        } catch (PersistException e) {
            logger.error(e);
        }
    }

    public static synchronized UserService getInstance(){
        if (userServiceInst == null){
            userServiceInst = new UserService();
        }
        return userServiceInst;
    }

    @Override
    public User getByPK(Long pK) {
        if (pK != null) {
            User user = null;
            try {
                user = userDao.getByPK(pK);
            } catch (PersistException e) {
                logger.error(e);
            }
            return user;
        }
        return null;
    }

    /**
     * Server validation of user
     * @param email    - email-adress of user who want to autenitcate to site
     * @param password - password of user who want to autenitcate to site
     * @return true, if user in database (registered), or false, if user not registered
     */
    @Override
    public boolean checkUser(String email, String password) {
        if (!(StringUtils.isNullOrEmpty(email)) && !(StringUtils.isNullOrEmpty(password))) {
            try {
                List<User> userList = userDao.getAll();
                for (User userElement : userList) {//
                    if ((userElement.getEmail().equals(email))
                            && (userElement.getPassword().equals(password))) {
                        return true;
                    }
                }
            } catch (PersistException e) {
                logger.error(e);
            }
        }
        return false;
    }

    /**
     * Get registered user from database
     * @param email - field in column, identified userØ
     * @return User user
     */
    @Override
    public User authenticationProcess(String email) {
        if (!(StringUtils.isNullOrEmpty(email))) {
            User user = null;
            try {
                user = userDao.getByEmail(email);
            } catch (PersistException e) {
                logger.error(e);
            }
            return user;
        }
        return null;
    }

    @Override
    @Transactional
    public boolean registerNewUser(User user) {
        if (user != null) {
            try {
                List<User> users = userDao.getAll();
                for (User element : users) {
                    if (element.getEmail().equals(user.getEmail())) {
                        return false;
                    }
                }
                userDao.save(user);
                return true;
            } catch (PersistException e) {
                logger.error(e);
            }
        }
        return false;
    }

    @Override
    @Transactional
    public User getUserByEmail(String email) {
        if (!(StringUtils.isNullOrEmpty(email))) {
            User user = null;
            try {
                user = userDao.getByEmail(email);
            } catch (PersistException e) {
                logger.error(e);
            }
            return user;
        }
        return null;
    }

    @Override
    @Transactional
    public User getUserById(long id) {
            User user = null;
            try {
                user = userDao.getById(id);
            } catch (PersistException e) {
                logger.error(e);
            }
            return user;
    }

    @Override
    @Transactional
    public void updateUserInformation(User user) {
        if (user.getId() != 0
                && user.getId() != 0
                && user.getId() > 0) {
            try {
                userDao.update(user);
            } catch (PersistException e) {
                logger.error(e);
            }
        }
    }


}

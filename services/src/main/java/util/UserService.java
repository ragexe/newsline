package util;


import com.mysql.jdbc.StringUtils;
import dao.UserDao;
import daofactory.DaoFactoryImpl;
import daofactory.IDaoFactory;
import data.User;
import exception.PersistException;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;


/**
 * Created by ragexe on 29.04.15.
 */

public class UserService implements IUserService {
    private static final Logger logger = Logger.getLogger(UserService.class);

    private static UserService userServiceInst;
    private final ThreadLocal sessionStatus = new ThreadLocal();

    private UserDao userDao;
    private Session session;
    private Transaction transaction;

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
                session = userDao.getSession();
                transaction = session.beginTransaction();
                user = userDao.getByPK(pK);
                transaction.commit();
            } catch (PersistException e) {
                transaction.rollback();
                logger.error(e);
            }finally {
                sessionStatus.set(true);
                userDao.clearSession(sessionStatus);
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
                session = userDao.getSession();
                transaction = session.beginTransaction();
                List<User> userList = userDao.getAll();
                transaction.commit();
                for (User userElement : userList) {
//                    if ((userElement.getUserDetail().getEmail().equals(email))
//                            && (userElement.getUserDetail().getPassword().equals(password))) {
//                        return true;
//                    }
                    if ((userElement.getEmail().equals(email))
                            && (userElement.getPassword().equals(password))) {
                        return true;
                    }
                }
            } catch (PersistException e) {
                transaction.rollback();
                logger.error(e);
            }finally {
                sessionStatus.set(true);
                userDao.clearSession(sessionStatus);
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
                session = userDao.getSession();
                transaction = session.beginTransaction();
                user = userDao.getByEmail(email);
                transaction.commit();
            } catch (PersistException e) {
                transaction.rollback();
                logger.error(e);
            }finally {
                sessionStatus.set(true);
                userDao.clearSession(sessionStatus);
            }
            return user;
        }
        return null;
    }

    @Override
    public boolean registerNewUser(User user) {
        if (user != null) {
            try {
                session = userDao.getSession();
                transaction = session.beginTransaction();
                List<User> users = userDao.getAll();
                transaction.commit();
//                for (User element : users) {
//                    if (element.getUserDetail().getEmail().equals(user.getuserDetail().getEmail())) {
//                        return false;
//                    }
//                }
                for (User element : users) {
                    if (element.getEmail().equals(user.getEmail())) {
                        return false;
                    }
                }
                userDao.save(user);
                return true;
            } catch (PersistException e) {
                transaction.rollback();
                logger.error(e);
            }finally {
                sessionStatus.set(true);
                userDao.clearSession(sessionStatus);
            }
        }
        return false;
    }

    @Override
    public User getUserByEmail(String email) {
        if (!(StringUtils.isNullOrEmpty(email))) {
            User user = null;
            try {
                session = userDao.getSession();
                transaction = session.beginTransaction();
                user = userDao.getByEmail(email);
                transaction.commit();
            } catch (PersistException e) {
                transaction.rollback();
                logger.error(e);
            }finally {
                sessionStatus.set(true);
                userDao.clearSession(sessionStatus);
            }
            return user;
        }
        return null;
    }

    @Override
    public void updateUserInformation(User user) {
        if (user.getId() != 0
//                && user.getId() != ServiceConstants.Const.ZERO
//                && user.getId() > ServiceConstants.Const.ZERO) {
                && user.getId() != 0
                && user.getId() > 0) {
            try {
                session = userDao.getSession();
                transaction = session.beginTransaction();
                userDao.update(user);
                transaction.commit();
            } catch (PersistException e) {
                transaction.rollback();
                logger.error(e);
            }finally {
                sessionStatus.set(true);
                userDao.clearSession(sessionStatus);
            }
        }
    }


}

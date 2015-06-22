package by.newsline.dao;

import by.newsline.dao.util.exception.DaoException;
import by.newsline.data.User;
import by.newsline.data.util.StatusEnum;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.intellij.lang.annotations.Language;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Repository("userDao")
@Transactional(propagation = Propagation.MANDATORY)
public class UserDaoImpl extends AbstractDao implements IUserDao{
    private static final Logger logger = Logger.getLogger(UserDaoImpl.class);

    public void saveUser(User user) throws DaoException {
        persist(user);
    }

    public void deleteUserById(long id)  throws DaoException {
        Session session = getSession();
        User user = (User) session.load(User.class, id);
        user.setStatus(StatusEnum.DELETED);
        session.update(user);
        /*try {
            StatusEnum status = StatusEnum.DELETED;
            @Language("HQL") String hql = "UPDATE User SET User.status=:status WHERE User.id=:id";
            Query query = getSession().createQuery(hql)
                    .setParameter("status", status);
            int res = query.executeUpdate();
            if (res > 1){
                logger.warn("delete more than one line at deleteUserById-method");
            }
        } catch (HibernateException e) {
            logger.error(e.getMessage());
            throw new DaoException(e);
        }*/
    }

    @SuppressWarnings("unchecked")
    public List<User> getAllUsers()  throws DaoException {
        List<User> users = null;
        try {
            StatusEnum status = StatusEnum.SAVED;
            @Language("HQL") String hql = "SELECT U FROM User U WHERE U.status=:status";
            Query query = getSession().createQuery(hql)
                    .setParameter("status", status);
            users = query.list();
        } catch (HibernateException e) {
            logger.error(e.getMessage());
            throw new DaoException(e);
        }
        return users;
    }

    @Override
    public List<User> getAllBannedUsers() throws DaoException {
        List<User> users = null;
        try {
            StatusEnum status = StatusEnum.DELETED;
            @Language("HQL") String hql = "SELECT U FROM User U WHERE U.status=:status";
            Query query = getSession().createQuery(hql)
                    .setParameter("status", status);
            users = query.list();
        } catch (HibernateException e) {
            logger.error(e.getMessage());
            throw new DaoException(e);
        }
        return users;

    }


    public void unBannedUser(long id) throws DaoException {
        Session session = getSession();
        User user = (User) session.load(User.class, id);
        user.setStatus(StatusEnum.SAVED);
        session.update(user);
    }

    public User getById(long id)  throws DaoException {
        User User = null;
        try {
            StatusEnum status = StatusEnum.SAVED;
            @Language("HQL") String hql = "SELECT c FROM User c WHERE c.id=:id and c.status=:status";
            Query query = getSession().createQuery(hql)
                    .setParameter("id", id)
                    .setParameter("status", status);
            User = (User) query.uniqueResult();
        } catch (HibernateException e) {
            logger.error(e.getMessage());
            throw new DaoException(e);
        }
        return User;
    }

    public User getByEmail(String email) throws DaoException {
        User User = null;
        try {
            StatusEnum status = StatusEnum.SAVED;
            @Language("HQL") String hql = "SELECT c FROM User c WHERE c.email=:email and c.status=:status";
            Query query = getSession().createQuery(hql)
                    .setParameter("email", email)
                    .setParameter("status", status);
            User = (User) query.uniqueResult();
        } catch (HibernateException e) {
            logger.error(e.getMessage());
            throw new DaoException(e);
        }
        return User;
    }
}

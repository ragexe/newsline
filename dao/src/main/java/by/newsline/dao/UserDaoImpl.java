package by.newsline.dao;

import data.User;
import data.util.StatusEnum;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.intellij.lang.annotations.Language;
import org.springframework.stereotype.Repository;

import java.util.List;


/**
 * Created by ragexe on 13.04.15.
 * Class for working with persistence entity of User
 */
@Repository("userDao")
public class UserDaoImpl extends AbstractDao implements IUserDao{
    private static final Logger logger = Logger.getLogger(UserDaoImpl.class);

    public void saveUser(User user) {
        persist(user);
    }

    public void deleteUserById(long id) {
        try {
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
//            throw new PersistException(e);
        }
    }

    @SuppressWarnings("unchecked")
    public List<User> getAllUsers() {
        List<User> categories = null;
        try {
            StatusEnum status = StatusEnum.SAVED;
            @Language("HQL") String hql = "SELECT C FROM User C WHERE C.status=:status";
            Query query = getSession().createQuery(hql)
                    .setParameter("status", status);
            categories = query.list();
        } catch (HibernateException e) {
            logger.error(e.getMessage());
//            throw new PersistException(e);
        }
        return categories;
    }

    public User getById(long id) {
        User User = null;
        try {
            StatusEnum status = StatusEnum.SAVED;
            @Language("HQL") String hql = "SELECT c FROM User c WHERE c.id=:id and c.status=:status";
            Query query = getSession().createQuery(hql)
                    .setParameter("id", id)
                    .setParameter("status", status);
            User = (User) query.uniqueResult();
        } catch (HibernateException e) {
            logger.error("Error get " + User.getClass().getName() + " in Dao " + e);
//            throw new PersistException(e);
        }
        return User;
    }
}

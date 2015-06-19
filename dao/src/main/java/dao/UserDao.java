package dao;

import data.util.StatusEnum;
import exception.PersistException;
import data.User;
import org.hibernate.Query;
import org.hibernate.Session;
import org.intellij.lang.annotations.Language;
import org.springframework.stereotype.Repository;


import java.util.List;

/**
* Created by ragexe on 11.04.15.
* Class for working with persistence entity of USER
*/
@Repository
public class UserDao extends AbstractDao<User> {

    public UserDao() {
        super();
    }

    @Override
    protected List<User> parseResultSet(Session session) throws PersistException {
        StatusEnum status = StatusEnum.SAVED;
        List<User> list;
        @Language("HQL") String hql = "SELECT U FROM User U WHERE U.status=:status";
        Query query = session.createQuery(hql).setParameter("status", status);
        list = query.list();
        return list;
    }

    public User getByEmail(String email) throws PersistException {
        session = getSession();
        StatusEnum status = StatusEnum.SAVED;
        User user;
        @Language("HQL") String hql = "SELECT U FROM User U WHERE U.status=:status and U.email=:email";
//        String hql = "SELECT u FROM User u WHERE u.status=:status";
        Query query = session.createQuery(hql)
                .setParameter("status", status)
                .setParameter("email", email);
        user = (User) query.uniqueResult();
        return user;
    }

    public User getById(long id) throws PersistException {
        session = getSession();
        StatusEnum status = StatusEnum.SAVED;
        User user;
        @Language("HQL") String hql = "SELECT U FROM User U WHERE U.status=:status and U.id=:id";
        Query query = session.createQuery(hql)
                .setParameter("status", status)
                .setParameter("id", id);
        user = (User) query.uniqueResult();
        return user;
    }
}

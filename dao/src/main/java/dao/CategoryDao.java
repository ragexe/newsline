package dao;

import data.Category;
import data.util.StatusEnum;
import exception.PersistException;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

import java.sql.Date;
import java.util.List;

/**
* Created by ragexe on 13.04.15.
* Class for working with persistence entity of Category
*/
public class CategoryDao extends AbstractDao<Category> {
    private static final Logger logger = Logger.getLogger(CategoryDao.class);

    /**
     * Constructor of MySqlNewsDao.class
     */
    public CategoryDao() {
        super();
    }

    @Override
    protected List<Category> parseResultSet(Session session) throws PersistException {
        StatusEnum status = StatusEnum.SAVED;
        List<Category> list;
        String hql = "SELECT C FROM Category C WHERE C.status=:status";
        Query query = session.createQuery(hql).setParameter("status", status);
        list = query.list();
        return list;
    }

    public List<Category> getList() throws PersistException{
        List<Category> Category = null;
        try {
            session = getSession();
            StatusEnum status = StatusEnum.SAVED;
            String hql = "SELECT C FROM Category C WHERE C.status=:status";
            Query query = session.createQuery(hql)
                    .setParameter("status", status);
            Category = query.list();
        } catch (HibernateException e) {
            logger.error("Error get " + Category.isEmpty() + " in Dao " + e);
            throw new PersistException(e);
        }
        return Category;
    }

    /**
     * Get Object by string cretery
     *
     * @param id     value of column in database
     * @return object
     * @throws exception.PersistException my class of exception, abstracted from relational databases
     */
    public Category getByCategoryId(long id) throws PersistException {
        Category Category = null;
        try {
            session = getSession();
            StatusEnum status = StatusEnum.SAVED;
            String hql = "SELECT P FROM Category P WHERE P.id=:id and P.status=:status";
            Query query = session.createQuery(hql)
                    .setParameter("id", id)
                    .setParameter("status", status);
            Category = (Category) query.uniqueResult();
        } catch (HibernateException e) {
            logger.error("Error get " + Category.getClass().getName() + " in Dao " + e);
            throw new PersistException(e);
        }
        return Category;
    }

}

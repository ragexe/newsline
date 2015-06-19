package dao;

import data.Category;
import data.util.StatusEnum;
import exception.PersistException;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.intellij.lang.annotations.Language;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.sql.Date;
import java.util.List;

/**
* Created by ragexe on 13.04.15.
* Class for working with persistence entity of Category
*/
@Repository
@Transactional(propagation = Propagation.MANDATORY)
public class CategoryDao {
    private static final Logger logger = Logger.getLogger(CategoryDao.class);

    /**
     * Constructor of MySqlNewsDao.class
     */
    @Resource
    private SessionFactory sessionFactory;


    protected List<Category> parseResultSet(Session session) throws PersistException {
        StatusEnum status = StatusEnum.SAVED;
        List<Category> list;
        String hql = "SELECT C FROM Category C WHERE C.status=:status";
        Query query = session.createQuery(hql).setParameter("status", status);
        list = query.list();
        return list;
    }

    public List<Category> getList() throws PersistException{
        List<Category> category = null;
        try {
            Session session = sessionFactory.getCurrentSession();
            StatusEnum status = StatusEnum.SAVED;
            @Language("HQL") String hql = "SELECT C FROM Category C WHERE C.status=:status";
            Query query = session.createQuery(hql)
                    .setParameter("status", status);
            category = query.list();
        } catch (HibernateException e) {
            logger.error("Error get " + category.isEmpty() + " in Dao " + e);
            throw new PersistException(e);
        }
        return category;
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
            Session session = sessionFactory.getCurrentSession();
            StatusEnum status = StatusEnum.SAVED;
            @Language("HQL") String hql = "SELECT c FROM Category c WHERE c.id=:id and c.status=:status";
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

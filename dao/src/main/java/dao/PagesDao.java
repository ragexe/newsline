package dao;

import data.Pages;
import data.util.StatusEnum;
import exception.PersistException;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

import java.sql.Date;
import java.util.List;


public class PagesDao extends AbstractDao<Pages> {
    private static final Logger logger = Logger.getLogger(PagesDao.class);

    /**
     * Constructor of MySqlNewsDao.class
     */
    public PagesDao() {
        super();
    }

    @Override
    protected List<Pages> parseResultSet(Session session) throws PersistException {
        StatusEnum status = StatusEnum.SAVED;
        List<Pages> list;
        String hql = "SELECT P FROM Page P WHERE P.status=:status";
        Query query = session.createQuery(hql).setParameter("status", status);
        list = query.list();
        return list;
    }


    public List<Pages> getByPersonPK(Long pK) throws PersistException{
        List<Pages> pages = null;
        try {
            session = getSession();
            StatusEnum status = StatusEnum.SAVED;
            String hql = "SELECT P FROM Page P WHERE P.author.id=:pK and P.status=:status";
            Query query = session.createQuery(hql)
                    .setParameter("pK", pK)
                    .setParameter("status", status);
            pages = query.list();
        } catch (HibernateException e) {
            logger.error("Error get " + pages.isEmpty() + " in Dao " + e);
            throw new PersistException(e);
        }
        return pages;
    }

    public List<Pages> getByCategory(Long pK) throws PersistException{
        List<Pages> pages = null;
        try {
            session = getSession();
            StatusEnum status = StatusEnum.SAVED;
            String hql = "SELECT n FROM pages WHERE n.category.categoryId=:pK and n.status=:status";
            Query query = session.createQuery(hql)
                    .setParameter("pK", pK)
                    .setParameter("status", status);
            pages = query.list();
        } catch (HibernateException e) {
            logger.error("Error get " + pages.isEmpty() + " in Dao " + e);
            throw new PersistException(e);
        }
        return pages;
    }

    public List<Pages> getListPageByParentid(long id) throws PersistException{
        List<Pages> pages = null;
        try {
            session = getSession();
            StatusEnum status = StatusEnum.SAVED;
            String hql = "SELECT P FROM Page P WHERE P.parentid=:id and P.status=:status";
            Query query = session.createQuery(hql)
                    .setParameter("id", id)
                    .setParameter("status", status);
            pages = query.list();
        } catch (HibernateException e) {
            logger.error("Error get " + pages.isEmpty() + " in Dao " + e);
            throw new PersistException(e);
        }
        return pages;
    }

    public List<Pages> getByDate(Date date) throws PersistException{
        List<Pages> pages = null;
        try {
            session = getSession();
            StatusEnum status = StatusEnum.SAVED;
            String hql = "SELECT P FROM Page P WHERE P.date=:date and P.status=:status";
            Query query = session.createQuery(hql)
                    .setParameter("date", date)
                    .setParameter("status", status);
            pages = query.list();
        } catch (HibernateException e) {
            logger.error("Error get " + pages.isEmpty() + " in Dao " + e);
            throw new PersistException(e);
        }
        return pages;
    }

    /**
     * Get Object by string cretery
     *
     * @param id     value of column in database
     * @return object
     * @throws exception.PersistException my class of exception, abstracted from relational databases
     */
    public Pages getByPageId(long id) throws PersistException {
        Pages pages = null;
        try {
            session = getSession();
            StatusEnum status = StatusEnum.SAVED;
            String hql = "SELECT P FROM Page P WHERE P.id=:id and P.status=:status";
            Query query = session.createQuery(hql)
                    .setParameter("id", id)
                    .setParameter("status", status);
            pages = (Pages) query.uniqueResult();
        } catch (HibernateException e) {
            logger.error("Error get " + pages.getClass().getName() + " in Dao " + e);
            throw new PersistException(e);
        }
        return pages;
    }

}

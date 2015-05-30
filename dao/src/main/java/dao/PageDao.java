package dao;

import data.util.StatusEnum;
import exception.PersistException;
import data.Page;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;



import java.sql.Date;
import java.util.List;

/**
* Created by ragexe on 13.04.15.
* Class for working with persistence entity of Page
*/
public class PageDao extends AbstractDao<Page> {
    private static final Logger logger = Logger.getLogger(PageDao.class);

    /**
     * Constructor of MySqlNewsDao.class
     */
    public PageDao() {
        super();
    }

    @Override
    protected List<Page> parseResultSet(Session session) throws PersistException {
        StatusEnum status = StatusEnum.SAVED;
        List<Page> list;
        String hql = "SELECT P FROM Page P WHERE P.status=:status";
        Query query = session.createQuery(hql).setParameter("status", status);
        list = query.list();
        return list;
    }


    public List<Page> getByPersonPK(Long pK) throws PersistException{
        List<Page> pages = null;
        try {
            session = getSession();
            StatusEnum status = StatusEnum.SAVED;
            String hql = "SELECT P FROM Page P WHERE P.person.personId=:pK and P.status=:status";
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

    public List<Page> getByCategory(Long pK) throws PersistException{
        List<Page> pages = null;
        try {
            session = getSession();
            StatusEnum status = StatusEnum.SAVED;
            String hql = "SELECT n FROM page WHERE n.category.categoryId=:pK and n.status=:status";
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

    public List<Page> getByDate(Date date) throws PersistException{
        List<Page> pages = null;
        try {
            session = getSession();
            StatusEnum status = StatusEnum.SAVED;
            String hql = "SELECT n FROM News n WHERE n.date=:date and n.status=:status";
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
     * @param pageId     value of column in database
     * @return object
     * @throws PersistException my class of exception, abstracted from relational databases
     */
    public Page getByPageId(String pageId) throws PersistException {
        Page pages = null;
        try {
            session = getSession();
            StatusEnum status = StatusEnum.SAVED;
            String hql = "SELECT n FROM News n WHERE n.pageId=:pageId and n.status=:status";
            Query query = session.createQuery(hql)
                    .setParameter("pageId", pageId)
                    .setParameter("status", status);
            pages = (Page) query.uniqueResult();
        } catch (HibernateException e) {
            logger.error("Error get " + pages.getClass().getName() + " in Dao " + e);
            throw new PersistException(e);
        }
        return pages;
    }

}

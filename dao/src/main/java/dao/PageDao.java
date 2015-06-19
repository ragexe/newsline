package dao;

import data.Category;
import data.util.StatusEnum;
import exception.PersistException;
import data.Page;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.intellij.lang.annotations.Language;
import org.springframework.stereotype.Repository;


import java.sql.Date;
import java.util.List;

/**
* Created by ragexe on 13.04.15.
* Class for working with persistence entity of Page
*/
@Repository
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
        @Language("HQL") String hql = "SELECT P FROM Page P WHERE P.status=:status";
        Query query = session.createQuery(hql).setParameter("status", status);
        list = query.list();
        return list;
    }


    public List<Page> getByPersonPK(Long pK) throws PersistException{
        List<Page> pages = null;
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

    public List<Page> getByCategory(Category category) throws PersistException{
        List<Page> pages = null;
        try {
            session = getSession();
            StatusEnum status = StatusEnum.SAVED;
//            @Language("HQL") String hql = "SELECT p FROM Page p WHERE p.parentid.id=:id and p.status=:status";
//            @Language("HQL") String hql = "SELECT p FROM Page p WHERE p.category.id=:categoryId and p.status=:status";
            @Language("HQL") String hql = "SELECT p FROM Page p WHERE p.status=:status AND p.category=:category" ;
            Query query = session.createQuery(hql)
                    .setParameter("category", category)
                    .setParameter("status", status);
            pages = query.list();
        } catch (HibernateException e) {
            logger.error("Error get " + pages.isEmpty() + " in Dao " + e);
            throw new PersistException(e);
        }
        return pages;
    }

    public List<Page> getByCategoryId(Long categoryId) throws PersistException{
        List<Page> pages = null;
        try {
            session = getSession();
            StatusEnum status = StatusEnum.SAVED;
//            @Language("HQL") String hql = "SELECT p FROM Page p WHERE p.parentid.id=:id and p.status=:status";
//            @Language("HQL") String hql = "SELECT p FROM Page p WHERE p.category.id=:categoryId and p.status=:status";
            @Language("HQL") String hql = "SELECT p FROM Page p WHERE p.status=:status AND p.category.id=:categoryId" ;
            Query query = session.createQuery(hql)
                    .setParameter("categoryId", categoryId)
                    .setParameter("status", status);
            pages = query.list();
        } catch (HibernateException e) {
            logger.error("Error get " + pages.isEmpty() + " in Dao " + e);
            throw new PersistException(e);
        }
        return pages;
    }

    public List<Page> getAll() throws PersistException{
        List<Page> pages = null;
        try {
            session = getSession();
            StatusEnum status = StatusEnum.SAVED;
            @Language("HQL") String hql = "SELECT p FROM Page p WHERE p.status=:status" ;
            Query query = session.createQuery(hql)
                    .setParameter("status", status);
            pages = query.list();
        } catch (HibernateException e) {
            logger.error("Error get " + pages.isEmpty() + " in Dao " + e);
            throw new PersistException(e);
        }
        return pages;
    }

    public List<Page> getListPageByParentid(long id) throws PersistException{
        List<Page> pages = null;
        try {
            session = getSession();
            StatusEnum status = StatusEnum.SAVED;
            @Language("HQL") String hql = "SELECT P FROM Page P WHERE P.category.id=:id and P.status=:status";
            Query query = session.createQuery(hql)
                    .setParameter("id", id)
                    .setParameter("status", status);
            pages = query.list();
        } catch (HibernateException e) {
            logger.error("Error get " + pages.isEmpty() + " in Dao " + e);
            logger.error(e.getMessage());
            throw new PersistException(e);
        }
        return pages;
    }

    public List<Page> getListPageByCategory(Category category) throws PersistException{
        List<Page> pages = null;
        try {
            session = getSession();
            StatusEnum status = StatusEnum.SAVED;
            @Language("HQL") String hql = "SELECT P FROM Page P WHERE P.parentid=:category and P.status=:status";
            Query query = session.createQuery(hql)
                    .setParameter("category", category)
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
     * @throws PersistException my class of exception, abstracted from relational databases
     */
    public Page getByPageId(long id) throws PersistException {
        Page page = null;
        try {
            session = getSession();
            StatusEnum status = StatusEnum.SAVED;
            String hql = "SELECT P FROM Page P WHERE P.id=:id and P.status=:status";
            Query query = session.createQuery(hql)
                    .setParameter("id", id)
                    .setParameter("status", status);
            page = (Page) query.uniqueResult();
        } catch (HibernateException e) {
            logger.error("Error get " + page.getClass().getName() + " in Dao " + e);
            throw new PersistException(e);
        }
        return page;
    }

}

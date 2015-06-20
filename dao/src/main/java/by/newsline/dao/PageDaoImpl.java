package by.newsline.dao;

import by.newsline.exception.DaoException;
import data.Page;
import data.util.StatusEnum;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.intellij.lang.annotations.Language;
import org.springframework.stereotype.Repository;

import java.util.List;


/**
 * Created by ragexe on 13.04.15.
 * Class for working with persistence entity of Page
 */
@Repository("pageDao")
public class PageDaoImpl extends AbstractDao implements IPageDao {
    private static final Logger logger = Logger.getLogger(PageDaoImpl.class);

    public void savePage(Page page) {
        persist(page);
    }

    public void deletePageById(long id) throws DaoException{
        try {
            StatusEnum status = StatusEnum.DELETED;
            @Language("HQL") String hql = "UPDATE Page SET Page.status=:status WHERE Page.id=:id";
            Query query = getSession().createQuery(hql)
                    .setParameter("status", status);
            int res = query.executeUpdate();
            if (res > 1){
                logger.warn("delete more than one line at deletePageById-method");
            }
        } catch (HibernateException e) {
            logger.error(e.getMessage());
            throw new DaoException(e);
        }
    }

    @SuppressWarnings("unchecked")
    public List<Page> getAllPages() throws DaoException{
        List<Page> pages = null;
        try {
            StatusEnum status = StatusEnum.SAVED;
            @Language("HQL") String hql = "SELECT p FROM Page p WHERE p.status=:status";
            Query query = getSession().createQuery(hql)
                    .setParameter("status", status);
            pages = query.list();
        } catch (HibernateException e) {
            logger.error(e.getMessage());
            throw new DaoException(e);
        }
        return pages;
    }

    public Page getById(long id) throws DaoException{
        Page page = null;
        try {
            StatusEnum status = StatusEnum.SAVED;
            @Language("HQL") String hql = "SELECT c FROM Page c WHERE c.id=:id and c.status=:status";
            Query query = getSession().createQuery(hql)
                    .setParameter("id", id)
                    .setParameter("status", status);
            page = (Page) query.uniqueResult();
        } catch (HibernateException e) {
            logger.error("Error get " + page.getClass().getName() + " in Dao " + e);
            throw new DaoException(e);
        }
        return page;
    }

    public List<Page> getAllPagesByCategoryId(long id)throws DaoException{
        List<Page> pages = null;
        try {
            StatusEnum status = StatusEnum.SAVED;
            @Language("HQL") String hql = "SELECT p FROM Page p WHERE p.status=:status and p.category.id=:id";
            Query query = getSession().createQuery(hql)
                    .setParameter("status", status)
                    .setParameter("id", id);
            pages = query.list();
        } catch (HibernateException e) {
            logger.error(e.getMessage());
            throw new DaoException(e);
        }
        return pages;
    }
}

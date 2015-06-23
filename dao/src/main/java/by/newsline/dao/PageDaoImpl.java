package by.newsline.dao;

import by.newsline.dao.util.exception.DaoException;
import by.newsline.data.Page;
import by.newsline.data.util.StatusEnum;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.intellij.lang.annotations.Language;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Repository("pageDao")
@Transactional(propagation = Propagation.MANDATORY)
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
            String hql = "SELECT p FROM Page p WHERE p.id=:id and p.status=:status";
            Query query = getSession().createQuery(hql)
                    .setParameter("id", id)
                    .setParameter("status", status);
            page = (Page) query.uniqueResult();
        } catch (HibernateException e) {
            logger.error(e.getMessage());
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

    public List<Page> getPagesByCriteria(int pageNumber, int pageSize, long categoryId) throws DaoException{
        List<Page> pages = null;
        try {
            StatusEnum status = StatusEnum.SAVED;
            @Language("HQL") String hql = "SELECT p FROM Page p WHERE p.status=:status and p.category.id=:categoryId ORDER BY p.date DESC";
            Query query = getSession().createQuery(hql)
                    .setParameter("status", status)
                    .setParameter("categoryId", categoryId)
                    .setFirstResult((pageNumber - 1) * pageSize)
                    .setMaxResults(pageSize);
            pages = query.list();
        } catch (HibernateException e) {
            logger.error(e.getMessage());
            throw new DaoException(e);
        }
        return pages;
    }
}

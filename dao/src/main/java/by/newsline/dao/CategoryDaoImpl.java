package by.newsline.dao;

import by.newsline.dao.util.exception.DaoException;
import data.Category;
import data.util.StatusEnum;

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
import java.util.List;


/**
 * Created by ragexe on 13.04.15.
 * Class for working with persistence entity of Category
 */
@Repository("categoryDao")
@Transactional(propagation = Propagation.MANDATORY)
public class CategoryDaoImpl extends AbstractDao implements ICategoryDao{
    private static final Logger logger = Logger.getLogger(CategoryDaoImpl.class);

    @Resource
    private SessionFactory sessionFactory;

    public void saveCategory(Category category) throws DaoException {
        Session session = sessionFactory.getCurrentSession();
        session.save(category);
        /*try{
            Session session = sessionFactory.getCurrentSession();
            session.save(category);
        }catch (HibernateException e) {
            logger.error(e.getMessage());
        }*/
    }

    public void deleteCategoryById(long id) throws DaoException {
        /*try {
            StatusEnum status = StatusEnum.DELETED;
            @Language("HQL") String hql = "UPDATE Category SET Category.status=:status WHERE Category.id=:id";
            Query query = getSession().createQuery(hql)
                    .setParameter("status", status);
            int res = query.executeUpdate();
            if (res > 1){
                logger.warn("delete more than one line at deleteCategoryById-method");
            }
        } catch (HibernateException e) {
            logger.error(e.getMessage());
//            throw new PersistException(e);
        }*/
        Session session = getSession();
        Category category = (Category) session.load(Category.class, id);
        category.setStatus(StatusEnum.DELETED);
        session.update(category);


    }

    @SuppressWarnings("unchecked")
    public List<Category> getAllCategories() throws DaoException {
        List<Category> categories = null;
        try {
            StatusEnum status = StatusEnum.SAVED;
            @Language("HQL") String hql = "SELECT C FROM Category C WHERE C.status=:status";
            Query query = getSession().createQuery(hql)
                    .setParameter("status", status);
            categories = query.list();
        } catch (HibernateException e) {
            logger.error(e.getMessage());
            throw new DaoException(e);
        }
        return categories;
    }

    public Category getById(long id) throws DaoException {
        Category Category = null;
        try {
            StatusEnum status = StatusEnum.SAVED;
            @Language("HQL") String hql = "SELECT c FROM Category c WHERE c.id=:id and c.status=:status";
            Query query = getSession().createQuery(hql)
                    .setParameter("id", id)
                    .setParameter("status", status);
            Category = (Category) query.uniqueResult();
        } catch (HibernateException e) {
            logger.error("Error get " + Category.getClass().getName() + " in Dao " + e);
//            throw new PersistException(e);
        }
        return Category;
    }
}

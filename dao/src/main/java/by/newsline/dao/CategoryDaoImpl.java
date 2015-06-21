package by.newsline.dao;

import by.newsline.dao.util.exception.DaoException;
import by.newsline.data.Category;
import by.newsline.data.util.StatusEnum;
import org.apache.log4j.Logger;
import org.hibernate.*;
import org.intellij.lang.annotations.Language;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;


@Repository("categoryDao")
@Transactional(propagation = Propagation.MANDATORY)
public class CategoryDaoImpl extends AbstractDao implements ICategoryDao{
    private static final Logger logger = Logger.getLogger(CategoryDaoImpl.class);

    @Resource
    private SessionFactory sessionFactory;

    public void saveCategory(Category category) throws DaoException {
        Session session = getSession();
        session.save(category);
    }

    public void deleteCategoryById(long id) throws DaoException {
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
        /*Session session = getSession();
        StatusEnum status = StatusEnum.SAVED;
        Criteria criteria = session.createCriteria(Category.class);
        criteria.add(Restrictions.eq("SAVED", status));
        List<Category> result = criteria.list();
        return result;*/
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
        }
        return Category;
    }
}

package by.newsline.dao;

import data.Category;
import data.util.StatusEnum;
//import exception.PersistException;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.intellij.lang.annotations.Language;
import org.springframework.stereotype.Repository;
import java.util.List;
//import com.websystique.springmvc.model.CategoryDaoImpl;

/**
 * Created by ragexe on 13.04.15.
 * Class for working with persistence entity of Category
 */
@Repository("categoryDao")
public class CategoryDaoImpl extends AbstractDao implements ICategoryDao{
    private static final Logger logger = Logger.getLogger(CategoryDaoImpl.class);

    public void saveCategory(Category category) {
        persist(category);
    }

    public void deleteCategoryById(long id) {
        try {
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
        }
    }

    @SuppressWarnings("unchecked")
    public List<Category> getAllCategories() {
        List<Category> categories = null;
        try {
            StatusEnum status = StatusEnum.SAVED;
            @Language("HQL") String hql = "SELECT C FROM Category C WHERE C.status=:status";
            Query query = getSession().createQuery(hql)
                    .setParameter("status", status);
            categories = query.list();
        } catch (HibernateException e) {
            logger.error(e.getMessage());
//            throw new PersistException(e);
        }
        return categories;
    }

    public Category getById(long id) {
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

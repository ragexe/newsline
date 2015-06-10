package util;

import dao.PageDao;
import daofactory.DaoFactoryImpl;
import daofactory.IDaoFactory;
import data.Page;
import exception.PersistException;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

/**
 * Created by HappyQ on 10.06.2015.
 */
public class CategoryService implements ICategoryService {
    private static final Logger logger = Logger.getLogger(CategoryService.class);

    private static CategoryService categoryServiceInst;
    private PageDao pageDao;

    private final ThreadLocal sessionStatus = new ThreadLocal();
    private Session session;
    private Transaction transaction;


    private CategoryService() {
        IDaoFactory factory = DaoFactoryImpl.getInstance();
        try {
            pageDao = (PageDao) factory.getDao(Page.class);
        } catch (PersistException e) {
            logger.error(e);
        }
    }

    @Override
    public Page getPageByPageId(long id) {
        Page page = null;
//        if (!(StringUtils.isNullOrEmpty(id))) {
        if (id != -2){
            try {
                session = pageDao.getSession();
                transaction = session.beginTransaction();
                page = pageDao.getByPageId(id);
                transaction.commit();
            } catch (HibernateException e) {
                logger.error("Error get list of Categories from database" + e);
                transaction.rollback();
            } catch (PersistException e) {
                logger.error(e);
            }finally {
                sessionStatus.set(true);
                pageDao.clearSession(sessionStatus);
            }
        }
        return page;
    }

    @Override
    public List<Page> getListPageByParentid(long id) {
        List<Page> pages = null;
        try {
            session = pageDao.getSession();
            transaction = session.beginTransaction();
            pages = pageDao.getListPageByParentid(id);
            transaction.commit();
        } catch (HibernateException e) {
            logger.error("Error get list of parentid from database" + e);
            transaction.rollback();
        } catch (PersistException e) {
            logger.error(e);
        }finally {
            sessionStatus.set(true);
            pageDao.clearSession(sessionStatus);
        }
        return pages;
    }
    public static synchronized CategoryService getInstance() {
        if (categoryServiceInst == null) {
            categoryServiceInst = new CategoryService();
        }
        return categoryServiceInst;
    }
}

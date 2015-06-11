package util;


import dao.PagesDao;
import daofactory.DaoFactoryImpl;
import daofactory.IDaoFactory;
import data.Pages;
import data.util.StatusEnum;
import exception.PersistException;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

/**
 * Created by HappyQ on 11.06.2015.
 */
public class PagesService implements IPagesService {
    private static final Logger logger = Logger.getLogger(PageService.class);

    private static PagesService pagesServiceInst;
    private PagesDao pagesDao;

    private final ThreadLocal sessionStatus = new ThreadLocal();
    private Session session;
    private Transaction transaction;

    private PagesService() {
        IDaoFactory factory = DaoFactoryImpl.getInstance();
        try {
            pagesDao = (PagesDao) factory.getDao(Pages.class);
        } catch (PersistException e) {
            logger.error(e);
        }
    }
    /**
     * -=SINGLETON=-
     * Method for creating fabric
     * 1. First, you must create an instance factory or get it, and then through it to create Dao objects to the entity
     * over which you plan to perform CRUD operations.
     *
     * @return instance of CommentaryService
     */
    public static synchronized PagesService getInstance() {
        if (pagesServiceInst == null) {
            pagesServiceInst = new PagesService();
        }
        return pagesServiceInst;    }




    @Override
    public List<Pages> getListOfPageByCategory(Long categoryId) {
        List<Pages> pages = null;
        try {
            session = pagesDao.getSession();
            transaction = session.beginTransaction();
            pages = pagesDao.getByCategory(categoryId);
            transaction.commit();
        } catch (HibernateException e) {
            logger.error("Error get list of Categories from database" + e);
            transaction.rollback();
        } catch (PersistException e) {
            logger.error(e);
        }finally {
            sessionStatus.set(true);
            pagesDao.clearSession(sessionStatus);
        }
        return pages;
    }


    @Override
    public List<Pages> getListPageByParentid(long id) {
        List<Pages> pages = null;
        try {
            session = pagesDao.getSession();
            transaction = session.beginTransaction();
            pages = pagesDao.getListPageByParentid(id);
            transaction.commit();
        } catch (HibernateException e) {
            logger.error("Error get list of parentid from database" + e);
            transaction.rollback();
        } catch (PersistException e) {
            logger.error(e);
        }finally {
            sessionStatus.set(true);
            pagesDao.clearSession(sessionStatus);
        }
        return pages;
    }
    @Override
    public Pages getPageByPageId(long id) {
        Pages pages = null;
//        if (!(StringUtils.isNullOrEmpty(id))) {
        if (id != -2){
            try {
                session = pagesDao.getSession();
                transaction = session.beginTransaction();
                pages = pagesDao.getByPageId(id);
                transaction.commit();
            } catch (HibernateException e) {
                logger.error("Error get list of Categories from database" + e);
                transaction.rollback();
            } catch (PersistException e) {
                logger.error(e);
            }finally {
                sessionStatus.set(true);
                pagesDao.clearSession(sessionStatus);
            }
        }
        return pages;
    }
}

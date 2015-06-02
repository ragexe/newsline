package util;


import com.mchange.lang.LongUtils;
import com.mysql.jdbc.StringUtils;
import dao.PageDao;
import daofactory.DaoFactoryImpl;
import daofactory.IDaoFactory;
import data.Page;
import data.util.StatusEnum;
import exception.PersistException;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ragexe on 29.04.15.
 * util.Service layer for domain entity Page
 */
public class PageService implements IPageService {
    private static final Logger logger = Logger.getLogger(PageService.class);

    private static PageService pageServiceInst;
    private PageDao pageDao;

    private final ThreadLocal sessionStatus = new ThreadLocal();
    private Session session;
    private Transaction transaction;

    private PageService() {
        IDaoFactory factory = DaoFactoryImpl.getInstance();
        try {
            pageDao = (PageDao) factory.getDao(Page.class);
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
    public static synchronized PageService getInstance() {
        if (pageServiceInst == null) {
            pageServiceInst = new PageService();
        }
        return pageServiceInst;
    }


    @Override
    public Page getPageByPK(Long PK) {
        Page page = null;
        try {
            session = pageDao.getSession();
            transaction = session.beginTransaction();
            page = pageDao.getByPK(PK);
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
        return page;
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
    public List<Page> getListOfPageByPersonId(Long personId) {
        List<Page> pages = null;
        try {
            session = pageDao.getSession();
            transaction = session.beginTransaction();
            pages = pageDao.getByPersonPK(personId);
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
        return pages;
    }

    @Override
    public List<Page> getListOfPageByCategory(Long categoryId) {
        List<Page> pages = null;
        try {
            session = pageDao.getSession();
            transaction = session.beginTransaction();
            pages = pageDao.getByCategory(categoryId);
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
        return pages;
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
    @Override
    public Long savePage(Page page) {
        Long savedPageId = null;
        try {
            session = pageDao.getSession();
            transaction = session.beginTransaction();
            page.setStatus(StatusEnum.SAVED);
//            savedPageId = pageDao.save(page);
            pageDao.save(page);
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
        return savedPageId;
    }

    @Override
    public Page updatePage(Page page) {
        if (0 != page.getId()) {
            Long deletedPageId = page.getId();
            try {
                session = pageDao.getSession();
                transaction = session.beginTransaction();
                page.setStatus(StatusEnum.SAVED);
                pageDao.update(page);
                page = (Page) session.get(Page.class, deletedPageId);
                transaction.commit();
            } catch (HibernateException e) {
                logger.error("Error delete category from database:   " + e);
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
    public Page deletePage(Page page) {
        if (0 != page.getId()) {
            Long deletedPageId = page.getId();
            try {
                session = pageDao.getSession();
                transaction = session.beginTransaction();
                page.setStatus(StatusEnum.DELETED);
                pageDao.update(page);
                page = (Page) session.get(Page.class, deletedPageId);
                transaction.commit();
            } catch (HibernateException e) {
                logger.error("Error delete category from database:   " + e);
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
    public void removePage(Page page) {

    }

    /**
     * REFACTOR THIS METHOD
     */
//    @Override
//    public List<Page> getMostPopularPageList() {
//        List<Page> pageList = new ArrayList<>();
//        for (int i = ServiceConstants.Const.ZERO; i < 4; ) {
//            Page page;
//            Long randomId = (long) (Math.random() * 60 + 11); // вещественное число из [3;8)
//            try {
//                page = pageDao.getByPK(randomId);
//                if (page != null && page.getId() != null) {
//                    pageList.add(page);
//                    i++;
//                }
//            } catch (PersistException e) {
//                logger.error(e);
//            }finally {
//                sessionStatus.set(true);
//                pageDao.clearSession(sessionStatus);
//            }
//        }
//        return pageList;
//    }
}

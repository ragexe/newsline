package by.newsline.service;


import dao.PageDao;
import daofactory.DaoFactoryImpl;
import daofactory.IDaoFactory;
import data.Category;
import data.Page;
import data.util.StatusEnum;
import exception.PersistException;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by HappyQ on 29.04.15.
 * util.Service layer for domain entity Page
 */
@Service
public class PageService implements IPageService {
    private static final Logger logger = Logger.getLogger(PageService.class);

    private static PageService pageServiceInst;
    @Autowired
    private PageDao pageDao;


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
    /*public static synchronized PageService getInstance() {
        if (pageServiceInst == null) {
            pageServiceInst = new PageService();
        }
        return pageServiceInst;
    }*/


    @Override
    @Transactional
    public Page getPageByPK(Long PK) {
        Page page = null;
        try {
            page = pageDao.getByPK(PK);
        } catch (PersistException e) {
            logger.error(e);
        }
        return page;
    }

    @Override
    public Page getPageByPageId(long id) {
        Page page = null;
        if (id != -2){
            try {
                page = pageDao.getByPageId(id);
            } catch (PersistException e) {
                logger.error(e);
            }
        }
        return page;
    }

    @Override
    @Transactional
    public List<Page> getListOfPageByPersonId(Long personId) {
        List<Page> pages = null;
        try {
            pages = pageDao.getByPersonPK(personId);
        } catch (PersistException e) {
            logger.error(e);
        }
        return pages;
    }

    @Override
    @Transactional
    public List<Page> getListOfPageByCategory(Category category) {
        List<Page> pages = null;
        try {
            pages = pageDao.getByCategory(category);
        }catch (PersistException e) {
            logger.error(e);
        }
        return pages;
    }

    @Override
    @Transactional
    public List<Page> getListOfPageByCategoryId(long categoryId) {
        List<Page> pages = null;
        try {
            pages = pageDao.getByCategoryId(categoryId);
        } catch (PersistException e) {
            logger.error(e);
        }
        return pages;
    }

    @Override
    public List<Page> getAllPages() {
        List<Page> pages = null;
        try {
            pages = pageDao.getAll();
        } catch (PersistException e) {
            logger.error(e);
        }
        return pages;
    }

    @Override
    @Transactional
    public Long savePage(Page page) {
        Long savedPageId = null;
        try {
            page.setStatus(StatusEnum.SAVED);
            pageDao.save(page);
        }catch (PersistException e) {
            logger.error(e);
        }
        return savedPageId;
    }

    @Override
    @Transactional
    public Page updatePage(Page page) {
        if (0 != page.getId()) {
            try {
                page.setStatus(StatusEnum.SAVED);
                pageDao.update(page);
            } catch (PersistException e) {
                logger.error(e);
            }
        }
        return page;
    }

    @Override
    @Transactional
    public Page deletePage(Page page) {
        if (0 != page.getId()) {
            Long deletedPageId = page.getId();
            try {
                page.setStatus(StatusEnum.DELETED);
                pageDao.update(page);
            } catch (PersistException e) {
                logger.error(e);
            }
        }
        return page;
    }

    @Override
    @Transactional
    public void removePage(Page page) {

    }

    /**
     * REFACTOR THIS METHOD
     */
//
}

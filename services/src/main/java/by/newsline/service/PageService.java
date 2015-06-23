package by.newsline.service;


import by.newsline.dao.ICategoryDao;
import by.newsline.dao.IPageDao;
import by.newsline.dao.util.exception.DaoException;
import by.newsline.service.util.exception.ServiceException;
import by.newsline.data.Page;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Date;
import java.util.List;

//import by.newsline.dao.util.exception.PersistException;

/**
* Created by HappyQ on 29.04.15.
* util.Service layer for domain entity Page
*/
@Service
@Transactional(propagation = Propagation.REQUIRED)
public class PageService implements IPageService {
    private static final Logger logger = Logger.getLogger(PageService.class);

    @Autowired
    private IPageDao pageDao;

    @Autowired
    private ICategoryDao categoryDao;

    public void savePage(Page page) throws ServiceException{
        java.util.Date date = new java.util.Date();
        page.setDate(new Date(date.getTime()));
        try {
            pageDao.savePage(page);
        } catch (DaoException e) {
            logger.error(e.getMessage());
            throw new ServiceException(e);
        }
    }

    public void deletePageById(long id) throws ServiceException{
        try {
            pageDao.deletePageById(id);
        } catch (DaoException e) {
            logger.error(e.getMessage());
            throw new ServiceException(e);
        }
    }

    public Page getById(long id) throws ServiceException{
        try {
            return pageDao.getById(id);
        } catch (DaoException e) {
            logger.error(e.getMessage());
            throw new ServiceException(e);
        }
    }

    public List<Page> getAllPages() throws ServiceException{
        try {
            return pageDao.getAllPages();
        } catch (DaoException e) {
            logger.error(e.getMessage());
            throw new ServiceException(e);
        }
    }

    public List<Page> getAllPagesByCategoryId(long id) throws ServiceException{
        try {
            return pageDao.getAllPagesByCategoryId(id);
        } catch (DaoException e) {
            logger.error(e.getMessage());
            throw new ServiceException(e);
        }
    }

    public List<Page> getPagesByCriteria(int pageNumber, int pageSize, long categoryId) throws ServiceException{
        try {
            return pageDao.getPagesByCriteria(pageNumber, pageSize, categoryId);
        } catch (DaoException e) {
            logger.error(e.getMessage());
            throw new ServiceException(e);
        }
    }

    @Override
    public void savePage(long categoryId, Page page) throws ServiceException {
        try{
            page.setCategory(categoryDao.getById(categoryId));
            savePage(page);
        }catch(DaoException e){
            logger.error(e.getMessage());
            throw new ServiceException(e);
        }
    }
}

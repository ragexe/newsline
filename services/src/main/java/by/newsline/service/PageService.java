package by.newsline.service;



import by.newsline.dao.PageDaoImpl;
import by.newsline.exception.DaoException;
import by.newsline.service.util.exception.ServiceException;
import data.Page;
//import by.newsline.exception.PersistException;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

/**
* Created by HappyQ on 29.04.15.
* util.Service layer for domain entity Page
*/
@Service
@Transactional(propagation = Propagation.REQUIRED)
public class PageService implements IPageService {
    private static final Logger logger = Logger.getLogger(PageService.class);

    @Autowired
    private PageDaoImpl pageDao;

    public void savePage(Page page) throws ServiceException{
        pageDao.savePage(page);
    }

    public void deletePageById(long id) throws ServiceException{
        try {
            pageDao.deletePageById(id);
        } catch (DaoException e) {
            logger.error(e.getMessage());
            throw new ServiceException();
        }
    }

    public Page getById(long id) throws ServiceException{
        try {
            return pageDao.getById(id);
        } catch (DaoException e) {
            logger.error(e.getMessage());
            throw new ServiceException();
        }
    }

    public List<Page> getAllPages() throws ServiceException{
        try {
            return pageDao.getAllPages();
        } catch (DaoException e) {
            logger.error(e.getMessage());
            throw new ServiceException();
        }
    }

    public List<Page> getAllPagesByCategoryId(long id) throws ServiceException{
        try {
            return pageDao.getAllPagesByCategoryId(id);
        } catch (DaoException e) {
            logger.error(e.getMessage());
            throw new ServiceException();
        }
    }
}

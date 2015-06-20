package by.newsline.service;


import by.newsline.dao.CategoryDaoImpl;
import by.newsline.exception.DaoException;
import by.newsline.service.util.exception.ServiceException;
import data.Category;
//import by.newsline.exception.PersistException;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by HappyQ on 10.06.2015.
 */
@Service
@Transactional(propagation = Propagation.REQUIRED)
public class CategoryService implements ICategoryService {
    private static final Logger logger = Logger.getLogger(CategoryService.class);

    @Autowired
    private CategoryDaoImpl categoryDao;

    public void saveCategory(Category category) throws ServiceException{
        try {
            categoryDao.saveCategory(category);
        } catch (DaoException e) {
            logger.error(e.getMessage());
            throw new ServiceException(e);
        }
    }

    public void deleteCategoryById(long id) throws ServiceException {
        try {
            categoryDao.deleteCategoryById(id);
        } catch (DaoException e) {
            logger.error(e.getMessage());
            throw new ServiceException(e);
        }
    }

    public Category getById(long id) throws ServiceException{
        try {
            return categoryDao.getById(id);
        } catch (DaoException e) {
            logger.error(e.getMessage());
            throw new ServiceException();
        }
    }

    public List<Category> getAllCategories() throws ServiceException{
        try {
            return categoryDao.getAllCategories();
        } catch (DaoException e) {
            logger.error(e.getMessage());
            throw new ServiceException();
        }
    }
}

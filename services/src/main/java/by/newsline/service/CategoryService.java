package by.newsline.service;

import by.newsline.dao.ICategoryDao;
import by.newsline.dao.util.exception.DaoException;
import by.newsline.service.util.exception.ServiceException;
import by.newsline.data.Category;
import by.newsline.data.util.StatusEnum;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(propagation = Propagation.REQUIRED)
public class CategoryService implements ICategoryService {
    private static final Logger logger = Logger.getLogger(CategoryService.class);

    @Autowired
    private ICategoryDao categoryDao;

    public void saveCategory(Category category) throws ServiceException{
        category.setStatus(StatusEnum.SAVED);
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

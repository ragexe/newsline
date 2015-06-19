package by.newsline.service;

import dao.CategoryDao;
import data.Category;
import exception.PersistException;
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

    private static CategoryService categoryServiceInst;
    @Autowired
    private CategoryDao categoryDao;


    @Override
    public List<Category> getList() {
        List<Category> pages = null;
        try {
            pages = categoryDao.getList();
        } catch (PersistException e) {
            logger.error(e);
        }
        return pages;
    }

    @Override
    public Category getCategoryById(long id) {
        Category category = null;
        try {
            category = categoryDao.getByCategoryId(id);
        } catch (PersistException e) {
            logger.error(e);
        }
        return category;
    }
    
    /*public static synchronized CategoryService getInstance() {
        if (categoryServiceInst == null) {
            categoryServiceInst = new CategoryService();
        }
        return categoryServiceInst;
    }*/
}

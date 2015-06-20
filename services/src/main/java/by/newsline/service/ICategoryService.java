package by.newsline.service;

import by.newsline.service.util.exception.ServiceException;
import data.Category;


import java.util.List;

/**
 * Created by HappyQ on 10.06.2015.
 */
public interface ICategoryService {
    void saveCategory(Category category) throws ServiceException;
    void deleteCategoryById(long id) throws ServiceException;
    Category getById(long id) throws ServiceException;
    List<Category> getAllCategories() throws ServiceException;
}

package by.newsline.service;

import by.newsline.service.util.exception.ServiceException;
import by.newsline.data.Category;


import java.util.List;

public interface ICategoryService {
    void saveCategory(Category category) throws ServiceException;
    void deleteCategoryById(long id) throws ServiceException;
    Category getById(long id) throws ServiceException;
    List<Category> getAllCategories() throws ServiceException;



}

package by.newsline.dao;

import by.newsline.exception.DaoException;
import data.Category;
//import by.newsline.exception.PersistException;
//import com.websystique.springmvc.model.Category;
import java.util.List;

public interface ICategoryDao{

    void saveCategory(Category category)throws DaoException;
    void deleteCategoryById(long id) throws DaoException;
    Category getById(long id) throws DaoException;
    List<Category> getAllCategories() throws DaoException;
}

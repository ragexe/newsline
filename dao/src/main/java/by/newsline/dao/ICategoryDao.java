package by.newsline.dao;

import data.Category;
//import exception.PersistException;
//import com.websystique.springmvc.model.Category;
import java.util.List;

public interface ICategoryDao{

    void saveCategory(Category category);

    void deleteCategoryById(long id);

    Category getById(long id);

    List<Category> getAllCategories();
}

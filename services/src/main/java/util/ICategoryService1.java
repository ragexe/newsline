package util;

import data.Category;

import java.util.List;

/**
 * Created by HappyQ on 10.06.2015.
 */
public interface ICategoryService1 {

    void saveCategory(Category category);

    void deleteCategoryById(long id);

    Category getById(long id);

    List<Category> getAllCategories();
}
